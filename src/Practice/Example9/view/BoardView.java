package Practice.Example9.view;

public class BoardView {
    // (*) 싱글톤 생성
    private BoardView (){}
    public static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }
    
}
