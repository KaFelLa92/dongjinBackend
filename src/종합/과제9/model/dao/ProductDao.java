package 종합.과제9.model.dao;


import 종합.과제9.model.dto.ProductDto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
    // (*) 싱글톤
    private ProductDao() {
        connect(); // 이거 생성자에 꼭 넣어줘야 호출할 때 연동되니까 기억
    }

    public static final ProductDao instance = new ProductDao();

    public static ProductDao getInstance() {
        return instance;
    }

    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/usedMarket";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 드라이버매니저 연동 함수
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            System.out.println(e);
        }
    } // func end

    // (1) 중고 물품 등록 productAdd()
    /*
    1. 판매자닉네임, 판매자비밀번호, 물품명, 물품설명, 물품가격, 입력 받아 저장.
    2. 판매여부 판매중으로 저장한다.
    3. 등록일 현재 날짜/시간으로 저장한다.
    4. 매개변수
    String pname
    String pcontent
    int pprice
    String paka
    String ppwd
    5. boolean 타입 반환
     */
    public boolean productAdd(ProductDto productDto) {
        try {
            // 1. SQL 작성
            String sql = "INSERT INTO product(pname, pcontent, pprice, paka, ppwd) VALUES (?, ?, ?, ?, ?);";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1, productDto.getPname());
            ps.setString(2, productDto.getPcontent());
            ps.setInt(3, productDto.getPprice());
            ps.setString(4, productDto.getPaka());
            ps.setString(5, productDto.getPpwd());
            // 4. SQL 실행 : select 만 executeQuery(), 나머진 executeUpdate()
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if (count >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } // catch end
        return false;
    } // func end

    // (2) 전체 물품 목록 조회 productPrint()
    /*
    1. DB에 저장된 판매자닉네임, 물품명, 물품설명,
    물품가격, 판매여부, 등록일 정보(dto) 호출한다.
    2. ArrayList<ProductDto> 타입 반환
    pno ,pname ,  pcontent , pprice , pboolean , pdate , paka 순으로 출력한다.
     */

    public ArrayList<ProductDto> productPrint() {
        // try-catch 구문 밖에 어레이리스트 변수 생성. 변수 메소드 외부로 리턴.
        ArrayList<ProductDto> list = new ArrayList<>();
        try {
            // 1. SQL 작성
            String sql = "select * from product";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            // 4. SQL 실행 select는 executeQuery()
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            while (rs.next()) { // next() : 남은 게 없을 때까지(next가 없을 때까지) while
                int pno = rs.getInt("pno");
                String pname = rs.getString("pname");
                String pcontent = rs.getString("pcontent");
                int pprice = rs.getInt("pprice");
                boolean pboolean = rs.getBoolean("pboolean");
                String pdate = rs.getString("pdate");
                String paka = rs.getString("paka");
                // 레코드 1개를 dto 타입으로 객체 저장
                ProductDto productDto = new ProductDto(pno, pname, pcontent, pprice, pboolean, pdate, paka);
                // 배열리스트 타입 리스트 변수에 담기
                list.add(productDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;    // list 배열을 컨트롤러로 보내기
    } // func end


    // (3) 물품 정보 수정 productUpdate()
    /*
    1. 물품 상세 화면에서 물품번호 및 비밀번호를 입력한다.
    2. 성공하면 물품명, 물품설명, 물품가격, 판매여부를 입력받아 수정한다.
    3. 매개변수
    int pno
    String ppwd
    String pname
    String pcontent
    int pprice
    boolean pboolean
    4. boolean 타입 반환
     */

    public boolean productUpdate(ProductDto productDto) {
        try {
            // 1. SQL 작성
            String sql = "update product set pname = ? , pcontent = ? , pprice = ? , pboolean = ? where pno = ? and ppwd = ?;";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입, SQL 문법내 ? 개수만큼
            ps.setString(1, productDto.getPname());
            ps.setString(2, productDto.getPcontent());
            ps.setInt(3, productDto.getPprice());
            ps.setBoolean(4, productDto.isPboolean());
            ps.setInt(5, productDto.getPno());
            ps.setString(6, productDto.getPpwd());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과 로직/리턴/확인
            if (count == 1) {
                return true; // 결과 1이면 수정 성공
            } else {
                return false; // 1 아니면 수정 실패
            }
        } catch (Exception e) {
            System.out.println(e);
        } //catch end
        return false; // catch에서 막히면 수정 실패
    } // func end

    // (4) 등록 물품 삭제 productDelete()
    /*
    1. 물품 상세 화면에서 물품번호 및 비밀번호를 입력한다.
    2. 성공하면 DB의 해당 레코드를 영구 삭제한다.
    3. 매개변수
    int pno
    String ppwd
    4. boolean 타입 반환
     */

    public boolean productDelete(ProductDto productDto) {
        try {
            // 1. SQL 작성
            String sql = "delete from product where pno = ? and ppwd = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1, productDto.getPno());
            ps.setString(2, productDto.getPpwd());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if (count == 1) {
                return true; // SQL 결과 1이면 삭제
            }

        } catch (Exception e) {
            System.out.println(e);
        } // catch end
        return false;
    } // func end

    // (*) pno와 비밀번호 체크(조회) 메소드
    public boolean checkProduct(ProductDto productDto) { // 유효성 검사
        try{
            // 1. SQL 작성
            String sql = "select * from product where pno = ? and ppwd = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1, productDto.getPno());
            ps.setString(2, productDto.getPpwd());
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과 확인
            if (rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        } // catch end
        return false;
    } //

    // (5) 익명 문의 남기기 inquiryAdd()
    /*
    1. 물품 상세 화면에서 물품번호를 입력한다.
    2. 입력한 물품번호, 문의자닉네임, 문의내용, 비밀번호를 입력 받아 저장한다.
    3. 등록일 현재 날짜/시간으로 저장한다.
    4. 매개변수
    ino pno
    String iaka
    String ipwd
    String icontent
    5. boolean 타입 반환
     */

    // (6) 물품 상세 조회 productPrintDetail()
    /*
    1. 물품 목록 조회 화면에서 물품번호를 입력한다.
    2. 물품번호와 같은 레코드에 저장된 판매자닉네임, 물품명, 물품설명,
    물품가격, 판매여부, 등록일 정보(dto) 호출한다.
    3. 물품번호를 교집합으로 사용하는 문의자닉네임, 문의내용을 호출한다.
    (*) 물품 상세 화면으로 이동한다.
    4. 매개변수
    int pno
    5. ProductDto 타입 반환
     */

    // (7) 등록 랭킹 조회 rankPrint()
    /*
    1. DB에서 판매자닉네임이 가장 많은 순(내림차순)으로 출력.
    2. 판매자닉네임의 총 합계를 닉네임 옆에 출력한다.
    3. ArrayList<ProductDto> 타입 반환
     */

    // (8) 검색 조회 searchPrint()
    /*
    1. 사용자에게 문자열로 검색어를 입력받는다.
    2. 해당 문자열이 물품명 또는 설명에 포함되어 있는지 찾는다.
    3. 레코드의 물품명, 가격, 닉네임, 등록일, 판매여부를 최신 등록일로 출력한다.
    4. ArrayList<ProductDto> 타입 반환
     */


} // class end


