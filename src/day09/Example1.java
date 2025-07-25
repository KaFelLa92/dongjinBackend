package day09;  // package name

import day09.package1.A;
import day09.package2.C;

public class Example1 { // class start  클래스명 앞에 접근 제한자 public 붙었죠?
    public static void main(String[] args) {    // main start

        /*
        JAVA 객체지향의 4대 특징 : 다형성, 캡슐화, 상속(아직 안 배움 ㅎㅎ), 추상화(아직 안 배움 22)
                연산자? : + - * / %
         [ 접근 제한자 ] : 캡슐(알약 -> 내부감추기)화 특징
            1. 정의 : 클래스, 멤버변수, 생성자, 메소드 등등 접근(호출/사용) 제한한다.
                * 왜?? 학습에서는 안 중요하지만, 실무에서는 굉장히 중요함.
                비정상적인 접근(보안이 필요한)에서 필수로 사용됨.
            2. 종류
                1) public       : 공개    , 프로젝트 폴더내 어디서든 접근 가능
                2) private      : 비공개   , 현재 클래스에서만 접근 가능
                3) (default)    : 같은/하위 패키지에서만 접근 가능    , 키워드 선언x
                4) protected    : 같은/하위 패키지에서만 접근 가능    , 상속관계 예외
            3. 사용법 : 타입 앞에 존재한다.
                1) 멤버변수 타입 앞에      , 접근제한자 타입 변수명;
                2) 생성자명 앞에          , 접근제한자 생성자명(){}
                3) 클래스명 앞에          , 접근제한자 class 클래스명{}
                4) 메소드명 반환타입 앞에   , 접근제한자 반환타입 메소드명(){}
         [ 패키지 ] * 폴더와 같은 개념
            1. 정의 : 파일들을 저장하는 공간 , 식별자
            2. 주의할점 : 같은 패키지내 같은 클래스명 존재할수 없다.
                * 다른 패키지내 같은 클래스명으로 존재할수 있다.
            3. 사용법
                import : 같은 패키지가 아닌 다른 패키지의 클래스 가져오는 키워드
                    예] import 경로.클래스명;
                    * 자동완성 사용하면 자동 import 가능하다.
                    * 단] java.lang 패키지와 동일 패키지내 클래스는 예외/생략가능
                        -> System클래스 , String클래스 등등
                        * Scanner는 java.util
         [ getter and setter]
            1. 정의 : 클래스내 private 멤버변수를 다른 클래스가 사용할 수 있도록 하는 정의함수.
            2. 관례적으로
                1) 저장/대입 목적 : setter
                    public set멤버변수명( 타입 매개변수) {
                        this.멤버변수명 = 매개변수;
                    }
                2) 호출/반환 목적 : getter
                    public 반환타입 get멤버변수명() {
                        return 멤버변수명;
                    }
         */




        // [1] 하위 package1 폴더내 A클래스 접근
        A a = new A();
        System.out.println(a.publicVariable);   // 가능
//      System.out.println(a.privateVariable);  // 오류발생 : 다른 클래스에서 접근 불가능
//      System.out.println(a.normalVariable);    // 오류발생 : 같은 패키지에서만 접근 가능

        // [2] 하위 package2 폴더내 C클래스 접근
        C c = new C();
//      System.out.println(c.privateVariable);  // 오류발생
        System.out.println(c.methodReturn("123"));  // 가능. 공개 메소드로 상수화해서 불러올 수 있다.
//      c.methodSave( 3); 오류발생
    }   // main end
}   // class end
