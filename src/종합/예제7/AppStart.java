package 종합.예제7; // package name

import 종합.예제7.view.BoardView;

// (역할) 프로그램 시작 클래스
public class AppStart { // class start
    public static void main(String[] args) { // main start

        // boardView index() 호출하는 방법
        // 1. 메소드가 static이면?
//      BoardView.index();
        // 2. 메소드가 static이 아니면, 인스턴스(객체) 생성
//      BoardView view = new BoardView();
//      view.index();
        // 3. 해당 클래스가 싱글톤이면
//      BoardView 싱글톤 = BoardView.getInstance();
//      싱글톤.index();
        BoardView.getInstance().index(); // = new BoardView().index();


    }   // main end
}   // class end
