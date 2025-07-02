package day04;  // package(folder) name

import java.util.Scanner;

public class Example1 { // class s
    public static void main(String[] args) {    // main s

        /*

            [ 반복문 ]
                1. 조건에 따른 결과가 충족(true) 했을 때 (반복)코드 실행
                2. 형태
                    for( 초기값 ; 조건문 ; 증감식 ){
                        실행문;
                    }
                    - 초기값 : 반복문에서 사용되는 변수 *주로 반복횟수                 , int i = 1;
                    - 조건문 : 반복변수의 조건문 *주로 반복횟수 제한                   , i <= 10;
                    - 증감식 : 반복변수의 증(가) 또는 감(소) 변화식 *주로 반복횟수 증감  , i++
                    - 실행문 : 조건 충족시 실행되는 코드/명령어;
                3. 실행순서
                    1) 초기값 -> 2) 조건문 -> 3) 실행문 -> 4) 증감식
                                5) 조건문 -> 6) 실행문 -> 7) 증감식
                                -------------------------------
                                -> 조건이 false이면 반복문 종료
                4. for 중첩가능 : 상위 for문이 1회전 마다 하위 for문 전체 회전함.
                    for( ) {
                        for( ) { }
                    }
                5. 주요 키워드 :
                    1) break;      : 가장 가까운 반복문 {} 종료/탈출       vs return은 함수 끝내기
                    2) continue;   : 가장 가까운 반복문(증감식) 이동

                6. 무한루프
                    1) for ( ; ; ) { }
                    2) while(true) { }

        */

        // [1] 1부터 5까지 출력
        // 반복문없이
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        // 반복문 : 1부터 5까지 1씩 증가
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // [2] 중첩 : 구구단
        // 단 반복 : 2부터 9까지 1씩 증가.
//        for (int 단 = 2; 단 <= 9; 단++) {
//            System.out.println(단);
//        }
//
//        for (int 곱 = 1; 곱 <= 9; 곱++) {
//            System.out.println(곱);
//        }

        // 합치기 : (1) 단마다 곱 (2x1 , 2x1~) , (2) 곱마다 단 ( 2x1 , 3x1)
        for (int 단 = 2; 단 <= 9; 단++) {
            for (int 곱 = 1; 곱 <= 9; 곱++) {
                System.out.println(단 + "x" + 곱 + "=" + 단 * 곱);
            }
        }

        // [3] break : 1부터 10까지 출력 , 만일 5를 찾았으면 반복종료

        for (int i = 1; i <= 10; i++) { // for문으로 1부터 10까지 찾기
            if (i == 5) {           // 5를 찾았다면
                break;              // 종료하기
            }
            System.out.println(i);// 출력 넣기 5부터 안나옴 (1, 2, 3, 4)
        }

        // [4] continue : 1부터 10까지 반복, 5를 찾았으면 출력 생략
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);  // 5만 안나옴 (1, 2, 3, 4, 6, 7, 8, 9 ,10)
        }

        // [5] for( ; ; ){} : 무한반복
        for( ; ; ){
            System.out.println("mugen tsukuyomi");
            String tsukuyomi = new Scanner( System.in ).next(); // 키보드로부터 입력받아 저장
            if( tsukuyomi.equals("윤회안개안") || tsukuyomi.equals("우치하사스케")){   // 윤회안을 개안하거나, 우치하 사스케라면 츠쿠요미에서 탈출.
                break;
            }
        }

    }   // main e
}   // class e
