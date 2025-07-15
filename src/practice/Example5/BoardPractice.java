package practice.Example5;

import java.util.Scanner;

public class BoardPractice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BoardController control = new BoardController();

        for (; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("1. 게시물쓰기 | 2. 게시물출력 | 3. 게시판종료");
            System.out.println("========================================");
            int select = scan.nextInt();
            if (select == 1) {
                scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();
                boolean result = control.addBoard(content, writer);
                if (result) {
                    System.out.println("[안내] 글쓰기 성공");
                } else {                // addBoard에서 false 반환이면
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            }

            if (select == 2) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = control.viewBoard();
                for (int i = 0; i < boards.length; i++) {
                    Board board = boards[i];
                    if (board != null){
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
                        System.out.println("-------------------------------------");
                    }
                }

            }
        }
    }
}
