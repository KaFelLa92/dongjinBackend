package 종합.예제5;

public class BoardController {

    Board[] boards = new Board[100];

    // 1. 등록 이벤트 : 입력받은 자료를 받아서 객체를 생성하여 배열 저장
    // 메소드 이름 addBoard
    // 매개변수 : 저장 내용과 작성자       ,(String content , String writer)
    // 반환값 : 성공/실패 == boolean     , boolean
    boolean addBoard(String content, String writer) {
        Board board = new Board(content, writer);    // (1) 생성자 이용한 객체 만들기
        for (int i = 0; i <= boards.length - 1; i++) {
            if (boards[i] == null) { // 만약 i번째 요소가 null이면(비어있으면)
                boards[i] = board; // i번째에 생성한 객체 대입.
                return true; // return이란 메소드 값 반환이면서 메소드 종료.
                // break; true 아니면 우짤라고 break 쓰냐
            }// if end
        } // for end
        return false; // for에서 null이 존재하지 않을때 false 반환
    } // func end

    // 2. (출력) 조회 이벤트 : 저장된 모든 객체를 가지는 배열 호출
    // 메소드 이름 viewBoard
    // 매개변수 : x                    , x
    // 반환값 : boards                 , Board[]
    Board[] viewBoard() {
        return boards;
    }

}
// 담당이 필요한 이유!! : 복합한 로직/코드를 역할/담당 나누어 유지보수 관리한다.
// 나폴리맛피자 식당은 다찌 테이블 7석이라 사장님 혼자서 주문받고, 요리하고, 냉장고 관리하고 가능.
// 근데 테이블이 100개 있으면 역할/담당 분할해야겠지?
// 1. 서빙(BoardService) 2. 요리사(Controller) 3. 재고관리(Board)
