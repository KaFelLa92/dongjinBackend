package day02;  // 폴더(패키지)명

public class Example3 { // class s
    public static void main(String[] args) { // main s

        /*

            [연산자]
            1. 산술연산자 : +더하기 -빼기 *곱하기 /나누기 %나머지
            2. 연결연산자 : 피연산자(자료)중에 문자열이 포함되면 산술 대신에 연결
                "문자열"+10 , "문자열"+변수명
            3. 비교연산자 : >초과 , <미만 , >=이상 , <=이하 , ==같다 , !=같지않다
            4. 논리연산자 : &&이면서 ||이거나 !부정
            5. 증감연산자 : 
                    ++변수명 : 선위증가 , 변수명++ : 후위증가 
                    --변수명 : 선위감소 , 변수명-- : 후위감소
            6. (복합)대입연산자
                    = 오른쪽 값을 왼쪽에 대입
                    += 오른쪽 값을 왼쪽값에 더한 후 대입
                    -= *= /= %= 오른쪽 항의 값을 왼쪽 항의 값에 연산후 왼쪽 항에 대입
            7. 삼항연산자 :
                조건 ? 참 : 거짓
                조건1 ? 참1 : 조건2 ? 참2 : 거짓
                * 너무 복잡하면 if 쓰세요

            * 문자열 비교 : "문자열A".equals("문자열B")


        */
        int x = 10;
        int y = -3;
        // [1] 연결연산자 : 두 항을 연결한 하나의 문자열 반환
        System.out.println(x + "개");    // 10개

        // [2] 산술연산자 : 두 항을 연산한 하나의 결과를 반환
        System.out.println(x + y);    // 7
        System.out.println(x - y);    // 13
        System.out.println(x * y);    // -30
        System.out.println(x / y);    // -3 , 소수점이 안 나오는 이유 : int/int라서.
        // System.out.println(10.0 / -3.0);    // double/double이면 -3.33333333 나옴.
        System.out.println(x % y);     // 1

        // [3] 비교연산자 : 두 항을 비교한 결과를 논리(boolean) 반환
        System.out.println(x > y);    // 10 > -3 , true
        System.out.println(x < y);    // 10 < -3 , false
        System.out.println(x >= y);   // 10 >= -3 , true
        System.out.println(x <= y);   // 10 <= -3 , false
        System.out.println(x == y);   // false
        System.out.println(x != y);   // true

        // [4] 논리연산자 :
        System.out.println(x > 10 && x < 20); // 10 > 10 and 10 < 20 , false
        System.out.println(y == 10 || y == 20); // -3 == 10 or -3 == 20 , false
        System.out.println(!(x >= 30));       // x는 30보다 크지 않다 , true

        // [5] 증감연산자 :
        System.out.println(x++);              // 10 , 출력 후 1 증가
        System.out.println(++x);              // 12 , 1 증가 후 출력
        System.out.println(x--);              // 12 , 출력 후 1감소
        System.out.println(--x);              // 10 , 1 감소 후 출력

        // [6] 복합 대입연산자
        int z = 30; // 오른쪽 30(자료)이라는 자료를 왼쪽 z변수에 대입한다.
        z += 10;    // z = 40;
        z += 1;        // vs z++ vs z = z + 1   z = 41;
        System.out.println(z);

        // [7] 삼항연산자 , 조건 ? 참 : 거짓
        // x += 50;
        System.out.println( x >= 60 ? "합격" : x >= 40 ? "재시험" : "불합격"); // x가 60 이상이면 합격, 아니면 불합격 vs 조건문(if)

        // [8] 문자열 비교는 "문자열A".equals("문자열B:)
        // System.out.println("10" == 10); // .안 됨
        System.out.println("10".equals("10"));          // true;
        System.out.println("admin".equals("admin"));    // true;

    }   // main e
}   // class e
