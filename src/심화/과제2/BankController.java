package 심화.과제2;

// 해당 코드는 제어를 담당합니다.
public class BankController {

    // 0. 계좌 배열 선언
    // 싱글톤 설계
    private BankController() {
    } // 1단계

    private static final BankController bankBack = new BankController(); // 2단계

    public static BankController getInstance() {
        return bankBack; // 3단계
    } // func end

    // 메소드 생성
    // 1. 계좌 등록
    // 매개변수 String num , String pwd
    // 남은 null 계좌 있는지 확인하는 boolean 메소드
    boolean add(String num, String pwd) {
        return true;
    }

    // 2. 입금
    // 매개변수 num , pwd , bal
    // 리턴 boolean

    // 3. 출금
    // 매개변수 num , pwd , bal
    // 리턴

    // 4. 잔고
    // 매개변수 num, pwd

    // 5. 계좌이체
    // 매개변수 num ,pwd, bal

}
