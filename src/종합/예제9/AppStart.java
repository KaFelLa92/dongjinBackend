package 종합.예제9; // package name

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;
import 종합.예제9.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 1. 프로젝트와 패키지 세팅 < 라이브러리 세팅 >
        // 2. 작업에 필요한 MVC 패턴 클래스 선언
        // 3. DTO 제외한 싱글톤 선언
        // 4. DTO 속성(멤버변수, 생성자, 메소드 투스트링 게터앤세터) dao(DB 제외)
        
        // view 작업 전 컨트롤러/dao 테스트
        // (1) 컨트롤러 싱글톤 가져오기
        // BoardController bc = BoardController.getInstance();
        // (2) 주석 처리하면서 단위 기능 테스트
            // 1) 등록 테스트
//        boolean result1 = bc.boardWrite("안녕하시렵니까." , "신동엽");
//        System.out.println(result1);
            // 2) 전체조회 테스트
//        ArrayList<BoardDto> result2 = bc.boardPrint();
//        System.out.println(result2);

        // view 싱글톤 가져오기
        BoardView.getInstance().index();


//        BoardDao boardDao = BoardDao.getInstance();

    } // main end
} // class end
