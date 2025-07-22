package Practice.Example9.controller;

public class BoardController {
    // (*) 싱글톤 생성
    private BoardController (){}
    public static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
}
