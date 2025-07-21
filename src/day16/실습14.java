package day16;

public class 실습14 {

    // 7-1. 코드를 포함하는 메소드 생성
    // 7-2. 트라이 캐치 대신 throws로 예외 던지기
    public static void pauseOneSecond() throws InterruptedException{
        Thread.sleep(1000);
    }

    public static void main(String[] args) {
        /*
        [JAVA] 실습14 : 예외 처리
[ 문제 ] 아래 예외 처리 관련 문제를 해결하시오.
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/

        /*
[문제 1] ArithmeticException 처리
        1. 두 정수를 나누는 코드를 작성하세요.
        2. try-catch 문을 사용하여, 0으로 나눌 때 발생하는 ArithmeticException을 잡으세요.
        3. catch 블록에서는 "0으로 나눌 수 없습니다." 라는 메시지를 출력하세요.
                필요 코드:
        int result = 10 / 0;
*/

        // 1-1. 정수 나누는 코드 작성
        // 1-2. try catch 문으로 0으로 나눌 때 예외 처리하는 아리스메딕익셉션
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // 1-3. 0으로 나눌 수 없습니다 출력
            System.out.println("정수든 실수든 0으로 나눌 수 없습니다." + e);
        }


        /*
[문제 2] NumberFormatException 처리
        1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NumberFormatException을 처리하세요.
        2. catch 블록에서는 "잘못된 숫자 형식입니다." 라는 메시지를 출력하세요.
                필요 코드:
        String notANumber = "오류";
        int value = Integer.parseInt(notANumber);
*/

        // 2-1. 코드 입력 후, try-catch문 사용하기
        try {
            String notANumber = "오류";
            int value = Integer.parseInt(notANumber);
        } catch (NumberFormatException e) {
            // 2-2. 잘못된 숫자 형식 메시지 출력
            System.out.println("잘못된 숫자 형식입니다." + e);
        }


        /*
[문제 3] ArrayIndexOutOfBoundsException 처리
        1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 ArrayIndexOutOfBoundsException을 처리하세요.
        2. catch 블록에서는 "잘못된 인덱스에 접근했습니다." 라는 메시지를 출력하세요.
                필요 코드:
        String[] fruits = {"사과", "바나나"};
        System.out.println(fruits[2]);
*/

        // 3-1. 코드 입력후 트라이캐치문 사용하여 없는 배열 인덱스 찾는 예외 처리하기
        try {
            String[] fruits = {"사과", "바나나"};
            System.out.println(fruits[2]);
        } catch (ArrayIndexOutOfBoundsException e){
            // 3-2. 메시지 출력
            System.out.println("잘못된 인덱스에 접근했습니다." + e);
        }
        /*
[문제 4] NullPointerException 처리
        1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NullPointerException을 처리하세요.
        2. catch 블록에서는 "객체가 초기화되지 않았습니다." 라는 메시지를 출력하세요.
                필요 코드:
        String text = null;
        System.out.println("글자 수: " + text.toUpperCase());
*/

        // 4-1. 코드 입력 후 트라이캐치문 사용하여 null의 객체를 초기화시키려는 오류를 예외 처리
        try {
            String text = null;
            System.out.println("글자 수: " + text.toUpperCase());
        }catch (NullPointerException e){
            // 4-2. 메시지 출력
            System.out.println("객체가 초기화되지 않았습니다." + e);
        }
        /*
[문제 5] finally 블록으로 리소스 정리하기
        1. "데이터베이스 연결을 시작합니다."를 출력하는 코드를 try 블록에 작성하세요.
        2. finally 블록을 사용하여, 예외 발생 여부와 상관없이 항상 "데이터베이스 연결을 종료합니다."가 출력되도록 만드세요.
*/
        // 4-1. 출력 코드를 try 블록에 작성
        try {
            System.out.println("데이터베이스 연결을 시작합니다.");

        } // 4-2. finally로 예외 발생 여부와 관계없이 항상 DB 연결 종료 출력되게 하기
        catch (Exception e){
            System.out.println("[예외발생]");
        }
        finally {
            System.out.println("데이터베이스 연결을 종료합니다.");
        }
        /*
[문제 6] 다중 catch 블록
        1. 하나의 try 블록 안에서 NullPointerException 또는 ArithmeticException이 발생할 수 있도록 코드를 작성하세요.
        2. catch 블록을 두 개 사용하여, 각 예외를 개별적으로 처리하고 어떤 예외가 발생했는지 메시지를 출력하세요.
        필요 코드
        String text = null;
        text.length();
        int result = 5 / 0;
*/
        // 6-1. 하나의 try 블록에서 널포인터(null의 길이를 세거나 객체화하려는 등 불가능한 행동)와 아리스메틱(정수 0으로 나눌때)이 발생하게 코드 작성
        try {
            int result = 1 / 0;
            String blank = null;
            System.out.println(blank.length());
        } // 6-2. 캐치 블록 두 개 사용하여 개발적으로 예외처리
        catch ( NumberFormatException e1){
            System.out.println("[예외처리] null은 호출할 수 없습니다." + e1);    // 나중에 예외처리 되었기에 캐치문 생략
        } catch (ArithmeticException e2){
            System.out.println("[예외처리] 숫자를 0으로 나눌 수 없습니다." + e2);   // 먼저 예외처리 되어서, 이것만 나옴
        }

        // 트라이캐치는 가장 먼저 발생한 예외처리만 실행하고 종료된다.

        /*
[문제 7] throws로 예외 떠넘기기
        Thread.sleep(1000); 코드를 포함하는 pauseOneSecond() 메소드를 만드세요.
        이 메소드는 try-catch 대신 throws InterruptedException를 사용하여 예외를 떠넘기도록 선언하세요.
                main 함수에서 pauseOneSecond() 메소드를 호출하고, try-catch를 사용하여 떠넘겨진 예외를 처리하세요.
        필요 코드
        Thread.sleep(1000); // 1초간 프로그램 일시정지
*/

        // 7-3. 메인에서 메소드 호출 후, 트라이캐치로 예외 처리
        try {
            pauseOneSecond();
        } catch (InterruptedException e){
            System.out.println("[예외처리] 코드 진행 중 1초간 일시정지합니다.");
        }


        /*
[문제 8] Exception 클래스로 모든 예외 처리
        1. try 블록 안에 ArrayIndexOutOfBoundsException을 유발하는 코드를 작성하세요.
        2. catch 블록을 단 하나만 사용하여, 모든 예외의 부모 클래스인 Exception 타입으로 예외를 처리하세요.
        3. catch 블록에서는 "알 수 없는 오류가 발생했습니다." 라고 출력하세요.
        필요코드
        int[] arr = new int[2];
        System.out.println(arr[5]);
*/

        // 8-1. try 블록에 배열 중 없는 인덱스를 찾을 때 발생하는 예외 처리 코드 작성
        try{
            int[] array = new int[2];
            System.out.println(array[5]);
        } // 8-2. catch 블록 하나만 사용하여, Exception 타입으로 예외처리
        catch (Exception e){
            // 8-3. 알 수 없는 오류 발생 출력
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }

    } // main end
} // class end
