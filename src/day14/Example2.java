package day14;

import java.awt.*;

// 상위 타입은 포괄적인 개념. 하위 타입은 상위 타입에 맞춰 디테일하게 잡을 수 있다.

class Car{      // 자동차 본체
    Tire tire;  // 자동차에 타이어 객체 넣기
    void run(){   // 자동차 굴리기
        this.tire.roll();
    }
}

class Tire{     // 타이어
    void roll(){
        System.out.println("[일반]타이어가 회전");
    }
}

class HankookTire extends Tire{ // 일반타이어로부터 상속받아 한국타이어 메소드 재정의
    void roll(){
        System.out.println("[한국]타이어가 회전(Upgrade)");
    }
}

class KumhoTire extends Tire{ // 일반타이어로부터 상속받아 금호타이어 메소드 재정의
    void roll(){
        System.out.println("[금호]타이어가 회전(Upgrade)");
    }
}


public class Example2 {
    public static void main(String[] args) {
        // (1) Car 객체 생성
        Car myCar = new Car();
//        myCar.run();     멤버변수(tire)가 null이라서 오류남. 타이어 꽂으세요
        myCar.tire = new Tire();
        myCar.run();    // '[일반] 타이어가 회전'

        // (2) 타이어 교체
        myCar.tire = new HankookTire(); // 멤버변수에 Htire 객체 대입
        myCar.run();    // [한국]타이어가 회전(Upgrade)

        // (3) 타이어 교체
        myCar.tire = new KumhoTire();
        myCar.run();    // [금호]타이어가 회전(Upgrade)

        // !! : Tire 타입의 멤버변수는 Tire 객체, Htire 객체, Ktire 객체를 모두 대입 받을 수 있다.
        // 이유 : 상속관계라서 자동타입변환. 자식타입은 부모타입으로 타입이 자동변환됨
        // 강제는

        System.out.println( myCar.tire instanceof Tire);        // true
        System.out.println( myCar.tire instanceof KumhoTire);   // true. 마지막에 금호로 갈았다.
        System.out.println( myCar.tire instanceof HankookTire); // false. 한국타이어 아까 뺐음
//      System.out.println( myCar.tire instanceof Object);
        // 이유 : 금호타이어 객체가 생성될때 : KumhoTire, Tire, (Object)
        // 하위타입의 객체를 생성하면 상위타입의 객체도 같이 생성된다.
        // 금호가 생성될 때 한국 객체는 생성되지 않는다. (형제 관계이기 때문)
    }
}
