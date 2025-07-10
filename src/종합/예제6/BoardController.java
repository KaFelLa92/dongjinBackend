package 종합.예제6;

// (2) 컨트롤러 : 기능/제어
public class BoardController { // class start
    // 1. 멤버변수 무조건 private 접근 제한자 넣기
    private static final Board[] boards = new Board[100];

    // private : 현재 클래스에서만 접근 키워드
    // static : 객체 없이 접근 가능한 키워드
    // final : 수정 불가능 키워드
    // 2. 생성자
    // 3. 메소드
    // 1) 등록 메소드
    // public 다른 클래스에서 접근
    public static boolean doPost(String content, String writer) {
        // (1) 매개변수로 객체를 생성한다.
        Board board = new Board(content, writer);
        // (2) 배열(boards)내 빈공간을 찾아서 생성한 객체 대입한다.
        for (int i = 0; i <= boards.length - 1; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true;    // 저장 성공 의미를 true에 부여함. int로 하려면 1 성공 2 실패로 하던가.
            }   // if end
        } // for end
        return false;
    }

    // 2) 조회 메소드
    public static Board[] doGet() {
        return boards;
    }


} // class end
