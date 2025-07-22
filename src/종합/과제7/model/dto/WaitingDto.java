package 종합.과제7.model.dto;

public class WaitingDto {
    // 멤버변수
    private String number;
    private int count;

    // 생성자
    public WaitingDto(String number, int count) {
        this.number = number;
        this.count = count;
    }

    // 메소드 (getter and setter , toString)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
                "number='" + number + '\'' +
                ", count=" + count +
                '}';
    }
}
