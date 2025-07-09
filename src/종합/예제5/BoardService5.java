package 종합.예제5; // package name

import 종합.예제5.Board;

import java.util.Scanner;

public class BoardService5 { // class s
    public static void main(String[] args) { // main s

        Scanner scan = new Scanner(System.in);

        // BoardController 클래스내 *메소드를 호출*하기 위한 객체 생성
        BoardController bs = new BoardController();
        /*

        [ 목표 ] boardService4(종합예제4) 에서 객체 생성를 생성자로 변경 하시오.
        [ 이하 조건 ] : boardService4 동일

         */
        // 무한루프
        for (; ; ) {    // 프로그램 계속 실행하기 위해서
            System.out.println("============= My Community =============");
            System.out.println("1. 게시물쓰기 | 2. 게시물출력 | 3. 게시판종료");
            System.out.println("========================================");
            int select = scan.nextInt();    // 선택 넘버 입력
            if (select == 1) {  // 입력에 따른 화면 출력
                scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();
                // (6) * addBoard 메소드 호출하여 등록 처리 후 결과를 받는다.
                boolean result = // addBoard 메소드의 실행 후 결과를 result에 저장
                        bs.addBoard(content, writer); // 입력받은 두 값을 인수로 전달
                if (result) {    // addBoard에서 true 반환이면
                    System.out.println("[안내] 글쓰기 성공");
                } else {                // addBoard에서 false 반환이면
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }

            } // if end

            if (select == 2) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = bs.viewBoard();    // viewBoard()이 반환된 boards 배열 자료를 boards에 대입한다.
                for (int i = 0; i <= boards.length - 1; i++) {
                    Board board = boards[i];
                    if (board != null) {
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
                        System.out.println("-------------------------------------");
                    }
                }
            }   // if end

            if (select == 3) {
                break;
            }


        } // for end
    }   // main e
}   // class e