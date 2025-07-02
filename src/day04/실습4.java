package day04;  // package(folder) name

import java.util.Scanner;

public class 실습4 {  // class start
    public static void main(String[] args) {    // main start

        /*
        JAVA] 실습4 : 제어문
                [ 문제 ] 아래 제어문 관련 문제
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
         */

        /*
        [문제 1] Scanner를 이용해 두 개의 점수(int)를 입력받아 총점을 계산하세요. 총점이 90점 이상이면 '성공'을, 그렇지 않으면 '실패'를 출력하는 프로그램을 작성하시오.
        입력 예시:
        첫 번째 점수: 40
        두 번째 점수: 55
        출력 예시:
        성공
*/

        // 스캐너 코드 : 상단에 임포트 뜨도록 자동완성 시키기
        Scanner scan = new Scanner(System.in);

        /*

        System.out.println("합산할 정수 두 개를 입력하세요.");
        System.out.print("첫 번째 점수: ");
        int i1 = scan.nextInt();
        System.out.print("두 번째 점수: ");
        int i2 = scan.nextInt();
        if(i1 + i2 >= 90){
            System.out.println("성공!!!");
        } else {
            System.out.println("실패...");
        }
        */

        /*
        [문제 2] Scanner를 이용해 서로 다른 두 개의 정수를 입력받아, 더 큰 수를 출력하는 프로그램을 작성하시오.
        입력 예시:
        첫 번째 정수: 10
        두 번째 정수: 25
        출력 예시:
        더 큰 수: 25
*/

        /*
        System.out.println("서로 다른 두 개의 정수를 입력하세요.");
        System.out.print("첫 번째 정수:");
        int i3 = scan.nextInt();
        System.out.print("두 번째 정수:");
        int i4 = scan.nextInt();
        if(i3 > i4){
            System.out.println("더 큰 수:" + i3);
        } else if (i4 > i3) {
            System.out.println("더 큰 수:" + i4);
        } else {
            System.out.println("두 수가 같습니다.");
        }

         */

        /*
        [문제 3] Scanner를 이용해 아이디와 비밀번호를 String으로 입력받습니다. 아이디가 'admin'이고 비밀번호가 '1234'와 모두 일치하면 '로그인 성공'을, 하나라도 다르다면 '로그인 실패'를 출력하는 프로그램을 작성하시오.
        요구 조건: 문자열 비교는 .equals() 메소드를 사용하세요.
        입력 예시:
        아이디: admin
        비밀번호: 1234
        출력 예시:
        로그인 성공
*/

        /*
        System.out.print("아이디를 입력하세요: ");
        String id = scan.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pw = scan.nextLine();
        if (id.equals("admin") && pw.equals("1234")) {
            System.out.println("관리자 로그인 성공");
        } else if (id.trim().isEmpty() || pw.trim().isEmpty()) {
            System.out.println("아이디와 비밀번호를 입력하세요.");
        } else {
            System.out.println("로그인 실패");
        }
        */


        /*
        [문제 4] Scanner를 이용해 비밀번호를 문자열로 입력받아, 길이에 따라 보안 등급을 출력하는 프로그램을 작성하시오.
        요구 조건: 비밀번호의 길이는 .length() 메소드로 구할 수 있습니다.
        8자 미만: '보안 등급: 약함 (8자 이상으로 설정해주세요.)'
        8자 이상 12자 미만: '보안 등급: 보통'
        12자 이상: '보안 등급: 강함'
        입력 예시:
        비밀번호를 입력하세요: mypassword123
        출력 예시:
        보안 등급: 강함
         */

        /*
        System.out.print("비밀번호를 입력하세요: ");
        String pwd = scan.nextLine();
        if (pwd.length() == 0) {
            System.out.println("비밀번호가 공백입니다. 다시 입력하세요.");
        } else if (pwd.length() < 8) {
            System.out.println("'보안 등급: 약함 (8자 이상으로 설정해주세요.)'");
        } else if (pwd.length() < 12) {
            System.out.println("'보안 등급: 보통'");
        } else {
            System.out.println("'보안 등급: 강함'");
        }
*/

        /*
        [문제 5] Scanner를 이용해 주민등록번호 13자리(-포함)를 문자열로 입력받습니다. 성별을 나타내는 8번째 숫자가 '1' 또는 '3'이면 '남자'를, '2' 또는 '4'이면 '여자'를 출력하는 프로그램을 작성하시오.
        요구 조건: 8번째 문자는 .charAt(7)으로 가져올 수 있습니다.
        입력 예시:
        주민등록번호(-포함) 13자리를 입력하세요: 950101-2******
        출력 예시: 여자
        */

        /*
        System.out.print("주민등록번호 13자리를 하이픈(-) 포함하여 입력하세요. (예시 : 000101-3000001)");
        String citiNum = scan.next();
        if(citiNum.charAt(7) == '1' || citiNum.charAt(7) == '3') {
            System.out.println("남성입니다.");
        } else if (citiNum.charAt(7) == '2' || citiNum.charAt(7) == '4') {
            System.out.println("여성입니다.");
        } else {
            System.out.println("외계인입니다.");
        }
*/

        /*
        [문제 6] Scanner를 이용해 게임 점수를 정수로 입력받아, 아래 기준에 따라 지급될 상품을 출력하는 프로그램을 작성하시오.
        900점 이상: 'A급 경품'
        700점 이상 900점 미만: 'B급 경품'
        500점 이상 700점 미만: 'C급 경품'
        500점 미만: '참가상'
        입력 예시:
        점수를 입력하세요: 750
        출력 예시:
        B급 경품
         */

        /*
        // 1. Scanner scan = new Scanner( System.in ) 코드로 객체 생성

        // 2. 참조 변수 scan으로 게임 점수 'int' 입력받기
        System.out.print("점수를 입력하세요: ");
        int score = scan.nextInt();

        // 3. if문으로 int 변수에 비교연산자 사용하여 상품 출력하기
        if(score >= 900) {
            System.out.println("깁슨 레스폴 NG 리마스터드");
        } else if (score >= 700) {
            System.out.println("비아톨레도 파스타바 2인 식사권");
        } else if (score >= 500) {
            System.out.println("가정용 에어서큘레이터");
        } else {
            System.out.println("대신 귀여운 손 선풍기를 드립니다.");
        }
        */

        /*
        [문제 7] Scanner를 이용해 사용자 역할(role)을 문자열로 입력받습니다. 역할에 따라 다른 접근 권한 메시지를 출력하는 프로그램을 작성하시오.
        admin: '모든 기능에 접근할 수 있습니다.'
        editor: '콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.'
        viewer: '콘텐츠 조회만 가능합니다.'
        그 외 역할: '정의되지 않은 역할입니다.'
        입력 예시:
        역할을 입력하세요: editor
        출력 예시:
        콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.
         */

        // Scanner scan = new Scanner( System.in ) 으로 클래스 객체 형성 및 임포트 생성

        // scan 변수로 String 클래스로 사용자가 입력할 role 저장

        /*
        System.out.print("당신의 역할(role)을 입력하세요: ");
        String role = scan.nextLine();
        // if문을 통해, 입력한 role
        if (role.equals("admin") || role.equals("관리자") || role.equals("producer") || role.equals("제작자")) {
            System.out.println("모든 기능에 접근할 수 있습니다.");
        } else if (role.equals("editor") || role.equals("편집자") || role.equals("연출자") || role.equals("PD") || role.equals("director") || role.equals("manager") || role.equals("감독") || role.equals("담당자")) {
            System.out.println("콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.");
        } else if (role.equals("viewer") || role.equals("시청자") || role.equals("회원") || role.equals("member")) {
            System.out.println("콘텐츠 조회만 가능합니다.");
        } else {
            System.out.println("정의되지 않은 역할입니다.");
        }

*/


        /*
        [문제 8] Scanner를 이용해 사용자의 나이를 정수로 입력받아, 아래 기준에 따라 입장료를 출력하는 프로그램을 작성하시오.
        8세 미만: '무료'
        8세 이상 19세 이하: '5,000원'
        20세 이상 65세 미만: '10,000원'
        65세 이상: '3,000원'
        입력 예시:
        나이를 입력하세요: 22
        출력 예시:
        10,000원
         */

        // scanner 클래스 객체 생성. 임포트

        /*

        // int age값을 사용자가 입력하도록 하기
        System.out.print("부천만화박물관에 오신 것을 환영합니다! 나이를 입력하세요: ");
        int age = scan.nextInt();

        // 추가. 국가유공자 또는 지역주민 여부 확인
        System.out.print("친인척 중에 국가유공자가 있습니까? (true / false)");
        boolean patriot = scan.nextBoolean();
        System.out.print("부천시 주민이십니까? (true / false)");
        boolean citizen = scan.nextBoolean();

        // if문으로 나이에 따라 다른 입장료 출력

        if (patriot) {
            System.out.println("국가유공자 친인척은 무료 입장 가능합니다.");
            return;
        }


        if (citizen && age >= 65) {
            System.out.println("부천시민 절반 할인가 적용하여 어르신 1,500원입니다.");
            return;
        } else if (citizen && age >= 20) {
            System.out.println("부천시민 절반 할인가 적용하여 성인 5,000원입니다.");
            return;
        } else if (citizen && age >= 8) {
            System.out.println("부천시민 절반 할인가 적용하여 어린이와 학생은 2,500원입니다.");
            return;
        } else {
            System.out.println("8세 미만은 무료입니다.");
        }

        if (age >= 65) {
            System.out.println("어르신 3,000원입니다.");
        } else if (age >= 20) {
            System.out.println("성인 10,000원입니다.");
        } else if (age >= 8) {
            System.out.println("어린이와 학생은 5,000원입니다.");
        }

         */

        /*
        [문제 9] Scanner를 이용해 하나의 점수를 입력받아 다음 조건에 따라 등급을 출력하는 프로그램을 작성하시오.
        90점 이상: 'A등급'
        80점 이상 90점 미만: 'B등급'
        70점 이상 80점 미만: 'C등급'
        70점 미만: '재시험'
        입력 예시:
        점수를 입력하세요: 85
        출력 예시:
        B등급
        */

        /*
        // scan으로 int값 받기
        System.out.print("점수를 입력하세요: ");
        int score1 = scan.nextInt();
        String rank = "";

        // 받은 int값 score를 if문 통해 rank로 분류하기
        if(score1 >= 90) {
            rank = "A등급";
        } else if (score1 >= 80) {
            rank = "B등급";
        } else if (score1 >= 70) {
            rank = "C등급";
        } else {
            rank = "과락";
        }

        // rank 출력하기
        System.out.println("당신의 등급은 " + rank + "입니다." );
*/


        /*
        [문제 10] Scanner를 이용해 총 구매 금액을 입력받습니다. 구매 금액에 따라 할인율을 적용하여 최종 결제 금액을 출력하는 프로그램을 작성하시오.
        50,000원 이상: 10% 할인
        30,000원 이상 50,000원 미만: 5% 할인
        10,000원 이상 30,000원 미만: 1% 할인
        10,000원 미만: 할인 없음
        입력 예시:
        총 구매 금액: 60000
        출력 예시:
        최종 결제 금액: 54000원
         */

        /*
        // 1. 스캐너 클래스 객체 생성 및 임포트 (생략)

        // 2. 정수값(int) 구매금액 scan으로 입력받기
        System.out.print("총 구매 금액: ");
        int price = scan.nextInt();

        // 3. if문으로 구매금액 대비 할인율 계산
        if (price >= 50000) {
            price = price - price / 10;
        } else if (price >= 30000) {
            price = price - price / 20;
        } else if (price >= 10000) {
            price = price - price / 100;
        } else {
            price = price;
        }

        // 4. 할인된 최종 결제 금액 출력
        System.out.println("최종 결제 금액: " + price);
*/


        /*
        [문제 11] 1부터 12 사이의 월(Month)을 숫자로 입력받아, 해당하는 계절을 출력하는 프로그램을 작성하시오. 만약 1~12 이외의 숫자를 입력하면 '잘못된 월입니다.'를 출력하세요.
        봄: 3, 4, 5월
        여름: 6, 7, 8월
        가을: 9, 10, 11월
        겨울: 12, 1, 2월
        입력 예시:
        월(1~12)을 입력하세요: 9
        출력 예시:
        가을
        */

        /*
        // Scanner scan = new Scanner( System.in )과 클래스 상단에 import java.util.Scanner; 임포트 생성

        // Month를 숫자(byte)로 입력받기
        System.out.print("월(1~12) 중 하나를 입력:");
        byte month = scan.nextByte();

        // String으로 출력 변수 만들기
        String season = "";

        // if문으로 봄, 여름, 가을, 겨울, 잘못된 월 설정하기
        if (month >= 3 && month <= 5) {
            season = "봄";
        } else if (month >= 6 && month <= 8) {
            season = "여름";
        } else if (month >= 9 && month <= 11) {
            season = "가을";
        } else if (month == 1 || month == 2 || month == 12) {
            season = "겨울";
        } else {
            season = "잘못된 월입니다.";
        }

        // 계절 출력하기
        System.out.println(season);
*/

        /*
        [문제 12] Scanner를 이용해 서로 다른 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하시오.
        입력 예시:
        첫 번째 정수: 45
        두 번째 정수: 12
        세 번째 정수: 78
        출력 예시:
        가장 큰 수: 78
*/

        /*
        // Scanner scan(변수) = new Scanner( System.in ) 클래스 객체 생성하고,  import java.util.Scanner; 임포트

        // scan으로 세 개의 정수(int) 입력받기
        System.out.print("세 개의 정수를 입력하세요.");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        // highNum int 변수 만들기
        int highNum = 0;

        // if문으로 가장 큰 수를 highNum으로 반환. 큰 수의 숫자가 같을 경우 return
        if (num1 > num2 && num1 > num3) {
            highNum = num1;
        } else if (num2 > num1 && num2 > num3) {
            highNum = num2;
        } else if (num3 > num1 && num3 > num2) {
            highNum = num3;
        } else {
            System.out.println("큰 수의 숫자가 같습니다.");
            return;
        }

        // highNum 출력
        System.out.println("가장 큰 숫자는 " + highNum + "입니다.");

         */

        /*
        [문제 13] Scanner를 이용해 연도(year)를 입력받아 해당 연도가 윤년인지 평년인지 판별하는 프로그램을 작성하시오.
        윤년 조건:
        연도가 4의 배수이면서, 100의 배수는 아닐 때
        또는 연도가 400의 배수일 때
        입력 예시:
        연도를 입력하세요: 2024
        출력 예시:
        2024년은 윤년입니다.
*/

        /*
        // 스캐너 스캔(변수) = 뉴 스캐너(시스템.인) 으로 import java.util.Scanner 임포트.

        // int값인 year(연도) 입력받기.
        System.out.println("윤년 확인할 연도를 입력하세요.");
        int year = scan.nextInt();

        // String 변수 leapYear(윤년) 공백 만들어두기
        String leapyear = "";

        // if문으로 윤년, 평년 판단 (4의 배수면서 100의 배수는 아닐때 || 400의 배수일때)하고 leapYear 값 대입하기
        if (year % 4 == 0 && year % 100 != 0) {
            leapyear = "윤년입니다.";
        } else if (year % 400 == 0) {
            leapyear = "윤년입니다.";
        } else {
            leapyear = "평년입니다.";
        }

        // String leapYear 출력하기
        System.out.println(year + "년은 " + leapyear);
        */


        /*
        [문제 14] Scanner를 이용해 서로 다른 세 개의 정수를 입력받아, 오름차순(작은 수부터 큰 수 순서)으로 정렬하여 출력하는 프로그램을 작성하시오.
        입력 예시:
        첫 번째 정수: 17
        두 번째 정수: 4
        세 번째 정수: 8
        출력 예시:
        4, 8, 17
         */

        /*
        // 스캐너 스캔 객체 클래스 생성 , 임포트 자바.유틸.스캐너;

        // 정수(int) 값 3개 입력받기
        System.out.print("서로 다른 세 개의 정수를 입력:");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        // 오름차순 배열 변수(ascend) 만들기 (안 됨)
        // 오름차순으로 입력할 스트링 변수 (안 됨)
        // 스왑=swap 사용해서 변수간 값 교체함 : JS에서는 let temp = a; a = b ; b = temp ; 로 바꿔줬음
        int ascend = 0;

        // 서로 숫자 크기 대비해보고, 작은 숫자부터 스왑 활용해 늘어놓기

        if (num1 > num2) {
            ascend = num1;
            num1 = num2;
            num2 = ascend;
        }
        if (num1 > num3) {
            ascend = num1;
            num1 = num3;
            num3 = ascend;
        }
        if (num2 > num3) {
            ascend = num2;
            num2 = num3;
            num3 = ascend;
        }

        // 스왑된 num1 , num2 , num3 차례대로 출력
        System.out.print(num1 + ", " + num2 + ", " + num3);

         */

        /*
        [문제 15] 가위바위보 게임
        지시: 두 명의 플레이어가 참여하는 가위바위보 게임을 만드시오.
        입력: 플레이어 1과 플레이어 2는 각각 0(가위), 1(바위), 2(보) 중 하나의 숫자를 Scanner로 입력합니다.
        출력:
        플레이어 1이 이기면 '플레이어1 승리'를 출력합니다.
        플레이어 2가 이기면 '플레이어2 승리'를 출력합니다.
        두 플레이어가 같은 것을 내면 '무승부'를 출력합니다.
        입력 예시:
        플레이어1 (0:가위, 1:바위, 2:보): 1
        플레이어2 (0:가위, 1:바위, 2:보): 0
        출력 예시:
        플레이어1 승리
        */


        // 플레이어 1, 2 한 번씩 가위바위보(rsp1 ,rsp2)를 scan으로 낸다.
        System.out.println("가위바위보! (0은 가위, 1은 바위, 2는 보)");
        System.out.print("player1 턴");
        int rsp1 = scan.nextInt();
        System.out.print("player2 턴");
        int rsp2 = scan.nextInt();

        // 승자 출력할 winner 스트링 만들기
        String winner = "";

        // if문으로 비교연산자 활용하여 승부 가리기
        if ((rsp1 == 1 && rsp2 == 0) || (rsp1 == 2 && rsp2 == 1) || (rsp1 == 0 && rsp2 == 2)) {
            winner = "player1 승리!";
        } else if ((rsp2 == 1 && rsp1 == 0) || (rsp2 == 2 && rsp1 == 1) || (rsp2 == 0 && rsp1 == 2)) {
            winner = "player2 승리!";
        } else if ((rsp1 == 1 && rsp2 == 1) || (rsp1 == 2 && rsp2 == 2) || (rsp1 == 0 && rsp2 == 0)) {
            winner = "무승부";
        } else {
            winner = "번개 총 악마 같은 룰은 없습니다.";
        }

        // 승리한 플레이어 출력
        System.out.println(winner);




    } // main end
} // class end
