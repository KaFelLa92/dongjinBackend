package day09;  // package name

class D {
    // final int finalVariable;     // 초기값이 없어서 오류가 뜹니다.
    final int finalVariable = 10;   // 초기값을 꼭 넣어줘야 오류가 안 뜹니다.
    // static은 '비멤버공유변수'다.
    static int nonMemberPublicVariable = 20; // 객체내 포함하지 않고 클래스가(new)하지 않아도 사용가능
    // 상수 만들기
    static final int constant = 10;
    // [5]
    void memberMethod1(){

    }
    static void nonMemberMethod(){

    }
    void memberMethod2(){
        memberMethod1();    // 가능
        nonMemberMethod();  // 가능
    }
} // class end


public class Example2 { // class start

    // static 아닌 method
    void memberMethod() {
    }

    // static인 method
    static void nonMemberMethod() {
    }

    public static void main(String[] args) {    // main start. 메인에는 스태틱이 붙어있다. 어디서든 불러올 수 있음.

        // [1] final 멤버변수 호출 가능 , 수정 불가능
        D d = new D();
        System.out.println(d.finalVariable);    // 호출 가능
        // d.finalVariable = 20;                // 수정 불가능

        // [2] static 정적변수에 호출 , 클래스명.정적변수명;
        System.out.println(D.nonMemberPublicVariable); // 가능
        D.nonMemberPublicVariable = 20; // 가능
        System.out.println(d.nonMemberPublicVariable); // 객체도 static 가능.     // 20

        // [3] 상수 호출 , 클래스명.상수명;
        System.out.println(D.constant);

        // [4] static 메소드 내 static 유무 메소드 호출
        // memberMethod(); 불가능
        Example2 exam = new Example2();
        exam.memberMethod();    // 가능 : 객체를 통해 메소드 사용 가능.
        nonMemberMethod();      // 가능 : 객체 없이 메소드 사용 가능.
        
        // [5] static 메소드가 아닌 static 유무 메소드 호출


        /*
        [ final ] *최후의
            1. 고정 상태를 정의할때 사용된느 키워드 (수정 불가능한 상태)
            2. 사용법 : final 타입 멤버변수
            3. 주의할점 : 초기값이 무조건 존재해야한다.

        [ static ] *정적인
            1. 프로그램 실행될때 메모리 할당(new)되는 키워드 (실행중에 변화가 없는 상태를 정의할때 사용되는 키워드)
            2. 사용법 : static 타입 멤버변수 -> static(정적) 변수
            3. 주의할점 : 멤버변수(객체내변수) 공유X new vs static(우선할당) 공유O
                1) 프로그램내 딱 1개만 존재하는 변수를 선언할때 사용, 서로 다른 객체들이 공유해서 사용한다.

        [ 상수 ] : 변하지 않는 변수
            1. 사용법 : public static final 타입 상수명;
            2. 주의할점 : 1) 수정 불가능 2) 프로그램내 딱1개 존재 3) 상수명 대문자 사용

        [ static 유무 중요한 이유 ]
            !!!!!! : static으로 선언된 메소드는 같은 클래스내 메소드를 호출할수 없다.
            방법1: 객체를 생성하여 객체를 통해 static 아닌 메소드 호출한다.

            class Test {
                static void main3(){ }
                void main2(){ }
                static void main(){
                    main2();            // 불가능 : main함수는 우선할당이 되고, main2는 불러올수 없는 상태가 됨.
                    new Test().main2(); // 가능 : static 없는 경우 객체통해 가능.
                    main3(){ }          // 가능 : main함수는 우선할당이 되면서, 우선할당된 main3를 알고 있다.
                }
            } // class end


        */
    }   // main end
}   // class end
