package day02;  // 패키지명

public class Example1 { // class start
    public static void main(String[] args) { // main start


        // (변수)타입변환 , 캐스팅 , 다형성(하나의 자료가 여러 타입으로 변환할 수 있다.)
        // 1. 자동 타입변환 (묵시적)
            // byte -> short/char -> int -> long -> float -> double
            // (1) 메모리 크기가 작은 것부터 큰 것으로 변환 가능
            // (2) 데이터의 손실이 적다
            // 변환할타입명 변환타입의변수명 = 원래변수명
        byte byteValue = 10;            // 10자료를 byte타입으로 분류
        short shortValue = byteValue;   // byte -> short 가능!
        int intValue = shortValue;  // short -> int 가능!
        long longValue = intValue;  // int -> long 가능!
        float floatValue = longValue; // long -> float 가능!
        double doubleValue = floatValue; // float -> double 가능! , 10자료를 double타입으로 분류
        System.out.println(doubleValue);

        // 2. 강제 타입변환 (명시적)
            // double -> float -> long - > int -> short/char -> byte
            // (1) 메모리 크기가 큰 것에서 작은 것으로 변환 가능
            // (2) 데이터의 손실이 크다
            // (3) (변환할 타입명)변수명;
        double dvalue = 3.14;
        float fvalue = (float) dvalue;  // double -> float 강제가능.
        long lvalue = (long) fvalue;    // float -> long 강제가능   손실발생 : 3.14 -> 3
        int ivalue = (int) lvalue;      // long -> int 강제 가능
        short svalue = (short) ivalue;  // int -> short 강제 가능
        byte bvalue = (byte) svalue;    // short -> byte 강제 가능
        System.out.println(bvalue);

        // 3. 연산 타입변환
            // byte + byte = int , byte + short = int , int + int = int
            // (1) int 이하 연산은 모두 결과가 int이다.
            // (2) 연산결과는 두개 항 중에 더 큰 항으로 자동 타입변환.
        byte b1 = 10;       byte b2 = 20;       short s1 = 30;      int i1 = 40;    long l1 = 50;
        float f1 = 3.14f;   double d1 = 41.25;
        int result = b1 + b2;
        int result2 = b1 + s1;
        int result3 = i1 + i1;
        long result4 = i1 + l1;     // int + long => long
        float result5 = i1 + f1;    // int + float => float
        double result6 = i1 + d1;   // int + double => double



    } // main end
} // class end
