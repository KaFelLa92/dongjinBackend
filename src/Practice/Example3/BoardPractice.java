package Practice.Example3;

import java.util.Scanner;

public class BoardPractice {
    public static void main(String[] args) {
        Board[] boards = new Board[100];

        boolean check = false;

        for (; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("1. 게시물쓰기 | 2. 게시물출력 | 3. 게시판종료");
            System.out.println("========================================");
            Scanner scan = new Scanner(System.in);
            int select = scan.nextInt();
            if (select == 1) {
                scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();
                Board board = new Board();
                board.content = content;
                board.writer = writer;
                for (int i = 0; i < boards.length - 1; i++) {
                    if (boards[i] == null) {
                        boards[i] = board;
                        check = true;
                        break;
                    }
                }

                if (check) {
                    System.out.println("[안내]글쓰기 성공");
                } else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }

            }
            if (select == 2) {
                System.out.println("============= 게시물 목록 =============");
                for (int i = 0; i < boards.length; i++) {
                    Board board = boards[i];
                    if (board != null) {
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
                        System.out.println("------------------------------------");
                    }
                }
            }
        }
    }
}
