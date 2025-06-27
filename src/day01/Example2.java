package day01;  // 현재 .java 파일 위치한 폴더명

// main 함수는 컴파일 후 자동으로 실행됩니다.

public class Example2 { // class start : 모든 자바코드는 클래스 안에 작성한다.

        // (1) main함수 선언 : m -> enter(자동 완성)
    public static void main(String[] args) {    // main start
        // (2) 리터럴 : (JAVA)언어들이 미리 정의한 데이터
            // ex) 3 , '김' , "김현수" , 3.14 , true    * JAVA는 '작은따옴표'와 "큰따옴표 구분이 있다.
            // 리터럴 모든 정수는 int , 모든 실수는 double
        // (3) 출력함수
            // JS : console.log( )
            // JAVA에서는 세미콜론 무조건 넣어야함
            // sout + enter(자동 완성)
        // (4) main함수 실행 : ctrl + shift + F10 버튼
        System.out.println(3);          // 리터럴 3 출력     , 명령어 끝에 ;(세미콜론) 필수!!!
        System.out.println(3.14);       // 리터럴 3.14 출력
        System.out.println('김');       // 리터럴 '김' 출력
        System.out.println("김현수");    // 리터럴 "김현수"출력
        System.out.println(true);       // 리터럴 true 출력
        // (5) 자료형/타입   , 8가지       * 기본자료형 vs 참조자료형
            // 정수 : byte , short , int(*) , long
            // 실수 : float , double(*)
            // 문자 : char               * 문자열 : String
            // 논리 : boolean
        // (6) 리터럴 값을 변수( *한 개만 저장 가능한 저장소* )에 대입하기.
        // ex) 자료형 변수명 = 리터럴
            // 1. booolean 타입 : true와 false만 저장 가능.
        boolean bool1 = true;   // 리터럴 true를 저장 가능한 타입
        boolean bool2 = false;
        // boolean bool3 = 3;      // 3 리터럴은 boolean에 저장 불가능
        System.out.println(bool1);  // 변수명 호출하여 변수값 출력
        System.out.println(bool2);
            // 2. char 타입 : '작은따옴표'로 감싼 문자 1개 저장 가능.
        char ch1 = 'A';
        // char ch2 = 'ABC'; // 불가능 , 문자열(문자여러개)
        // char ch3 = "ABC";   // 큰따옴표로 감싼 자료도 불가능
        System.out.println(ch1);
            // 3. String 클래스타입 : "큰따옴표"로 감싼 문자 여러개 저장.
        String str1 = "ABC";
        //  String str2 = 'ABC';    // 작은따옴표로 감싸면 불가능. , 백틱 없음.
        System.out.println(str1);
            // 4. byte 타입 : 정수 -128 ~ +127        1바이트
        byte b1 = 100;
        //    byte b2 = 300;  // 불가능 : 저장 허용 범위 벗어남.
        System.out.println(b1);
            // 5. short 타입 : 정수 +-3만 정도         2바이트
        short s1 = 32000;
        //    short s2 = 50000; // 불가능 : 저장 허용 범위 벗어남.
        System.out.println(s1);
            // 6. int 타입 :  정수 +- 21억 정도        4바이트 , 정수 리터럴*
        int i1 = 2100000000;
        //    int i2 = 3100000000;  // 불가능
        System.out.println(i1);
            // 7. long 타입 : 정수 +- 21억 이상        8바이트 , 리터럴 뒤에 L/l
        // long l1 = 300000000000000; // 불가능 : L 붙여서 타입변환하기
        long l2 = 300000000000000L; //
        System.out.println(l2);
            // 8. double 타입 : 실수 소수점 17자리까지 표현 , 실수 리터럴x
        double d1 = 0.12345678911231235435;
        System.out.println(d1); // 17자리까지 나오고 나머지는 생략
            // 9. float 타입 : 실수 소수점 8자리까지 표현 , 리터럴 뒤에 F/f 붙이기
        //    float f1 = 0.123423876327846324876; // 불가능 : 리터럴 뒤에 f붙이기
        float f2 = 0.342348937292835698326f;
        System.out.println(f2); // 8자리까지 나오고 나머지는 생략
        
        // 자료형 double과 Double 다르다.
        
    } // main end

}   // class end







