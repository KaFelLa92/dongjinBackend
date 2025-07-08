package day07;

public class Product {
    // 멤버변수 생성
    String name;
    int stock = 10;

    // 메소드
    boolean sell(int buyCount) {
        if (stock >= buyCount) {
            stock -= buyCount;
            System.out.println(buyCount + "개 구매하여 현재 재고" + stock + "입니다.");
            return true;
        } else {
            System.out.println("재고 부족");
            return false;
        }
    } // func end
} // class end
