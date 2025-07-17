package day14;  // package name


class highClass{
    // 1. 멤버변수
    int value1 = 10;
    int value2 = 20;

    // 2. 생성자
    highClass(){
        System.out.println("[highClass instance gen]");
    } // func end

    // 3. 메소드
    void showValue(){
        System.out.println(">>highClass method access<<");
    } // func end
} // class end

class lowClass extends highClass{   // 클래스B extends 클래스A{ }
    // 1. 멤버변수
    int value3 = 30;
    int value2 = 40;

    // 2. 생성자
    lowClass(){
        System.out.println("[lowClass instance gen]");
    }

    // 3. 메소드
    void showValue2(){
        System.out.println(">>lowClass method access<<");
    }

    // 메소드 2 , 상위클래스 메소드와 동일
    void showValue(){
        System.out.println(">>lowClass method access<<");
    }
}

public class Example1 { // class start
    public static void main(String[] args) {    // main start

        // (1) 상위 클래스 객체 생성
        highClass obj1 = new highClass();
        obj1.showValue();
//      obj1.showValue2(); 자식 멤버 못씀
        
        // (2) 하위 클래스 객체 생성
        lowClass obj2 = new lowClass();
        obj1.showValue();   // 현재타입
        obj2.showValue2();  // 상위타입 접근 가능

        // (3) 멤버변수명이 동일할때 구분
        System.out.println( obj2.value1 );
        // 상위클래스의 멤버변수 10;
        System.out.println( obj2.value3 );
        // 현재클래스의 멤버변수 30;
        System.out.println( obj2.value2 );
        // 상위타입, 하위타입에 동일한 멤버변수명이 있다면? 현재클래스의 멤버변수 40 나옴. 현재타입 우선

        highClass obj3 = obj2;
        System.out.println(obj3.value2);
        // 하위타입에서 상위타입으로 변환후 동일한 멤버변수명 있다면, 현재타입.
        
        // (4) 메소드명이 동일할때 구분 : 오버라이딩
        // 메소드는 객체마다 할당이 아니고 메소드는 모든 객체들이 공유
        // 오버로딩 vs 오버라이딩
        obj2.showValue(); // 현재타입 메소드 실행됨
        obj3.showValue(); // 띠용? 하위타입 메소드 실행됨. 현재타입 아님. *태생* 타입의 메소드 실행.
        // 오버라이딩은 자식 타입이 우선.
        highClass obj5 = new highClass();
        obj5.showValue();



    }   // main end
}   // class end
