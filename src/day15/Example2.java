package day15;  // package name

// * extends 하나의 클래스 vs implements 여러개의 인터페이스
interface Buy{
    public abstract void buy(); // 추상메소드
    // + 디폴트 메소드 : 인터페이스타입에서 구현한 메소드
    public default void method1(){ }
    // + 정적 메소드 : 인터페이스타입에서 정적 구현 메소드
    public static void method2(){ }
    // + private 메소드 : 현재 인터페이스타입에서만 사용가능한 구현 메소드
    private void method3(){ }
    // + private static 메소드 : 현재 인터페이스타입에서만 사용가능한 정적 구현 메소드
    private static void method4(){ }
} // class end

interface Sell{
    void sell();
}

class Customer extends Object implements Buy , Sell{
    // extends : 클래스 1개당 상속은 1개의 클래스만 가능 , 다형성 표현 제약
    // implements : 클래스 1개당 구현은 여러개의 인터페이스 가능 , 포괄적인 다형성 표현
    
    // * 각기 다른 인터페이스들의 추상메소드 재정의/구현 (오버라이딩) 하기
    @Override
    public void buy() {
        System.out.println("[구매]");
    }

    @Override
    public void sell() {
        System.out.println("[판매]");
    }
}   // class end

public class Example2 {
    public static void main(String[] args) {

        // [1]
        Buy buy = new Customer();
        
        // [2] 추상(abstract) 메소드
        buy.buy();
        // buy.sell(); 타입이 달라서 sell은 안 됨

        // [3] 디폴트 메소드
        buy.method1();

        // [4] 정적(객체 없이) 메소드
        Buy.method2();

        // [5] private 메소드 ?? 구현체에서 구현하지 않을때
        // 즉] 오버라이딩(재정의/구현) 금지. 내부에서만 쓸때 만듬.

        // [6] private static 메소드
        // 오버라이드 안됨. 타입 내부적으로 사용되는 정적 메소드.
        // Buy.method4();





    }   // main end
}   // class end
