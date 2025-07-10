package 심화.과제1;

import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {


    /*
    [JAVA] 심화과제1 : BankService 아래 실행예시를 참고하여 코드를 구현하시오.
            [ 클래스 개수 ] : 3개 (Account, BankController, BankService)
[ 규칙 ] BankController 에서는 입력과 출력을 하지 않습니다.
            [ 계좌 최대 개수 ] : 100개

     */

        // 선택하려면? 스캐너 임포트
        Scanner scan = new Scanner(System.in);

        // 컨트롤러 객체 생성
        BankController bs = new BankController();

        // for 무한루프
        for (; ; ) {
            System.out.println("============== KB Bank  ==============");
            System.out.println("1. 계좌등록 | 2. 입금 | 3. 출금 | 4. 잔고확인");
            System.out.println("======================================");
            //
            int select = scan.nextInt();
            // 1번 선택
            if (select == 1) {
                scan.nextLine();    // 버그 방지용
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accountNum = scan.next();
                System.out.print("비밀번호 : ");
                String pwd = scan.next();
                // addAccount 메소드 호출
                boolean result = bs.addAccount(accountNum, pwd);
                // 메소드랑 같은 타입 변수 = 컨트롤러객체.메소드(매개변수1, 매개변수2)
                if (result) {
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 사용 가능한 구좌가 없습니다.");
                }
            } // if end
            // 2번 선택
            if (select == 2) {
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accountNum = scan.next();
                System.out.print("비밀번호 : ");
                String pwd = scan.next();
                System.out.print("입금액 : ");
                int money = scan.nextInt();
                // pushMoney 메소드 호출
                boolean result = bs.pushMoney(accountNum, pwd, money);
                if (result) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            }   // if end

            // 3번 선택
            if (select == 3) {
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accountNum = scan.next();
                System.out.print("비밀번호 : ");
                String pwd = scan.next();
                System.out.print("출금액 : ");
                int balance = scan.nextInt();
                // pullMoney 메소드 호출
                boolean result = bs.pullMoney(accountNum, pwd, balance);
                if (result) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 잔액부족 또는 게좌정보가 일치하지 않습니다.");
                }
            }

            // 4번 선택
            if (select == 4) {
                System.out.println("--- 잔고 확인 ---");
                // 객체 호출
                Account[] accounts = new Account[100];
                System.out.print("계좌번호 : ");
                String accountNum = scan.next();
                System.out.print("비밀번호 : ");
                String pwd = scan.next();
                // 객체 불러오기
                int result = bs.balanceCheck(accountNum , pwd);
                if( result >= 0) {
                    System.out.println("[잔고] " + result + "원");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            }
        }

    }// main end


    /*
[ 실행 예시 ]
            ============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 1
            --- 계좌 등록 ---
    계좌번호 : 123-456
    비밀번호 : 1111
            [안내] 계좌 등록이 완료되었습니다.

============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 2
            --- 입금 ---
    계좌번호 : 123-456
    비밀번호 : 1111
    입금액 : 50000
            [안내] 입금이 완료되었습니다.

            ============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 4
            --- 잔고 확인 ---
    계좌번호 : 123-456
    비밀번호 : 1111
            [잔고] 50000원

============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 3
            --- 출금 ---
    계좌번호 : 123-456
    비밀번호 : 1111
    출금액 : 20000
            [안내] 출금이 완료되었습니다.

            ============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 4
            --- 잔고 확인 ---
    계좌번호 : 123-456
    비밀번호 : 1111
            [잔고] 30000원

============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 2
            --- 입금 ---
    계좌번호 : 123-456
    비밀번호 : 2222
    입금액 : 10000
            [경고] 계좌정보가 일치하지 않습니다.

============== KB Bank  ==============
            1.계좌등록 | 2.입금 | 3.출금 | 4.잔고
======================================
    선택 > 3
            --- 출금 ---
    계좌번호 : 123-456
    비밀번호 : 1111
    출금액 : 40000
            [경고] 잔액이 부족합니다.

     */

}   // class end
