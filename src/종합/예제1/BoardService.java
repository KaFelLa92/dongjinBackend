package 종합.예제1; // package(folder) name

import java.util.Scanner;

public class BoardService { // class start
    public static void main(String[] args) { // main start

        /*
        [JAVA] 종합예제1 : boardService1 (변수 활용)
        [ 목표 ] Scanner, for(;;), if 문과 변수를 활용하여, 최대 3개의 게시물을 저장하고 조회할 수 있는 간단한 콘솔 게시판 프로그램을 구현합니다.
        */

        /*
        [ 요구사항 ]
        1. 게시물 저장 공간 만들기
        · 최대 3개의 게시물을 저장할 수 있어야 합니다.
        · 각 게시물은 '내용'과 '작성자' 정보를 가집니다.
        · 총 6개의 String 변수를 선언하여 저장 공간을 만드세요. (예: content1, writer1, content2, writer2, content3, writer3)
        · 모든 변수는 null로 초기화하여, 해당 공간이 비어있음을 나타내도록 합니다.
        2. 메인 프로그램 흐름 구현하기
        · 프로그램은 사용자가 강제 종료하기 전까지 계속 실행되어야 합니다. for(;;) 무한루프를 사용하세요.
        · 무한루프 안에서 사용자에게 메뉴를 보여주고, Scanner를 통해 원하는 기능의 번호를 입력받으세요.
        · 기능 1: 게시물 쓰기 (입력값: 1)
        - 사용자가 1을 입력하면, "내용 : "과 "작성자 : "를 순서대로 물어보고 입력받습니다.
        - 1번 게시물 공간(content1)부터 순서대로 비어있는지(null인지) 확인합니다.
                - 가장 먼저 발견된 빈 공간에 입력받은 내용과 작성자를 저장하고 "[안내] 글쓰기 성공" 메시지를 출력합니다.
        - 만약 3개의 게시물 공간이 모두 차 있다면, "[경고] 게시물을 등록할 공간이 부족합니다." 라는 메시지를 출력합니다.
        · 기능 2: 게시물 출력 (입력값: 2)
        - 사용자가 2를 입력하면, 저장된 모든 게시물을 아래 형식으로 출력합니다.
                - 1번 게시물부터 3번 게시물까지, 저장 공간이 비어있지 않은(null이 아닌) 경우에만 출력합니다.
                */

        Scanner scan = new Scanner(System.in);  // scan 변수에 입력창 대응. 임포트 꼭 하기
        String c1 = null;
        String c2 = null;
        String c3 = null;   // 게시물 변수 초기화
        String w1 = null;
        String w2 = null;
        String w3 = null;   // 작성자 변수 초기화
        for (; ; ) {                                            // 커뮤니티 입장
            System.out.println("======Welcome to Community Channel======");
            System.out.println("1. 게시물쓰기 | 2. 게시물출력 | 3. 게시판끄기");
            System.out.println("========================================");
            int select = scan.nextInt();
            if (select == 1 && c1 == null) {
                scan.nextLine();                        // 버그 있어서 공란 하나 만들어주고 시작
                System.out.print("내용 : ");
                c1 = scan.nextLine();
                System.out.print("작성자 : ");
                w1 = scan.nextLine();
                System.out.println("[안내]글쓰기성공");
            } else if (select == 1 && c2 == null) {
                scan.nextLine();
                System.out.print("내용 : ");
                c2 = scan.nextLine();
                System.out.print("작성자 : ");
                w2 = scan.nextLine();
                System.out.println("[안내]글쓰기성공");
            } else if (select == 1 && c3 == null) {
                scan.nextLine();
                System.out.print("내용 : ");
                c3 = scan.nextLine();
                System.out.print("작성자 : ");
                w3 = scan.nextLine();
                System.out.println("[안내]글쓰기성공");
            } else if (select == 1 && c3 != null) { // 이렇게 안 쓰려면 select == 1 if문 안에 있는 c1 비교 if문으로 쓰는 게 좋겠다.
                System.out.println("[경고]게시물을 등록할 공간이 부족합니다.");
            }
            if (select == 2) {
                System.out.println("============== 게시물 목록 ===============");
                if (c1 != null) {                       // null이 아니면 출력하기
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
            if (select == 3) {
                System.out.println("=================bye bye=================");
                break;
            }
        }                                                           // for end
        


         /*
        [ 실행 예시 ]
        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
                선택 > 1
                내용 : 안녕하세요
                작성자 : 유재석
                [안내] 글쓰기 성공

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
                선택 > 1
                내용 : 반갑습니다
                작성자 : 강호동
                [안내] 글쓰기 성공

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
         ========================================
                선택 > 2
        ============= 게시물 목록 =============
                작성자 : 유재석
                내용 : 안녕하세요
        ------------------------------------
        작성자 : 강호동
        내용 : 반갑습니다
        ------------------------------------

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
        선택 > 1
        내용 : 테스트
        작성자 : 이수근
        [경고] 게시물을 등록할 공간이 부족합니다.
        */


    } // main end
}   // class end
