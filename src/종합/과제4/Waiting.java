package 종합.과제4;

public class Waiting {
    // 1. 멤버변수 : private 접근 제한자로 phone(문자열)과 count(정수) 멤버변수 선언
    // 캡슐화하는 이유 : 보안, 유효성검사 등에 유용한 관례적인 방식
    private String phone;
    private int count;

    // 2. 생성자 : public 접근 제한자를 가진 기본생성자를 만들어 받은 정보 초기화.
    public Waiting(String phone , int count){ // 매개변수 받는 생성자
        this.phone = phone;
        this.count = count;
    }

    // 3. 메소드 : 비공개 멤버변수에 접근할 수 있도록 public Getter / Setter 메소드 정의
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
