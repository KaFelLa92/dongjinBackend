package 종합.예제10; // package name

import 종합.예제10.controller.BoardController;
import 종합.예제10.model.dao.BoardDao;
import 종합.예제10.view.BoardView;

public class AppStart {
    public static void main(String[] args) {

        // 20250723 등록 테스트
//        boolean result = BoardController.getInstance().boardWrite("테스트인겨" , "아저씨");
//        System.out.println( result );

        // * 메인화면 호출
        BoardView.getInstance().index();

    } // main end
} // class end
