package 종합.과제5.model.dto;

// (역할) 데이터 모델 & 이동객체
public class WaitingDto {
    // 1. 멤버변수 : 모두 private한다.
    private String phone;
    private int count;

    // 2. 생성자 : 기본생성자, 풀생성자는 기본! , 추후 추가
    public WaitingDto() {}
    public WaitingDto(String phone , int count ){
        this.phone = phone;
        this.count = count;
    }

    // 3. 1) getter and setter 2) toString

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

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}
