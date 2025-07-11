package 심화.과제2;

import java.util.Scanner;

// 해당 코드는 구동과 화면을 담당합니다.
public class BankService2 { // class s

    // 싱글톤 설계
    private BankService2() {
    } // 1단계

    private static final BankService2 bankFront = new BankService2(); // 2단계

    public static BankService2 getInstance() {
        return bankFront; // 3단계
    }


    public static void main(String[] args) { // main s
        /*
                [JAVA] 심화과제2 : BankService 아래 실행예시를 참고하여 코드를 구현하시오. *미제출
                [ 클래스 개수 ] : 3개 (Account, BankController, BankService)
                [ 규칙 ] BankController 에서는 입력과 출력을 하지 않습니다.
                [ 계좌 최대 개수 ] : 100개

         */

        // (*) 다른 메소드에서도 스캔할 수 있지만, 해당 과업에서는 규칙이 있으므로 사용하지 않는다.
        Scanner scan = new Scanner(System.in);

        // 컨트롤러 인스턴스 가져오기
        BankController bankBack = BankController.getInstance();


        // for(;;)문 출력
        for (; ; ) {
            System.out.println("================== KB Bank ==================");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체");
            System.out.println("=============================================");
            System.out.print("번호를 입력해 진행하십시오.");
            int select = scan.nextInt();
            if (select == 1) {
                System.out.println("--- 계좌 등록 ---");
                System.out.println("계좌번호 : ");
                System.out.println("비밀번호 : ");
                System.out.println("[안내] 계좌 등록이 완료되었습니다.");
            }
            if (select == 2) {
                System.out.println("--- 입금 ---");
                System.out.println("계좌번호 : ");
                System.out.println("비밀번호 : ");
                System.out.println("입금액 : ");
                System.out.println("[안내] 입금이 완료되었습니다.");
            }
            if (select == 3) {
                System.out.println("--- 출금 ---");
                System.out.println("계좌번호 : ");
                System.out.println("비밀번호 : ");
                System.out.println("출금액 : ");
                System.out.println("[안내] 출금이 완료되었습니다.");
            }
            if (select == 4) {
                System.out.println("--- 잔고 확인 ---");
                System.out.println("계좌번호 : ");
                System.out.println("비밀번호 : ");
                System.out.println("[잔고] " + "원");
            }
            if (select == 5) {
                System.out.println("--- 계좌 이체 (비밀번호 오류) ---");
            }
        }


        /*
                [ 실행 예시 ]
                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ============================
                선택 > 1
                        --- 계좌 등록 (보내는 사람) ---
                계좌번호 : 111-111
                비밀번호 : 1234
                [안내] 계좌 등록이 완료되었습니다.

                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ============================
                선택 > 1
                        --- 계좌 등록 (받는 사람) ---
                계좌번호 : 222-222
                비밀번호 : 5678
                [안내] 계좌 등록이 완료되었습니다.

                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ============================
                선택 > 2
                        --- 입금 ---
                        계좌번호 : 111-111
                비밀번호 : 1234
                입금액 : 50000
                [안내] 입금이 완료되었습니다.

                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ============================
                선택 > 5
                        --- 계좌 이체 ---
                보내는 분 계좌번호 : 111-111
                비밀번호 : 1234
                받는 분 계좌번호 : 222-222
                이체할 금액 : 20000
                [안내] 이체가 완료되었습니다.

                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ===============================
                선택 > 4
                        --- 잔고 확인 (보내는 사람) ---
                계좌번호 : 111-111
                비밀번호 : 1234
                [잔고] 30000원

                =========== KB Bank ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                ============================
                선택 > 4
                        --- 잔고 확인 (받는 사람) ---
                계좌번호 : 222-222
                비밀번호 : 5678
                [잔고] 20000원

                =========== KB Bank  ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                =============================
                --- 계좌 이체 (잔액 부족) ---
                보내는 분 계좌번호 : 111-111
                비밀번호 : 1234
                받는 분 계좌번호 : 222-222
                이체할 금액 : 40000
                [경고] 잔액이 부족합니다.

                =========== KB Bank  ===========
                1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체
                =============================
                선택 > 5
                --- 계좌 이체 (비밀번호 오류) ---
                보내는 분 계좌번호 : 111-111
                비밀번호 : 0000
                받는 분 계좌번호 : 222-222
                이체할 금액 : 10000
                [경고] 계좌정보가 일치하지 않습니다.
*/
    }   // main e
}   // class e
