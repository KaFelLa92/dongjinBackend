package day02;  // 현재 자바파일 폴더명(패키지명)

import java.util.Scanner;

public class Example2 { // class start
    public static void main(String[] args) { //main start


        // 입력함수 : 콘솔화면에서 키보드로부터 입력받은 방법
        // 1. new Scanner( System.in ); : 시스템(컴퓨터)으로부터 입력관련 기능(함수) 제공하는 객체
        //  * Scanner scan = new Scanner( System.in );
        // 2. 종류
        //         (1) .next()      : 키보드로부터 입력받은 문자열 반환 , 단] 띄어쓰기 불가능.
        //              String 변수명 = scan.next();
        //         (2) .nextLine()  : 입력받은 문자열 반환, 띄어쓰기 가능.
        //              *주의할점 : nextLine() 앞에 다른 next()가 존재하면 enter(개행)를 하나로 포함하므로 문자 추가 안됨.
        //              *해결방안 : nextLine() 앞에 무의미한 next() 하나 추가한다.
        //              String 변수명 = scan.nextLine();
        // [1] Scanner 객체로부터 .next() 함수 호출
        // new Scanner( System.in ).next();

        // [2] Scanner 객체를 변수에 저장하여 재활용 , 타입 변수명 = 자료;
        Scanner scan = new Scanner(System.in);
        // Scanner(객체타입) scan(변수명) =(대입) new Scanner(System.in)(객체)
        // 1. next()
        System.out.printf("1. next() : ");
        String str1 = scan.next();    // vs new Scanner( System in ).next();
        System.out.println("1. next result : " + str1);

        // 2. nextLine();
        System.out.print("2. nextLine() : ");
        scan.nextLine();    // 무의미한 nextLine() , nextLine() 문제점 해결을 위해서.
        String str2 = scan.nextLine();
        System.out.println("2. nextLine() result : " + str2);

        // 3. nextByte();   : 입력받은 정수(byte) 반환
        System.out.print("3. nextByte() : ");
        byte value1 = scan.nextByte();
        System.out.println("3. nextByte() result : " + value1);

        // 4. nextShort();  : 입력받은 정수(short) 반환
        System.out.print("4. nextShort() : ");
        short value2 = scan.nextShort();
        System.out.println("4. nextShort() result : " + value2);

        // 5. nextInt();    : 입력받은 정수(int) 반환 , 많이 씀. 허용범위 벗어나면 오류(약21억)
        System.out.print("5. nextInt() : ");
        int value3 = scan.nextInt();
        System.out.println("5. nextInt() result : " + value3);

        // 6. nextLong();   : 입력받은 정수(long) 반환 , 입력값이 long 허용범위 벗어나면 오류
        System.out.print("6. nextLong() : ");
        long value4 = scan.nextLong();
        System.out.println("6. nextLong() result : " + value4);

        // 7. nextFloat();  : 입력받은 실수(float) 반환 , 입력값이 float 허용범위 벗어나면 오류
        System.out.print("7. nextFloat() : ");
        float value5 = scan.nextFloat();
        System.out.println("7. nextFloat() result : " + value5);

        // 8. nextDouble(); : 입력받은 실수(double) 반환 , 입력값이 double 허용범위 벗어나면 오류
        System.out.print("8. nextDouble() : ");
        double value6 = scan.nextDouble();
        System.out.println("8. nextDouble() result : " + value6);

        // 9. nextBoolean(); : 입력받은 논리(boolean) 반환 , 허용범위 벗어나면 오류
        System.out.print("9. nextBoolean() : ");
        boolean value7 = scan.nextBoolean();
        System.out.println("9. nextBoolean() result : " + value7);

        // * nextChar() 없다.
        // 10. next().charAt( 0 ); 입력받은 문자열 중에 첫번째 글자 1개(char) 반환
        System.out.println("10. next().charAt(0) : ");
        char value8 = scan.next().charAt( 0 ); // 0번 인덱스. 즉 첫 번째 글자 반환.
        System.out.println("10. next().charAt(0) result : " + value8);

    }   //main end
}   //class end




