package day10; // package name

// 1. 싱글톤 만들기
class Controller {
    // 1) 기본생성자를 private한다. <외부에서 new 사용금지>
    private Controller() {
    }

    // 2) private static final 이용한 instance를 하나 만든다. <싱글톤>
    private static final Controller controller = new Controller();

    // 3) public static 이용한 instance getter method 만든다. <싱글톤 return>
    public static Controller getInstance() {
        return controller;  // 싱글톤을 갖는 변수를 return
    }   // func end
} // class end

public class Example1 { // class start
    public static void main(String[] args) {    // main start

        // 4. 싱글톤 불러오기
        Controller.getInstance();   // vs new Controller();


    }   // main end
}   // class end
