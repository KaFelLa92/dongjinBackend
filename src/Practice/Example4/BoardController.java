package Practice.Example4;

public class BoardController {

    // 배열
    Board[] boards = new Board[100];

    // 등록
    boolean doPost(String content, String writer) {
        Board board = new Board();
        board.content = content;
        board.writer = writer;
        for (int i = 0; i < boards.length; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true;
            }
        }
        return false;
    }

    // 조회
    Board[] doGet() {
        return boards;
    }
}
