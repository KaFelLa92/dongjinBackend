package 심화.과제1;

public class BankController {
    // 배열 만들기
    Account[] accounts = new Account[100];

    // 메소드
    // 1. 계좌 등록
    // 매개변수 String accountNum, String pwd
    // 남은 null 계좌 있는지 확인하는 boolean 메소드
    boolean addAccount(String accountNum, String pwd) {
        // accounts에 등록할 account 객체 생성
        Account account = new Account();
        // 객체 멤버변수 = 매개변수로 받은 값
        account.accountNum = accountNum;
        account.pwd = pwd;
        // null 확인하고 배열에 집어넣기 (for, if)
        for (int i = 0; i <= accounts.length - 1; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;  // 계좌 등록으로 만든 값이 배열 인덱스에 들어감
                return true;    // true값 뱉어내면 메인에서 true 체크로 다른 출력 만들 수 있다.
            }
        } // for end

        return false;  // for문에 null 없으면 false

    }

    // 2. 입금
    // 매개변수 accountNum, pwd, int money, int money
    // 돈 넣으니까 int 메소드? 그냥 true false

    boolean pushMoney(String accountNum, String pwd, int money) {
        // 돈 넣기 전에 배열에 계좌랑 비번 일치하는지 확인
        // 그러러면 객체 생성해야겠지? 응 하지마 이미 생성했어
//        Account account = new Account();
        // 멤버변수 중 if 체크할 것 꺼내두기 응 체크 for문에서 한꺼번에 해
//        account.accountNum = accountNum;
//        account.pwd = pwd;
        // 배열에서 찾기
        for (int i = 0; i <= accounts.length - 1; i++) {
            if (accounts[i] != null && accounts[i].accountNum.equals(accountNum) && accounts[i].pwd.equals(pwd)) { // 어카운츠 인덱스(배열 저장요소)가 입금 위해 입력한 account와 같다면?
                accounts[i].balance += money;
                return true;
            }

        } // for end
        return false;

    }

    // 3. 출금
    // 매개변수 accountNum, pwd, int balance
    // 출금할 돈 있는지 체크하는 boolean 메소드 or 돈 뺄 거니까 int 메소드
    boolean pullMoney(String accountNum, String pwd, int money, int balance) {
        // for문으로 배열에서 계좌 번호, 비번 찾기
        for (int i = 0; i <= accounts.length - 1; i++) {
            //  if문으로 계좌번호, 비번이 기존 인덱스 요소와 맞는지 비교
            if (accounts[i] != null && accounts[i].accountNum.equals(accountNum) && accounts[i].pwd.equals(pwd)) { // 어카운츠 인덱스(배열 저장요소)가 입금 위해 입력한 account와 같다면?
                // 다시 if문으로 balance가 money보다 큰지 확인
                if (balance > money) {
                    accounts[i].balance -= money;
                    return true;
                }
            }
        }
        return false;
    }


    // 4. 잔고 체크
    // 계좌, 비번 같은지 체크
    // 출력

    Account[] balanceCheck(String accountNum, String pwd, int balance) {
        for (int i = 0; i <= accounts.length - 1; i++) {
            //  if문으로 계좌번호, 비번이 기존 인덱스 요소와 맞는지 비교
            if (accounts[i] != null && accounts[i].accountNum.equals(accountNum) && accounts[i].pwd.equals(pwd)) {
                return accounts[i].balance;
            }
        }
    }
}