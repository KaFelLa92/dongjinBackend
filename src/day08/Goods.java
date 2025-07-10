package day08;

public class Goods {    // class start
    // 멤버변수 입력
    String name;
    int price;

    // (1) 오버로딩 기본 생성자
    Goods() {
        name = "미정";
        price = 0;
    }

    // (2) 오버로딩 매개변수 있는 생성자
    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }


} // class end
