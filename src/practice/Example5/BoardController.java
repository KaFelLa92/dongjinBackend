package practice.Example5;

public class BoardController {
    Board[] boards = new Board[100];

    // 1. 등록
    boolean addBoard(String content, String writer) {
        Board board = new Board(content, writer);
        for (int i = 0; i < boards.length; i++ ){
            if(boards[i] == null){
                boards[i] = board;
                return true;
            }
        }
        return false;
    }

    // 2. 출력
    Board[] viewBoard() {
        return boards;
    }
}
