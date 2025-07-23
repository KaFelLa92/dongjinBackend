package 종합.예제10.model.dao;

import 종합.예제10.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDao {
    // (*) 싱글톤
    private BoardDao (){
        connect(); // connect() 생성자에 들어가 있어야 등록 가능
    }
    public static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }

    // (*) DB 연동
    // 1. 연결할 곳 정보 쓰기
    private String db_url = "jdbc:mysql://localhost:3306/exam10";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 2. 연동 함수
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url , db_user ,db_password);
        } catch (Exception e){
            System.out.println(e);
        }
    } // func end
    
    // (1) 등록 기능 구현
    public boolean boardWrite(BoardDto boardDto){
        // boolean              : 해당 메소드 실행 결과를 true(저장성공) false(저장실패) 반환하기위한 타입
        // BoardDto boardDto    : controller로부터 저장할 값들을 dto로 구성해서 받는 매개변수
        try {
            // 1. SQL 작성한다.
            String sql = "insert into board( bcontent , bwriter) values (? , ?); ";
            // 2. SQL 기재한다.
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 매개변수 대입
            ps.setString( 1, boardDto.getBcontent());   // SQL내 1번 ?에 매개변수로 받은 boardDto의 bcontent 값 대입
            ps.setString( 2 , boardDto.getBwriter());   // SQL내 2번 ?에 매개변수로 받은 boardDto의 bwriter 값 대입
            // 4. SQL 실행 , insert/update/delete는 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count >= 1){
                return true;    // 1개 이상 insert하면 저장 성공
            } else {
                return false;   // 1개 미만 insert면 저장 실패
            }
        }catch (Exception e){
            System.out.println("[경고] DB 등록 실패" + e);
        } // catch end
        return false;   // catch 못 뚫으면 저장 실패
    } // func end

    // (2)

} // class end
