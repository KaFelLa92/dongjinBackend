package day13; // package name

// * 자바의 모든 클래스는 자동으로 extends Object이므로 자바는 100% 객체지향이다.
class A {                                       // 부모 : Object , 자식 : B/C , 자손 : D/E
    A() {   // A클래스 생성자
        System.out.println("A 객체 탄생");
    }
}   // class end

class B extends A { // B는 A로부터 상속받는다        // 부모 : A , 자식 : D
    B(){
        System.out.println("B 객체 탄생");
    }
}   // class end

class C extends A { // C는 A로부터 상속받는다        // 부모 : A , 자식 : ㄸ
    C(){
        System.out.println("C 객체 탄생");
    }
}   // class end

class D extends B { // D는 B로부터 상속받는다        // 부모 : B
    D(){
        System.out.println("D 객체 탄생");
    }
}   // class end

class E extends C { // E는 C로부터 상속받는다        // 부모 : C
    E(){
        System.out.println("E 객체 탄생");
    }
}

public class Example2 { // class start
    public static void main(String[] args) {    // main start

        // (1) A클래스로 객체 생성시 총 객체수 : 2개 (Object -> A)
        System.out.println("[1] ================= ");
        A a = new A(); // A, Object

        // (2) B클래스로 객체 생성시 총 객체수 : 3개 (Object -> A -> B)
        System.out.println("[2] ================= ");
        B b = new B();  // B, A, Object

        // (3) C클래스로 객체 생성시 총 객체수 : 3개 (Object -> A -> C)
        System.out.println("[3] ================= ");
        C c = new C();  // C, A, Object

        // (4) D클래스로 객체 생성시 총 객체수 : 4개 (Object -> A -> B -> D)
        System.out.println("[4] ================= ");
        D d = new D();  // D, B, A, Object

        // (5) E클래스로 객체 생성시 총 객채수 : 4개 (Object -> A -> C -> E)
        System.out.println("[5] ================= ");
        E e = new E();  // E, C, A, Object
        
        // (6) 자동타입변환 -> 자식에서 부모로 올라갈때 (정순) 
        A a1 = b;       // b객체(값)는 B타입. 밑에서 위로 올라가는 변환 가능
        Object o1 = b;  // b객체(값 = 멤버변수)따라서, 자바의 모든 객체는 다 Object로 타입변환가능.
//      B b2 = c;       // b객체와 c객체는 상속 관계가 아니라서 자동타입변환 안됨.

        // (7) 강제타입변환 -> 부모에서 자식으로 내려갈때 (역순) 앞에 (클래스명)
        B b2 = (B)a1;      // 가능! a1의 태생은 b
        Object o2 = e;

        A a2 = e;           // 자동
        C c1 = (C)a2;       // 강제
//      B b3 = (B)a2;       // 강제 불가능  문법오류가 아닌 실행오류
        
        // (8) 인스턴스(객체/값) 타입 확인 방법
        // 객체 instance of 타입/클래스명 : 객체가 지정한 클래스 타입 확인
        // 강제타입변환 전에 확인 목적
        System.out.println( a instanceof Object);   // true
        System.out.println( c instanceof A );       // true
        // System.out.println( e instanceof B);     // false 출력 오류
        System.out.println(a2 instanceof C );       // true
        System.out.println(a2 instanceof B );       // false

        // (9) 상속 활용처
        // 1. 웹/앱 라이브러리
        // 2. 클래스 설계 단계
        //      코드 치다가 명령어(코드)가 중복되면 메소드화
        //      클래스정의하다가 다른 클래스와 멤버변수 중복되면 상속화

    }   // main end
}   // class end
