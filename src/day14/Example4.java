package day14;

class 자동차{
    타이어 tire; // 멤버변수
    void run(){ // 메소드
        this.tire.roll();
    }
}   // class end

interface 타이어{    // 인터페이스
    void roll();    // 추상메소드 : {}없다.
}   // inter end

class 한국타이어 implements 타이어{
    // @Override : 생략 가능
    public void roll() {
        System.out.println("[한국] 타이어가 회전(구현)");
    }
}

class 금호타이어 implements 타이어 {
    // 추상메소드 자동완성 : (방법1) ctrl + space (방법2) 오른쪽클릭 -> [생성] -> [메소드 구현]
    @Override
    public void roll() {
        System.out.println("[금호] 타이어가 회전(구현)");
    }
}

// 익스텐즈는 하나만 받을 수 있음
// 인터페이스는 여러개 꽂아도 됨. 단 멤버변수와 생성자를 못 받음.
public class Example4 {
    public static void main(String[] args) {

        자동차 myCar = new 자동차();
//      myCar.run(); 이건 안 된다고

        // 인터페이스 생성자가 없다. 객체생성 불가능.
//        myCar.tire = new 타이어();
        
        // [1] 구현체
        myCar.tire = new 한국타이어();   // 클래스라서 객체 생성 가능
        myCar.run();    // [한국] 타이어가 회전(구현)

        myCar.tire = new 금호타이어();
        myCar.run();    // [금호] 타이어가 회전(구현)

        // tire 멤버변수는 '타이어' 타입인데
        // 왜? '한국타이어'/'금호타이어' 타입이 대입될까?
        // - 구현관계라서
        // - 한국타이어와 금호타이어는 타이어 타입을 구현했기 때문에

        System.out.println(myCar.tire instanceof 타이어); // true
        System.out.println(myCar.tire instanceof 금호타이어); // true
        System.out.println(myCar.tire instanceof 한국타이어); // false

    } // main end
} // class end
