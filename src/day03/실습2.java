package day03;  // 패키지명

import java.util.Scanner;

public class 실습2 {  // class s
    public static void main(String[] args) { // main s

        /*
        [실습2] *제출용
                [ 문제] 아래 타입변환, 입력함수 관련 7문제
                [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
        */

        /*
        문제 1: a 와 b 두 변수의 합을 long 타입의 변수에 저장하여 그 결과를 출력하시오.
                선언 코드 :
        byte a = 10;
        int b = 200;
        출력 예시:
        결과: 210
        */

        byte a = 10;
        int b = 200;
        long C = a + b;
        System.out.println("결과값 : " + C);

        /*
        문제 2: 실수 3.141592를 double 타입 변수에 저장한 뒤, 이 변수를 int 타입으로 강제 변환하여 정수 부분만 출력하시오.
                선언 코드 :
        double z = 3.141592;
        출력 예시:
        원본 double 값: 3.141592
        변환된 int 값: 3
        */

        double z = 3.141592;
        int i1 = (int) z;
        System.out.println(i1);


        /*
        문제 3:Scanner를 이용하여 사용자의 이름 (String) 과 나이( int)를 입력받아, "OOO님의 나이는 OO세 입니다." 형식으로 출력하는 코드를 작성하시오.
        입력 예시:
        이름을 입력하세요:유재석
        나이를 입력하세요:51
        출력 예시:
        유재석님의 나이는 51 세 입니다.

         */
        /*
        Scanner info = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = info.nextLine();
        System.out.print("나이를 입력하세요 : ");
        int age = info.nextInt();
        System.out.println(name + "님의 나이는 " + age + "입니다.");
        */
        /*

        문제 4:Scanner를 이용해 게시물 번호 ( int),제목(String), 내용(String) 을 순서대로 입력받아 출력하시오.
        요구 조건:제목과 내용은 띄어쓰기가 포함될 수 있으므로 nextLine() 을 사용하시오.
        입력 예시:
        게시물 번호:1
        제목:
        자바는 재미있어요
        내용:
        정말입니다.다들 동의하시죠?
        출력 예시:
        [1 번 게시물 ]
        제목:
        자바는 재미있어요
        내용:
        정말입니다.다들 동의하시죠?
        */

        /*
        Scanner contain = new Scanner( System.in );
        System.out.print("게시물 번호를 입력하세요 : ");
        int num = contain.nextInt();
        contain.nextLine();
        System.out.print("제목을 입력하세요 : ");
        String title = contain.nextLine();
        System.out.print("내용을 입력하세요 : ");
        String text = contain.nextLine();

        System.out.println("[ " + num + "번 게시물 ]" );
        System.out.println("제목:");
        System.out.println(title);
        System.out.println("내용:");
        System.out.println(text);
        */

        /*
        문제 5:Scanner를 이용해 성별을 한 글자('남'또는 '여')로 입력받아 char 타입 변수에 저장하고, 입력된 성별을 출력하시오.
        요구 조건:Scanner에는 nextChar () 함수가 없으므로 next().charAt(0) 을 활용하시오.
        입력 예시:
        성별을 입력하세요 (남 / 여):남
        출력 예시:
        입력하신 성별은 '남' 입니다.
        */


        Scanner scan = new Scanner( System.in );
        System.out.println("성별을 입력하세요.");
        char gen = scan.next().charAt(0);
        System.out.println("입력하신 성별은 '" + gen + "' 입니다.");


        /*
                문제 6:Scanner를 이용해 사용자의 키를 double 타입 (예:178.5)으로 입력받은 후, 이 값을 int 타입으로 강제 변환하여 "당신의 키는 약 OOOcm 이군요."
        라고 정수 부분만 출력하시오.
        입력 예시:
        키를 입력하세요:178.5
        출력 예시:
        당신의 키는 약 178 cm 이군요.
         */

        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("키를 소수점까지 입력하세요.");
        double h1 = scan.nextDouble();
        int h2 = (int) h1;
        System.out.println("당신의 키는 약 " + h2 + "cm 이군요.");
        */

        /*
        문제 7:Scanner를 사용하여 아래 4 가지 정보를 순서대로 입력받아 출력하는 코드를 작성하시오.
                이름(String), 나이( int),키( double),프로그래머 여부 (boolean)
                입력 예시:
        이름:
        김자바
        나이:
        25
        키:
        165.8
        프로그래머입니까 ? (true / false) : true
        출력 예시:
        ---자기소개-- -
                이름:김자바
        나이:
        25
        키:
        165.8 cm
        프로그래머 여부:true
        */

        // 스캔 정보 수집
        Scanner info = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = info.nextLine();
        System.out.print("나이 : ");
        int age = info.nextInt();
        System.out.print("키 : ");
        double height = info.nextDouble();
        System.out.print("프로그래머입니까? (true / false)");
        boolean dev = info.nextBoolean();
        
        // 종합 출력
        System.out.println("--자기소개--");
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("키 : " + height);
        System.out.println("프로그래머 여부 : " + dev);

    } // main e
} // class e
