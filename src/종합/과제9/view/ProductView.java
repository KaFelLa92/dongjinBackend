package 종합.과제9.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    // (*) 싱글톤
    private ProductView (){}
    public static final ProductView instance = new ProductView();
    public static ProductView getInstance(){
        return instance;
    }

    // (*) 입력 객체 생성
    private Scanner scan = new Scanner(System.in);

    // (*) 메인 화면
    public void index(){
        for(;;){
            try{
                System.out.println("================  가장 빠른 중고시장 뚝딱마켓  홈 화면 ================");
                System.out.println("1. 중고물품등록 | 2. 물품목록조회 | 3. 등록랭킹 | 4. 상세검색 | 5. 앱 종료");
                System.out.println("==================================================================");

            }catch (InputMismatchException e){
                System.out.println("[경고] 정수를 입력해주세요. <다시 입력>");
                scan = new Scanner(System.in); // 입력객체 초기화로 오류 데이터 지우기
            } catch (Exception e){
                System.out.println("[오류] 관리자에게 문의해주세요.");
            }
        } // for end
    } // index end

}
