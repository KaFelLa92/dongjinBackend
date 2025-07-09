package day08;

public class Rectangle {
    // 멤버변수 설정
    int width;
    int height;

    // 멤버변수 width, height를 생성자 Rectangle에 매개변수로 넣기
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 메소드 getArea()에서 리턴값. 매개변수는 렉탱글에서 써서 없어도 됨
    int getArea() {
        return width * height;
    }

}
