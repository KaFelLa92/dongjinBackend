package 종합.예제10.view;

import 종합.예제10.controller.BoardController;
import 종합.예제10.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    // (*) 싱글톤
    private BoardView() {
    }

    public static final BoardView instance = new BoardView();

    public static BoardView getInstance() {
        return instance;
    }

    // (*) 입력 객체
    private Scanner scan = new Scanner(System.in);

    // (*) 메인 화면
    public void index() {
        for (; ; ) {
            try {
                System.out.println("============ 비회원 게시판 ============");
                System.out.println("1. 등록 | 2. 전체조회 | 3. 삭제 | 4. 수정");
                System.out.print("선택 >");
                int choose = scan.nextInt();
                if (choose == 1) {
                    boardWrite();
                } else if (choose == 2) {
                    boardPrint();
                } else if (choose == 3) {
                    boardDelete();
                } else if (choose == 4) {
                    boardUpdate();
                } else {
                    System.out.println("[경고] 존재하지 않는 번호입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 일치하지 않습니다. < 다시입력해주세요. >");
                scan = new Scanner(System.in); // 입력에 따른 입력객체 초기화
            } catch (Exception e) {
                System.out.println("[오류] 관리자에게 문의하세요. 010-****-****");
            } // catch end
        } // for end
    } // func end

    // (*) 보드 컨트롤러 싱글톤 불러오기
    private BoardController boardController = BoardController.getInstance();

    // (1) 등록 화면 구현
    public void boardWrite() {
        // 1. 입력받기
        scan.nextLine();    // 넥스트라인 쓰려면 맨 앞에 하나 둬서 초기화
        System.out.print("> 내용 : ");
        String bcontent = scan.nextLine();
        System.out.print("> 작성자 : ");
        String bwriter = scan.next();
        // 2. controller에게 dao 전달하기        // 3. 전달후 (결과)리턴값 저장하기
        boolean result = boardController.boardWrite(bcontent, bwriter);
        // 4. 리턴된 값에 따른 출력하기
        if (result) {
            System.out.println("[안내] 게시물 등록 성공");
        } else {
            System.out.println("[경고] 게시물 등록 실패");
        }


    } // func end

    // (2) 전체조회 화면 구현
    public void boardPrint() {
        // 1. controller에게 요청후 결과 받기
        ArrayList<BoardDto> result = boardController.boardPrint();
        // 2. 결과에 따른 화면 구현
        System.out.println("번호 \t 작성자 \t 내용"); // 표 상단
        for (BoardDto dto : result) { // 향상된 for문 , for (항목타입 변수명 : 리스트명) {}
            System.out.printf("%s \t %s \t %s \n", dto.getBno(), dto.getBwriter(), dto.getBcontent());

        } // for end
    } // func end

    // (3) 삭제 화면 구현
    public void boardDelete() {
        // 1. 입력 받기
        System.out.println("삭제할 게시물 번호 : ");
        int bno = scan.nextInt();
        // 2. 컨트롤러에 전달 3. 전달 후 리턴값 저장하기
        boolean result = boardController.boardDelete(bno);
        // 4. 리턴값에 따른 출력
        if (result) {
            System.out.println("[안내] 삭제 성공");
        } else {
            System.out.println("[경고] 없는 번호이거나 실패");
        }
    } // func end

    // (4) 수정 화면 구현
    public void boardUpdate() {
        // 1. 입력받기
        System.out.println("수정할 게시물 번호 : ");
        int bno = scan.nextInt();
        System.out.println("수정할 게시물 내용 : ");
        String bcontent = scan.nextLine();
        // 2. 컨트롤러 전달하기, 3. 전달 후 리턴값 저장하기
        boolean result = boardController.boardUpdate(bno, bcontent);
        // 4. 리턴값에 따른 출력
        if (result) {
            System.out.println("[안내] 수정 성공");
        } else {
            System.out.println("[경고] 없는 번호이거나 실패");
        }
    } //  func end

} // class end
