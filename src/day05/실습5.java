package day05;  // package(folder) name

import java.util.Scanner;

public class 실습5 {  // class start
    public static void main(String[] args) {    // main start
/*
        JAVA] 실습5 : 반복문

[ 문제 ] 아래 반복문 관련 문제
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/

// [문제 1] for문을 사용하여 1부터 10까지의 숫자를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

            /*
            for(int i = 1; i <= 10; i++){
                    System.out.println(i);
            }

             */

// [문제 2] for문을 사용하여 10부터 1까지의 숫자를 역순으로 출력하는 프로그램을 작성하시오.

        /*
        for (int i = 10; i >= 1; i--){
            System.out.println(i);
        }

         */


            /*
   [문제 3] for문을 사용하여 1부터 50까지 모든 정수의 합계를 구하여 최종 결과를 출력하시오.
        출력 예시:
        1부터 50까지의 합계: 1275
*/

        /*
        int sum = 0;    // 전역 인트 리터럴을 갖는 변수 0 생성
        for (int i = 1; i <= 50; i++) {
            sum += i;   // for문 돌리면서 모든 i를 sum에 더하기
        }
        System.out.println(sum);    // for문 끝나고 i의 합산을 출력
        */

//  [문제 4] for문과 if문을 사용하여, 1부터 20까지의 숫자 중 짝수만 출력하는 프로그램을 작성하시오.

        /*
        for (int i = 1; i <= 20; i++) { // for문 : 1부터 20까지 증가연산
            if (i % 2 == 0){    // 짝수 구하는 나머지 계산
                System.out.println(i);  // 짝수만 출력
            }
        }

         */


            /*
[문제 5] 1부터 30까지의 숫자 중, 3의 배수는 건너뛰고 나머지 숫자만 출력하는 프로그램을 작성하시오.
        요구 조건: continue 문을 반드시 사용하시오.
*/

        /*
        for(int i = 1; i <= 30; i++){   // 1부터 30까지 1씩 더하는 for문
            if(i % 3 == 0){ //  3의 배수일 경우
                continue;   // 상단의 for문으로 돌아간다
            }
            System.out.println(i);  // if문에 있던 값들은 continue당하고, 다른 값들만 출력.
        }

         */


            /*
[문제 6]1 부터 순서대로 숫자를 더해나갈 때, 합계가 처음으로 100 을 초과하는 시점의 숫자와 그때까지의 합계를 출력하고 반복문을 즉시 종료하시오.
        요구 조건:break 문을 반드시 사용하시오.
        출력 예시:
        14 까지 더했을 때 합계가 105 로 100 을 넘습니다.
             */

        /*
        int sum = 0;        // 전역으로 합계 계산할 sum 정수 리터럴 변수 생성
        for (int i = 1; i <= 100; i++) {  // 대충 100까지 세보자
            sum += i;                       // sum은 i를 계속 축적한다
            if (sum > 100) {                // sum 값이 100 넘어가면
                break;                      // 멈춰!
            }
            // System.out.println(sum);    여기서 sum 출력하면 반복문으로 더하는 값이 나오니
        }
        System.out.println(sum);            // for문 끝나고 sum 출력하면 100 넘길 때까지 i를 더한 값 나온다
        */

            /*
[문제 7]중첩 for문을 사용하여 아래와 같이 별 ( *)로 이루어진 직각삼각형을 출력하시오.
        출력 예시:
*
**
***
****
*****

             */

        /*
        String starGazer = "";    // 별을 더하기 위해 문자열 리터럴 star 변수 생성 * 결국 별이 2개 이상이기 때문에 char 쓰면 안됨 ㅜㅜ
        for (int i = 0; i <= 4; i++) {   // 다섯 줄
            starGazer += "*";   // 빈 문자열 starGazer에 "*"문자 적립
            System.out.println(starGazer);
        }

         */

        /*
        // 강사님 풀이
        for (int line = 1; line <= 5; line++) {
            for (int star = 1; star <= line; star++) {
                System.out.print("*");  // 별 * ** *** **** ***** 형식으로 그려가기
            }// for end
            System.out.println( );      // line 마다 println. 이스케이프 문자 \n효과.
        }
*/


            /*
[문제 8]중첩 for문을 사용하여 아래와 같이 별 ( *)로 이루어진 역직각삼각형을 출력하시오.
        출력 예시:
*****   (6 - 1)
****    (6 - 2)
***
**
*
*/

        /*
        String star = "";                       // 별 더할 용도의 빈 문자열 클래스 변수 star
        for (int i = 1; i <= 5; i++) {          // 5번 출력 담당. i의 숫자에 따라서 별 숫자가 정해지기에 0~4가 아닌 1~5로 처리.
            for (int s = 1; s <= (6 - i); s++) { // 별찍기 담당, 6에서 출력 담당을 빼면 별 숫자가 나옴.
                star += "*";                    //  빈 문자열 클래스 변수 star에 * 하나씩 더하기.
            }
            star += "\n";                       //  이스케이프 문자열 추가하여 줄바꿈 처리
        }
        System.out.println(star);               // for문 바깥에서 출력하면 역순 별 삼각형 완성
*/

            /*
[문제 9]Scanner와 무한루프를 사용하여, 사용자가 "end" 를 입력할 때까지 계속해서 문자열을 입력받는 프로그램을 작성하시오."end" 가 입력되면,
        그 전까지 입력된 문자열의 총 횟수를 계산하여 아래 출력 예시와 같이 출력한 뒤 프로그램을 종료하시오.
                요구 조건:
        무한루프를 사용하시오 ( for (; ; ) 또는 while (true)).
        입력 횟수를 저장할 count 변수를 사용하시오.
        break를 사용하여 루프를 탈출하시오.
        문자열 비교는 .equals() 메소드를 사용하시오.
        실행 예시:
        1 회 입력 :자바
        2 회 입력 :자바스크립트
        3 회 입력 :파이썬
        4 회 입력 :HTML
        5 회 입력 :CSS
        6 회 입력 :C언어
        7 회 입력 :end
                [안내] 프로그램을 종료 합니다.[총 6 회 입력]
             */

        /*
        Scanner scan = new Scanner(System.in); // 꼭 자동완성해서 java.util.Scanner 임포트 시키기
        int count = 0;  // 입력횟수 count가 올라가면 다른 출력이 나온다.
        System.out.println("탈출해보시오.");
        for (; ; ) {   // 무한루프
            count += 1; // 무한루프 돌 때(텍스트 입력 할 때)마다 count 1씩 적립
            String escape = scan.next();    // 문자열 클래스로 탈출 변수 입력
            if (escape.equals("end")) {     // 입력한 문자열이 end면
                break;                      // for문 강제 종료
            }
        }
        System.out.println("[안내] 프로그램을 종료합니다. [총 " + count + " 회 입력]");
*/


            /*
[문제 10]아래 선언된 4 개의 변수는 7 월 각 주차별 매출액입니다.각 매출액을 '만원' 단위로 변환하고, 백만원 단위마다 '■' 문자로 시각화하여 아래 출력 예시와 같이 보고서를 출력하시오.
        선언 코드:
        int july1 = 3532100;
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;
        요구 조건:
        매출액을 10000 으로 나눈 몫을 사용하여 '만원' 단위를 계산합니다.
        '만원' 단위 값을 다시 100 으로 나눈 몫만큼 for문을 사용하여 '■' 문자를 반복 출력합니다.
                출력 예시:
        -------7 월 매출액 -------
                1 주차: ■■■353 만원
        2 주차: ■■■■■■■■■912 만원
        3 주차: ■■■■■518 만원
        4 주차: ■■■■■■■■■■■1173 만원
*/

        /*
        int july1 = 3532100;
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;

        // 각 int 변수를 10000으로 나눠서 재선언
        july1 /= 10000;
        july2 /= 10000;
        july3 /= 10000;
        july4 /= 10000;
        System.out.println(july1);  // 어게이

        // ■ 넣을 문자열 클래스 빈 변수 생성
        String square = "";

        // 백만원 단위마다 ■ 문자 넣기
        for (int i = 1; i <= july1 / 100; i++) {    // 1부터 정수 리터럴 변수에 100 나눈 값만큼 반복한다.
            square = "■";  // july1에 100나눈 값만큼 square 집어넣기
        }
        System.out.println(square + july1 + " 만원"); // 출력
        square = "";    // 초기화

        for (int i = 1; i <= july2 / 100; i++) {
            square += "■";
        }
        System.out.println(square + july2 + " 만원");
        square = "";

        for (int i = 1; i <= july3 / 100; i++) {
            square += "■";
        }
        System.out.println(square + july3 + " 만원");
        square = "";

        for (int i = 1; i <= july4 / 100; i++) {
            square += "■";
        }
        System.out.println(square + july4 + " 만원");

         */

            /*
                [문제 11]Scanner와 for (; ; ) 무한루프를 사용하여 간단한 ATM 기기를 만드시오.
        요구 조건:
        사용자에게 "1:입금 | 2:출금 | 3:잔고 | 4:종료" 메뉴를 보여줍니다.
        Scanner로 메뉴 번호를 입력받습니다.
        1 번을 선택하면 "입금액:" 을 물어보고, 입력받은 금액만큼 잔고 (balance) 를 증가시킵니다.
        2 번을 선택하면 "출금액:" 을 물어보고, 입력받은 금액만큼 잔고를 감소시킵니다. (단, 잔고보다 큰 금액은 출금할 수 없다고 안내)
        3 번을 선택하면 현재 잔고를 출력합니다.
        4 번을 선택하면 "프로그램을 종료합니다." 메시지를 출력하고 break를 이용해 무한루프를 탈출합니다.
        초기 잔고는 0 으로 시작합니다.
        실행 예시:
        ---------------------------------
                1:입금 | 2:출금 | 3:잔고 | 4:종료
                -------------------------------- -
                선택 > 1
        입금액 > 10000
                -------------------------------- -
                1:입금 | 2:출금 | 3:잔고 | 4:종료
                -------------------------------- -
                선택 > 3
        잔고 > 10000
                -------------------------------- -
                1:입금 | 2:출금 | 3:잔고 | 4:종료
                -------------------------------- -
                선택 > 4
        프로그램을 종료합니다.

             */

        Scanner scan = new Scanner(System.in);
        int balance = 0; // 정수 리터럴 잔고 변수 생성
        int money = 0; // 정수 리터럴 보유금 변수 생성
        for (; ; ) { // 무한루프
            System.out.println("감사합니다. 더조은은행 ATM 창구입니다.");
            System.out.println("1: 입금 | 2: 출금 | 3: 잔고 | 4: 종료");
            System.out.println();
            int select = scan.nextInt();
            if (select == 1) {  // 번호에 따른 명령 수행을 if문으로 제작
                System.out.print("입금 금액을 만 원 단위로 입력하세요: ");
                money = scan.nextInt() * 10000;
                balance += money;
                System.out.println();
                System.out.print("입금 금액: " + money + "원 ");
                System.out.println("현재 잔고: " + balance + "원");
                System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
                System.out.println();

            }
            if (select == 2) {
                System.out.println("현재 출금가능금액: " + balance + " 원");
                System.out.print("출금 금액을 만 원 단위로 입력하세요: ");
                System.out.println();
                if (balance <= 0) {
                    System.out.println("\n출금할 수 있는 금액이 없습니다.");
                    System.out.println("메인 화면으로 이동합니다.");
                } else if (balance > 0) {
                    money = scan.nextInt() * 10000;
                    balance -= money;
                    System.out.println(money + "원 출금하여 잔고는 " + balance + "원 입니다.");
                    System.out.println("이용해주셔서 감사합니다. 안녕히가세요.");
                    System.out.println();
                }
            }
            if (select == 3) {
                System.out.println("현재 잔고는 " + balance + " 원 입니다.");
                System.out.println();
            }
            if (select == 4) {
                System.out.println("더조은은행 ATM을 종료합니다.");
                System.out.println();
                break;
            }
        }


    }   // main end
}   // class end
