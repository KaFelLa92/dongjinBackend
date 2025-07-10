package day09;

public class BankAccount {
    // 1. private accountNumber String 멤버변수
    private String accountNumber;

    // 2. accountNumber 초기화 생성자 this. 알지?
    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 3. public getAccountNumber() Getter 메소드 정의
    public String getAccountNumber() {
        return accountNumber;
    }
}
