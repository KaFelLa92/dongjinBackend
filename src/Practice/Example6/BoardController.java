package Practice.Example6;

public class BoardController {

    private static final Board[] boards = new Board[100];

    // 1. 등록
    public static boolean doPost(String content, String writer) {
        Board board = new Board(content, writer);
        for (int i = 0; i < boards.length; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true;
            }
        }
        return false;
    }

    // 2. 조회
    public static Board[] doGet() {
        return boards;
    }

}
