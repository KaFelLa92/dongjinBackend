/*

[실습1] * 제출용
문제 1: 리터럴(Literal)과 기본 출력 함수
지시: System.out.println() 함수를 사용해서 숫자 25와 문자열 "홍길동"을 각각 다른 줄에 출력 하시오.

문제 2: 변수(Variable) 선언과 기본 타입(Type)
지시: int 타입의 변수 age를 선언하고, 자신의 임의의 나이를 리터럴로 대입한 뒤, 변수 age를 출력해 보세요.

문제 3: 다양한 타입의 변수 활용
지시: 아래 4개의 변수를 선언하고 리터럴로 임의의 값을 넣어 초기화하세요. (출력은 하지 않아도 됩니다)
이름: String 타입의 name
키: double 타입의 height
좌우명: String 타입의 motto

문제 4: 출력 함수와 문자열 연결
지시: 문제 3에서 만든 변수들을 System.out.println() 함수와 + 
나이: int 타입의 age연산자를 사용하여 아래와 같이 한 문장으로 출력하세요.
예시: 제 이름은 홍길동, 나이는 25세, 키는 175.5cm 입니다.

문제 5: printf와 서식 지정자(Format Specifier)
지시: 문제 4의 출력문을 System.out.printf() 함수와 서식 지정자를 사용하도록 수정하세요.
요구 조건: 키(height)는 서식 지정자를 이용해 소수점 첫째 자리까지만 표시하세요.
예시: 제 이름은 홍길동, 나이는 25세, 키는 175.5cm 입니다.

문제6: 아래와 같이 이스케이프 문자를 이용하여 콘솔에 출력하는 코드를 작성하시오.
   |\_/|
   |q p|   /}
   ( 0 )"""\
   |"^"`    |
   ||_/=\\__|
   
문제7 : 아래 조건에 3가지의 변수가 주어졌을때. 그림과 같이 printf 이용한 출력 하는 코드를 작성하시오.
int num = 1;    // 정수 1 를 저장하고 있는 int 타입 'num' 변수 선언
String writer = "유재석"; // 문자열 "유재석" 를 저장하고 있는 String타입 'writer' 변수 선언
String content = "안녕하세요!"; // 문자열 "안녕하세요!"를 저장하고 있는 String타입 'content' 변수 선언
예시 : 
========== 방문록 ===========
번호    작성자   방문록       
1      유재석   안녕하세요!    
============================


*/

package day02;

public class 실습1 {
    public static void main(String[] args) {
        System.out.println(25 + "\n홍길동");

        int age = 34;
        System.out.println("저는 " + age + "세 입니다.");

        String name = "최동진";
        double height = 172.2;
        String motto = "오늘의 나를 이길 것";
        System.out.println("제 이름은 " + name + ". 나이는 " + age + "세. 키는 " + height + "cm. 좌우명은 " + motto + "입니다.");

        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");

        int num = 1;
        String writer = "유재석";
        String content = "안녕하세요!";
        System.out.printf("========== 방문록 ===========\n번호   작성자   방문록\n%-6d%-6s%-6s" , num, writer , content);
        

    }
}

/*
   |\_/|
   |q p|   /}
   ( 0 )"""\
   |"^"`    |
   ||_/=\\__|
*/