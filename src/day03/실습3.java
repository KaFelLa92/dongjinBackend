package day03;      // 패키지명

import java.util.Scanner;

public class 실습3 {  // class s
    public static void main(String[] args) {    // main s
        Scanner scan = new Scanner(System.in);  // 상수값처럼 빼놓기
        /*
        [실습3] *제출용
                [ 문제 ] 아래 연산자 관련 문제 *IF문 대신 삼항연산자를 활용합니다.*
                [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
        */

        /*
                [문제 1] Scanner를 이용해 국어, 영어, 수학 점수를 각각 정수(int)로 입력받아, 총점과 평균을 계산하여 출력하시오.
                입력 예시:
        국어 점수: 85
        영어 점수: 92
        수학 점수: 78
        출력 예시:
        총점: 255
        평균: 85.0
        */

        /*

        System.out.print("국어 점수: ");
        int kor = scan.nextInt();
        System.out.print("영어 점수: ");
        int eng = scan.nextInt();
        System.out.print("수학 점수: ");
        int math = scan.nextInt();
        int sum = kor + eng + math;
        double ave = (double) sum/3;
        System.out.println("총점: " + sum);
        System.out.printf("평균: %.1f" , ave);
        */

        /*
                [문제 2] Scanner를 이용해 원의 반지름(double)을 입력받아, 원의 넓이를 계산하여 출력하시오.
                요구 조건: 원주율은 3.14로 계산합니다. (공식: 반지름 * 반지름 * 3.14)
        입력 예시:
        반지름을 입력하세요: 10.5
        출력 예시:
        원의 넓이: 346.185
*/

        /*
        System.out.print("반지름을 입력하세요 : ");
        double radius = scan.nextDouble();
        double circle = radius * radius * 3.14;
        System.out.println("원의 넓이 : " + circle);


         */
        /*
                [문제 3] Scanner를 이용해 두 개의 실수(double)를 입력받아, 첫 번째 실수가 두 번째 실수의 몇 퍼센트인지 계산하여 출력하시오.
                공식: (첫 번째 실수 / 두 번째 실수) * 100
        입력 예시:
        첫 번째 실수: 50
        두 번째 실수: 200
        출력 예시:
        비율: 25.0%
         */

        /*
        System.out.print("두 개의 실수를 입력 : ");
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();
        double per = (num1 / num2) * 100;
        System.out.printf("비율: %.1f" , per);
        System.out.println("%");
        */


        /*
                [문제 4] Scanner를 이용해 정수 하나를 입력받아, 그 수가 홀수이면 true, 짝수이면 false를 출력하시오.
        입력 예시:
        정수를 입력하세요: 17
        출력 예시:
        결과: true
         */

        /*
        System.out.print("정수를 입력하세요 : ");
        int int1 = scan.nextInt();
        System.out.println(int1 % 2 == 1 ? "true" : "false");
        */


        /*
                [문제 5] Scanner를 이용해 정수 하나를 입력받아, 그 수가 7의 배수이면 true, 아니면 false를 출력하시오.
        입력 예시:
        정수를 입력하세요: 28
        출력 예시:
        결과: true
*/

        /*
        System.out.println("정수를 입력하세요: ");
        int int7 = scan.nextInt();
        System.out.print("결과:");
        System.out.println(int7 % 7 == 0 ? "true" : "false");
        */

        /*
                [문제 6] Scanner를 이용해 아이디와 비밀번호를 String으로 입력받아, 아이디가 "admin"이고 비밀번호가 "1234"와 모두 일치하면 true, 아니면 false를 출력하시오.
        요구 조건:문자열 비교는 .equals() 메소드를 사용해야 합니다.
                입력 예시:
        아이디: admin
        비밀번호: 1234
        출력 예시:
        결과: true
         */

        /*
        System.out.print("아이디: ");
        String id = scan.next();
        System.out.print("비밀번호: ");
        String pw = scan.next();
        System.out.println(id.equals("admin") && pw.equals("1234") ? "관리자 모드로 입장합니다." : "다시빽 다시빽" );
*/


        /*
                [문제 7] Scanner를 이용해 정수 하나를 입력받아, 그 수가 홀수이면서 7의 배수이면 true, 아니면 false를 출력하시오.
        입력 예시:
        정수를 입력하세요: 21
        출력 예시:
        결과: true
*/

        // Scanner scan = new Scanner(System.in);
        // 문제 7
        /*
        System.out.println("정수를 입력하세요 : ");
        int i1 = scan.nextInt();
        System.out.print("결과:");
        System.out.println(i1 % 2 == 1 && i1 % 7 == 0 ? "true" : "false");
        */

        /*
                [문제 8] Scanner를 이용해 1차 점수와 2차 점수를 각각 int로 입력받아, 두 점수의 총점이 150점 이상이면 "합격", 아니면 "불합격"을 출력하시오.
        입력 예시:
        1차 점수: 80
        2차 점수: 75
        출력 예시:
        결과: 합격
*/

        /*
        System.out.print("1차 점수와 2차 점수를 입력하세요");
        int score1 = scan.nextInt();
        int score2 = scan.nextInt();
        System.out.println("결과: ");
        System.out.println(score1 + score2 >= 150 ? "우승" : "개같이멸망" );
*/

        /*
                [문제 9]  Scanner를 이용해 이름을 String으로 입력받아, 만약 이름이 "유재석"과 일치하면 이름 뒤에 "(방장)"을 붙여서 출력하고, 아니면 입력받은 이름만 출력하시오.
                입력 예시 1:
        이름을 입력하세요: 유재석
        출력 예시 1:
        유재석(방장)
        입력 예시 2:
        이름을 입력하세요: 강호동
        출력 예시 2:
        강호동
         */

        /*
        System.out.print("이름을 입력하세요: ");
        String name = scan.next();
        System.out.println(name.equals("유재석") ? name += "(방장)" : name);
*/
        /*
                [문제 10] Scanner를 이용해 삼각형의 밑변과 높이를 각각 double로 입력받아, 삼각형의 넓이를 계산하여 출력하시오.
                요구 조건: 공식: 밑변 * 높이 / 2.0
        입력 예시:
        밑변: 10.0
        높이: 5.5
        출력 예시:
        삼각형의 넓이: 27.5
         */

        /*
        System.out.println("삼각형의 밑변과 높이를 입력하세요.");
        double width = scan.nextDouble();
        double height = scan.nextDouble();
        double triangle = width * height / 2.0;
        System.out.printf("삼각형의 넓이: %.1f" , triangle);
        */


        /*
                [문제 11] Scanner를 이용해 섭씨 온도를 double로 입력받아, 화씨 온도로 변환하여 출력하시오.
                요구 조건:
        공식: (섭씨 * 9.0 / 5.0) + 32
        입력 예시:
        섭씨 온도: 30.0
        출력 예시:
        화씨 온도: 86.0
         */

        /*
        System.out.println("섭씨 온도를 입력하세요.");
        double c = scan.nextDouble();
        System.out.printf("섭씨 온도: %.1f " , c);
        System.out.printf("화씨 온도: %.1f" , (c * 9 / 5) + 32);

*/

        /*
                [문제 12] Scanner를 이용해 태어난 년도(int)를 입력받아, 2025년 기준 현재 나이를 계산하여 출력하시오.
        요구 조건:
        공식: 2025 - 태어난 년도
        입력 예시:
        태어난 년도: 1998
        출력 예시:
        2025년 기준 나이: 27세


*/
        /*
        System.out.println("탄생연도를 입력하세요 : ");
        int since = scan.nextInt();
        System.out.println("태어난 연도: " + since);
        System.out.println("2025년 기준 나이: " + (2025 - since));
*/
        /*
                [문제 13] Scanner를 이용해 키(cm)와 몸무게(kg)를 각각 double로 입력받아, BMI 지수를 계산하여 출력하시오.
                요구 조건:
        BMI 공식: 몸무게(kg) / (키(m) * 키(m))
        키는 cm로 입력받지만, 공식에는 m 단위가 사용되므로 키(cm) / 100.0으로 단위를 변환해야 합니다.
        입력 예시:
        키(cm): 175.5
        몸무게(kg): 68.8
        출력 예시:
        BMI 지수: 22.34...
         */

        /*
        System.out.print("키(cm)를 입력하세요: ");
        double height = scan.nextDouble();
        System.out.print("몸무게(kg)를 입력하세요: ");
        double weight = scan.nextDouble();
        double BMI = weight / ((height / 100) * (height / 100)) ;
        System.out.println("키(cm): " + height);
        System.out.println("몸무게(kg): " + weight);
        System.out.println("BMI 지수: " + BMI);
        */
        /*
                [문제 14] Scanner를 이용해 아이디와 이메일을 String으로 입력받습니다. 아이디가 "admin"이거나 또는 이메일이 "admin@test.com"이면 "관리자", 그렇지 않으면 "일반 사용자"를 출력하시오.
        입력 예시:
        아이디: user1
        이메일: admin@test.com
        출력 예시:
        결과: 관리자
         */

        /*
        System.out.print("아이디를 입력하세요 : ");
        String id = scan.next();
        System.out.print("이메일을 입력하세요 : ");
        String email = scan.next();
        System.out.println(id.equals("admin") || email.equals("admin@test.com") ? "관리자" : "일반 사용자");
        */

        /*
                [문제 15] Scanner를 이용해 100점 만점의 점수(int)를 입력받아, 점수에 따라 아래와 같이 등급을 부여하고 출력하시오.
        90점 이상: 'A'
        80점 이상 90점 미만: 'B'
        70점 미만: 'C'
        입력 예시:
        점수를 입력하세요: 88
        출력 예시:
        등급:B
         */

        System.out.print("점수를 입력하세요.");
        int score = scan.nextInt();
        System.out.print("등급:");
        System.out.println(score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : "F");


        /*
                [문제 16] Scanner를 이용해 나이(int)를 입력받아, 20대(20세 이상 29세 이하)에 해당하는 경우 "이벤트 대상입니다."를, 그렇지 않으면 "이벤트 대상이 아닙니다."를 출력하시오.
        입력 예시:
        나이를 입력하세요: 25
        출력 예시:
        이벤트 대상입니다.
        */

        System.out.print("나이를 입력하세요 : ");
        int age = scan.nextInt();
        System.out.println(age >= 20 && age <= 29 ? "이벤트 대상입니다." : "이벤트 대상이 아닙니다.");

    }   // main e
}   // class e
