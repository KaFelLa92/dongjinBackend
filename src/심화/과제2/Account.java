package 심화.과제2;

// 해당 코드는 자료를 담습니다.
public class Account {
    // 1. 멤버변수 : 계좌번호, 비번, 잔액
    String num;
    String pwd;
    int bal;

    // 2. 생성자
    Account(String num, String pwd, int bal) {
        this.num = num;
        this.pwd = pwd;
        this.bal = bal;
    }

    // 3. 메tho드 : 비공개 멤버변수에 접근할 수 있도록 public getter and setter, toString
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "Account{" +
                "num='" + num + '\'' +
                ", pwd='" + pwd + '\'' +
                ", bal=" + bal +
                '}';
    }
}
