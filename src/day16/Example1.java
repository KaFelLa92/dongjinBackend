package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
            [ 예외 처리 ]
            1. 시스템 오류 : 시스템이 종료되는 심각한 수준의 문제
            2. 예외 : 개발자가 구현한 로직이나 사용자의 영향으로 의한 문제
            3. 예외 종류
                1) 일반 예외 : 컴파일(실행)될때 예외 처리 코드 여부를 검사하는 예외
                    - 입출력 , 네트워크 , 파일 , JBDC(자바-DB연동) , 주로 자바 외부 통신 : class.forName(); , thread.sleep();
                2) 실행 예외 : 컴파일(실행)될때 예외 처리 코드 여부를 검사하지 않는 예외 , 개발자의 (경험) 의존도가 크다.

                * 웹/앱 라이브러리/프레임워크 (Spring) 는 자동 예외처리
            4. 예외란
                - 예외/오류 발생시 예외를 고치는게 아니라 흐름 제어 vs if 비슷
                - 프로그램을 24시간 중단 없이 실행하기 위한 안전한 로직 구현 < 100%는 없어요. -> 유지보수 >
            5. 예외 클래스
                ClassNotFoundException  : 클래스를 못찾았을때 발생되는 정보를 저장하는 클래스
                InterruptedException    : 흐름이 중단되었을때 발생되는 정보를 저장하는 클래스
            6. 사용법
                try{ 예외가 발생 할것 같은 코드 또는 일반 예외 }
                catch( 예외클래스명 매개변수명 ) { 지정한 예외 발생시 처리할 코드 }
                finally{ 예외 여부 상관없이 무조건 실행되는 코드 }


        */
        // ---------------------------------- 예제에서는 강제로 예외 발생하는 상황 -----------------------------------
        // [1] 일반 예외 : 예외가 있던/없던 무조건 예외 처리 해야한다.
        try {   // 1. 일반 예외 발생 코드를 try{} 감싼다.
            Class.forName("java.lang.String");  // Class.forName( 클래스경로 ) ; // 해당 경로의 클래스를 읽어오는 함수
        } catch (ClassNotFoundException e) {   // 2. catch( 예외클래스명 매개변수명){ } 에서 예외 발생시 처리할 코드
            System.out.println("[예외발생1] String 클래스가 없습니다.");
        }

        // [2] 일반 예외 , 예외발생
        try {
            Class.forName("java.lang.String2"); // String2 클래스는 존재하지 않아서 예외 발생한다.
        } catch (ClassNotFoundException e) {
            System.out.println("[예외발생2] String2 클래스가 없습니다. " + e);
        }

        // [3] 일반 예외
        try {
            Thread.sleep(1000);   // 코드 실행을 1초간 일시정지 함수. 함수를 쓰기 위해 try catch가 **반드시** 필요.
        } catch (InterruptedException e) {
            System.out.println("[예외발생3] sleep 도중에 오류 발생");
        }

        // [4] 실행 예외 : 프로그램 실행 도중에 발생하는 예외 , <예측>
        // !! .NullPointerException : 객체가 없는데 객체를 호출하면 발생하는 예외
        try {   // try와 catch 형제는 안전한 프로그램 흐름 제어에 활용됨.
            String str1 = "강호동";
            System.out.println(str1.length()); // 문자열변수.length() :  문자열 길이 반환 함수
            String str2 = null; // JAVA에서 null이란? 변수가 참조(저장)하는 값/객체가 없다는 뜻
            System.out.println(str2);   // str2를 프린트해보면 null인지 판단 가능. print 많이 찍으셈.
            System.out.println(str2.length()); // .(접근연산자)란 객체내 메소드 호출. null은 길이가 없으므로 오류 발생함.
        } catch (NullPointerException e) {
            System.out.println("[예외발생4] 객체가 없어서 .length() 사용불가능");
        }

        // [5] 실행 예외 : NumberFormatException
        try {
            String str3 = "100";            // 문자 100 저장 , 100 숫자o
            String str4 = "1aa";            // 문자 1aa 저장 , 1aa 숫자x
            Integer.parseInt(str3);       // Integer.parseInt( );
            System.out.println(str3);       // 100 잘나옴
            Integer.parseInt(str4);       // "100"은 숫자 100 될 수 있지만, "1aa"는 숫자 1aa 될 수 없음. 정수 표현 불가.
        } catch (NumberFormatException e) {
            System.out.println("[예외발생5] 정수로 변환 불가능하다.");
        }

        // [6] 실행 예외 : ArrayIndexOutOfBoundsException : 존재하지 않는 인덱스 호출 예외
        try {
            int[] intArray = {1, 2, 3};
            System.out.println(intArray[0]); // 0번 인덱스 1
            System.out.println(intArray[3]); // 3번 인덱스 존재하지 않아서 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[예외발생6] 존재하지 않는 인덱스를 찾을 수 없다.");
        }

        // [7] 실행 예외 : InputMisMatchException : 입력 데이터 타입이 다를때 예외 발생
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("정수 입력 : ");
            int value7 = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[예외발생7] 입력한 타입이 불일치합니다." + e);
        }

        // [8] 다중 catch와 finally
        try {
            // Integer.parseInt("1AA"); 예외 발생시 아래코드는 실행되지 않고 catch로 이동. 정수 예외를 주석처리하면 어레이 예외가 실행.

            int[] intArray = {1, 2, 3};
            System.out.println(intArray[10]);

            String str = null;
            System.out.println(str.length());
        } catch (NumberFormatException e1) {
            System.out.println(e1);
        } catch (ArrayIndexOutOfBoundsException e2){
            System.out.println(e2);
        } catch (NullPointerException e3){
            System.out.println(e3);
        } catch (Exception e4){         // 한 번예 예외 발생을 통제할 수 있지만, 다형성에 의한 흐름 제어를 할 수 없다.
            System.out.println(e4);
        }
        // -주의할점1 : 다중 catch시 먼저 발생한 예외부터 하나의 예외 발생하고, 하나의 catch만 실행된다.
        // -주의할점2 : Exception 클래스는 모든 예외를 처리하므로 다중 catch시 맨 아래에서 정의한다.
        finally {
            System.out.println("예외가 있던 없던 무조건 실행코드");
        }

    } // main end
} // class end