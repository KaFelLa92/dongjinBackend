package day08;

public class BankAccount {

    // 멤버변수 선언
    String accountNumber;
    String ownerName;
    int balance;

    // 멤버 변수 초기화 생성자
    BankAccount(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    } // func end

    // 1) 입금 메소드
    // 잔액에 입금액 더하기
    // 매개변수 : 입금액 , 리턴값 : 잔액 / int로 잔액 보여주거나 boolean으로
    int deposit(int money) {
        balance += money;
        return balance;
    } // func end

    // 강사님 풀이
//    boolean deposit(int money){
//        balance += money;
//        return true;
//    }

    // 2) 출금 메소드
    // 잔액에 출금액 빼기
    // 매개변수 : 출금액 , 리턴값 : 잔액
    int withdraw(int money) {
        if (balance >= money) {
            balance -= money;
        } else {
            System.out.println("잔액이 없잖슴. 그럼 돈을 못빼잖슴.");
        }
        return balance;
    } // func end

} // func end
