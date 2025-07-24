package Practice.Example9;

import Practice.Example9.controller.BoardController;
import Practice.Example9.model.dto.BoardDto;
import Practice.Example9.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 테스트
        // (1) 컨트롤러 싱글톤 가져오기
        BoardController bc = BoardController.getInstance();

        // (2) 단위 기능 테스트
            // 등록 테스트
//        boolean result1 = bc.boardWrite("방가워유" , "김진효");
//        System.out.println(result1);

            // 전체조회 테스트
//        ArrayList<BoardDto> result2 = bc.boardPrint();
//        System.out.println(result2);
        
        // (*) 뷰 인덱스 싱글톤 가져오기
        BoardView.getInstance().index();

    } // main end
} // class end
