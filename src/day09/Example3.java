package day09;  // package name

public class Example3 { // class start
    public static void main(String[] args) {    // main start

        int[] intArray = { 10 , 20 , 30};
        // 자료1개(배열) 안에 자료3개(int) [10 , 20 , 30];
        // intArray = 배열

        int int1 = intArray[0];             // int1은 10. 배열내 0번째 값을 새로운 변수에 대입
        System.out.println( int1 );         // 10

        int1 = 100;                         // int1 = 10 -> int1 = 100
        System.out.println(intArray[0]);    // 10. int1을 수정한 것이지, int[0] 배열 인덱스를 수정한 게 아님.

        intArray[0] = 100;
        System.out.println(intArray[0]);    // 100
        

    }   // main end
}   // class end
