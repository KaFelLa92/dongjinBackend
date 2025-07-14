package practice.Example2; // package name

import java.util.Scanner;

public class BoardPracitce { // class start
    public static void main(String[] args) { // main start

        // 배열 객체 저장 공간만들기
        String[] contents = new String[100];
        String[] writers = new String[100];

        Scanner scan = new Scanner(System.in);

        for (; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력 | 3. 게시판종료");
            System.out.println("========================================");
            int select = scan.nextInt();
            // 1번 입력
            if (select == 1) {
                scan.nextLine(); // 버그 방지용
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();
                boolean check = false;  // 기본값 false는 저장 실패. true 저장 성공
                for (int i = 0; i < contents.length; i++) {
                    String board = contents[i];
                    if (board == null) {
                        contents[i] = content;
                        writers[i] = writer;
                        check = true;
                        break;
                    }
                }
                if (check) { // boolean check 성공 시
                    System.out.println(check);
                    System.out.println("[안내]글쓰기 성공");
                } else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            }

            if (select == 2) {
                System.out.println("============= 게시물 목록 =============");
                for (int i = 0; i < contents.length; i++ ){
                    String board = contents[i];
                    if( board != null){
                        System.out.println("작성자 : " + writers[i]);
                        System.out.println("내용 : " + contents[i]);
                        System.out.println("------------------------------------");
                    }
                }
            }

        }


    } // main end
} // class end
