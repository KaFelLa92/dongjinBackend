package 종합.예제2; // package name

import java.util.Scanner;

public class BoardService2 { // class start
    public static void main(String[] args) { // main start

        /*
        [JAVA] 종합예제2 : boardService2 (배열 활용)
                [ 목표 ] 종합예제1 에서 배열 문법 추가하여 , 최대 100개의 게시물을 저장하고 조회할 수 있는 간단한 콘솔 게시판 프로그램을 구현합니다.

               */

        /*
[ 요구사항 ]
        1. 게시물 저장 공간 만들기
        · 최대 100개의 게시물을 저장할 수 있어야 합니다.
        · 각 게시물은 '내용'과 '작성자' 정보를 가집니다.
        · 총 2개의 String[] 배열변수를 선언하여 저장 공간을 만드세요. (예: String[] contents = new String[100] , String[] writers = new String[100] )
        · 모든 변수는 null로 초기화하여, 해당 공간이 비어있음을 나타내도록 합니다.
        2. 메인 프로그램 흐름 구현하기
        · 프로그램은 사용자가 강제 종료하기 전까지 계속 실행되어야 합니다. for(;;) 무한루프를 사용하세요.
        · 무한루프 안에서 사용자에게 메뉴를 보여주고, Scanner를 통해 원하는 기능의 번호를 입력받으세요.
        · 기능 1: 게시물 쓰기 (입력값: 1)
        - 사용자가 1을 입력하면, "내용 : "과 "작성자 : "를 순서대로 물어보고 입력받습니다.
        - 가장 먼저 발견된 빈 공간에 입력받은 내용과 작성자를 저장하고 "[안내] 글쓰기 성공" 메시지를 출력합니다.
        - 만약 100개의 게시물 공간이 모두 차 있다면, "[경고] 게시물을 등록할 공간이 부족합니다." 라는 메시지를 출력합니다.
        · 기능 2: 게시물 출력 (입력값: 2)
        - 사용자가 2를 입력하면, 저장된 모든 게시물을 아래 형식으로 출력합니다.
                - 저장 공간이 비어있지 않은(null이 아닌) 경우에만 출력합니다.
         */

//            // for문 돌려서 모든 컨텐츠인덱스, 라이터인덱스를 null로 초기화???
//            for (String content : contents) {
//                content = null;
//            }
//            for (String writer : writers) {
//                writer = null;
//            }

        // 내용과 작성자 저장 공간 만들기
        String[] contents = new String[100]; // 총 문자열 100개 저장 배열 선언
        String[] writers = new String[100]; // 총 문자열 100개 저장 배열 선언

        // 스캐너 생성
        Scanner scan = new Scanner(System.in);

        // for( ; ; ) 무한루프로 프로그램 실행
        for (; ; ) {    // for start
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력 | 3. 게시판종료");
            System.out.println("========================================");
            int select = scan.nextInt();
            // 1번 입력
            if (select == 1) {
                scan.nextLine();
                System.out.print("내용: ");
                String content = scan.nextLine();
                System.out.print("작성자: ");
                String writer = scan.nextLine();
                boolean check = false;  // false : 저장실패 , true : 저장성공
                for (int i = 0; i <= contents.length - 1; i++) { // 향상된 for 문
                    String board = contents[i]; // 내용 채울 공간(보드)을 내용의 인덱스값으로 지정
                    if (board == null) { // 게시판이 비어있으면
                        contents[i] = content;
                        writers[i] = writer;
                        check = true;
                        break; // 글쓰기 성공 후 무한루프로 회귀
                    }
                }
                if (check) {
                    System.out.println("[안내]글쓰기 성공");
                } else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }

            }
            // 2번 입력
            if (select == 2) {
                System.out.println("============= 게시물 목록 =============");
                for (int i = 0; i <= contents.length - 1; i++) {
                    String board = contents[i];
                    if (board != null) { // 빈공간이 아닐 경우 출력하기 위해 if문 씀
                        System.out.println("작성자 : " + writers[i]);
                        System.out.println("내용 : " + contents[i]);
                        System.out.println("------------------------------------");
                    }
                } // for end
            }

            // 3번 입력
            if ( select == 3){
                System.out.println("fare well. everything everywhere all at once.");
                break;
            }
        }// for end







        /*
[ 실행 예시 ]  <종합예제1 과 동일 참고>
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
