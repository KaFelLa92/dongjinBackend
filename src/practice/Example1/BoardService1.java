package practice.Example1;  // package name

import java.util.Scanner;

public class BoardService1 {    // class start
    public static void main(String[] args) {    // main start
        Scanner scan = new Scanner(System.in);
        String c1 = null;
        String c2 = null;
        String c3 = null;
        String w1 = null;
        String w2 = null;
        String w3 = null;
        for (; ; ) {
            System.out.println("======Welcome to Community Channel======");
            System.out.println("1. 게시물쓰기 | 2. 게시물출력 | 3. 게시판끄기");
            System.out.println("========================================");
            int select = scan.nextInt();
            if (select == 1) {
                if (c1 == null) {
                    scan.nextLine();
                    System.out.println("내용 : ");
                    c1 = scan.nextLine();
                    System.out.println("작성자 : ");
                    w1 = scan.nextLine();
                    System.out.println("[안내]글쓰기성공");
                } else if (c2 == null) {
                    scan.nextLine();
                    System.out.println("내용 : ");
                    c2 = scan.nextLine();
                    System.out.println("작성자 : ");
                    w2 = scan.nextLine();
                    System.out.println("[안내]글쓰기성공");
                } else if (c3 == null) {
                    scan.nextLine();
                    System.out.println("내용 : ");
                    c3 = scan.nextLine();
                    System.out.println("작성자 : ");
                    w3 = scan.nextLine();
                    System.out.println("[안내]글쓰기성공");
                } else {
                    System.out.println("[경고]게시물을 등록할 공간이 부족합니다.");
                }
            }
            if (select == 2) {
                System.out.println("============== 게시물 목록 ===============");
                if (c1 != null) {
                    System.out.println("내용 : " + c1 + "\n작성자 : " + w1);
                    System.out.println("---------------------------------------");
                }
                if (c2 != null) {
                    System.out.println("내용 : " + c2 + "\n작성자 : " + w2);
                    System.out.println("---------------------------------------");
                }
                if (c3 != null) {
                    System.out.println("내용 : " + c3 + "\n작성자 : " + w3);
                    System.out.println("---------------------------------------");
                }

            }
        }


    }   // main end
}   // class end
