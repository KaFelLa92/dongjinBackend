package 종합.예제4;

public class BoardController {
    // HTML과 DB의 중간 역할을 할 클래스
    // 로직/제어 담당
    // 1. 멤버변수
    Board[] boards = new Board[100];

    // 2. 메소드
    // (1) 등록
    // 저장 성공 시 true, 실패 시 false 반환(return)
    boolean doPost(String content, String writer) {
        // Board 객체 생성, 매개변수로 받은 값을 멤버 변수에 저장.
        Board board = new Board();  // 객체 생성
        board.content = content;    // 멤버 변수 저장
        board.writer = writer;      // 멤버 변수 저장
        // boards 배열의 빈 공간(null)찾아 생성된 객체 저장
        for (int i = 0; i <= boards.length - 1; i++) {
            if (boards[i] == null) {    // i번째가 null이면
                boards[i] = board;      // i번째에 생성한 객체 대입
                return true;            // 저장 성공 시 true
            }
        } // for end

        return false; // for문 끝나도 못찾았으면 false여

    } // func end

    // (2) 조회
    // 매개변수 X , 리턴값 배열 전체
    Board[] doGet() {
        return boards;
    }

}
