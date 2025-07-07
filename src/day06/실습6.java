package day06;  // package name

import java.util.Arrays;
import java.util.Scanner;

public class 실습6 {  // class start
    public static void main(String[] args) {    // main start

        /*
        JAVA] 실습6 : 배열과반복문
                [ 문제 ] 아래 배열과반복문 관련 문제
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/

        /*
[문제 1] 정수 5개(10, 20, 30, 40, 50)를 저장할 수 있는 int 타입의 배열 numbers를 선언과 동시에 초기화하세요.
                배열의 2번 인덱스에 저장된 값을 콘솔에 출력하세요.
         */

        /*
        // (1) 정수 다섯 개 저장할 수 있는 int 타입 배열 선언과 동시에 초기화
        int[] numbers = {10, 20, 30, 40, 50};
        // * 선언만 한 것은 아래 예시
        //        int[] numbers = new int[5];
        // (2) 2번 인덱스 콘솔에 출력
        System.out.println(numbers[2]);
*/
        /*
[문제 2] String 타입의 데이터를 3개 저장할 수 있는 배열 season을 new 키워드를 사용하여 생성하세요.
        각 인덱스에 "봄", "여름", "가을" 값을 순서대로 할당하세요.
                Arrays.toString()을 사용하여 배열의 모든 요소를 한 번에 출력하세요.
*/
/*
        String[] season = new String[3];
        season[0] = "봄";
        season[1] = "여름";
        season[2] = "가을";
        System.out.println(season); // 배열 주소값 출력
        System.out.println(Arrays.toString(season));    // import java.util.Arrays; 임포트하세요
*/
        /*
[문제 3] 다음과 같은 과일 배열이 있습니다. for 반복문을 사용하여 배열의 모든 요소를 하나씩 콘솔에 출력하시오.
        선언 코드: String[] fruits = {"사과", "바나나", "포도", "딸기"};
         */
/*
        String[] fruits = {"사과", "바나나", "포도", "딸기"};
        // 방법1 일반 for문
        for (int i = 0; i <= fruits.length - 1; i++) {   // 과일들의 길이를 for문 길이로 잡기
            String fruit = fruits[i];  // 과일 문자열 변수 생성 = 과일배열[인덱스]
            System.out.println(fruit);  // 인덱스 하나씩 출력
        }
        // 방법2 향상된 for문 , for(배열타입 반복변수명 : 배열변수명) { }
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
*/

        /*
[문제 4] 다음 학생들의 점수가 담긴 배열이 있습니다. for 반복문을 사용하여 모든 점수의 합계와 평균을 계산하여 콘솔에 출력하시오.
                요구 조건: 평균은 소수점까지 정확하게 계산되어야 합니다.
                선언 코드: int[] scores = {85, 92, 78, 65, 95};
*/

        /*
        int[] scores = {85, 92, 78, 65, 95};
        int sum = 0; // 모든 점수 합계
        double avarage = 0; // 모든 점수 평균
        for (int score : scores) {
            sum += score;
        }
        System.out.println("합계: " + sum);
        avarage = sum / 5;
        System.out.println("평균: " + avarage);
*/

        /*
[문제 5] 점수 배열에서 100점 만점자가 처음 나타나면, "100점 만점자를 찾았습니다!"라고 출력하고 반복문을 즉시 종료하는 프로그램을 작성하시오.
                선언 코드: int[] scores = {77, 82, 100, 54, 96};
         */

        /*
        int[] scores = {77, 82, 100, 54, 96};
        for (int score : scores) {
            System.out.println(score);
            if (score == 100) {
                System.out.println("100점 만점자를 찾았습니다!");
                break;
            }
        }
*/


        /*
[문제 6] 다음 배열에서 'A'형 혈액형을 가진 사람이 몇 명인지 for 반복문을 통해 세고, 그 수를 콘솔에 출력하시오.
                선언 코드: String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
*/

        /*
        String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
        int countA = 0; // A형 저장하는 정수 변수
        for (String bloodType : bloodTypes) {
            if (bloodType.equals("A")) {
                countA += 1;    // 인덱스에서 A형 찾으면 하나씩 늘어남
            }
        }
        System.out.println("A형 혈액형은 " + countA + "명 입니다.");
*/

        /*
[문제 7] 주어진 숫자 배열에서 가장 큰 값을 찾아 콘솔에 출력하는 프로그램을 작성하시오.
                선언 코드: int[] numbers = {23, 5, 67, 12, 88, 34};
*/

        /*
        int[] numbers = {23, 5, 67, 12, 88, 34};
        int bigNum = 0; // 가장 큰 숫자 저장하는 변수
        for(int num : numbers){
            if (num > bigNum){ // 새로운 넘버스 인덱스가 기존 숫자보다 크면
                bigNum = num; // bigNum 값을 num으로 바꾼다.
            }
        }
        System.out.println(bigNum); // for문 종료 후 가장 큰 숫자 출력
*/

        /*
[문제 8] products(상품 목록)와 stock(재고 수량) 배열이 있습니다.
        Scanner를 이용해 사용자로부터 구매할 상품명과 수량을 입력받아, 재고가 충분하면 "구매 완료!"를 출력하고 재고를 차감하세요.
        재고가 부족하면 "재고가 부족합니다."를, 없는 상품이면 "없는 제품명입니다."를 출력합니다.
        선언 코드:
        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};
*/

        /*
        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};

        // 스캐너 임포트해라
        Scanner scan = new Scanner(System.in);

        // 스캐너로 구매할 상품명과 수량 입력받기
        System.out.print("상품명 입력 :");
        String name = scan.nextLine();
        System.out.println("구매할 수량 입력 :");
        int num = scan.nextInt();
        boolean found = false;

        // 겹for문으로 제품 찾고 재고 차감하기 (공통 인덱스 지정하면 되므로 근본 for문 활용)

        for (int i = 0; i <= products.length - 1; i++) { // for 1 start
            String product = products[i];
            if (name.equals(product)) {
                found = true;
                if (num <= stock[i]) {   // 입력한 숫자가 인덱스 번째 제품 재고보다 작거나 같을 경우
                    stock[i] -= num;    // 재고에서 구매량만큼 빼기
                    System.out.println("구매완료!");
                    System.out.println("제품 " + name + " 재고 " + num + "개 차감되어 " + stock[i] + "개 남았습니다.");
                } else  {
                    System.out.println("재고가 부족합니다.");
                }
                break;
            }
        } // for 1 end
        if (!found) {
            System.out.println("없는 제품명입니다.");
        }
        */


        /*
[문제 9] 주어진 영화 이름과 평점 배열을 이용하여, 각 영화의 평점을 별(★, ☆)로 시각화하여 출력하는 프로그램을 작성하시오.
                요구 조건: 각 영화의 평점(10점 만점)만큼 꽉 찬 별(★)을, 나머지 점수만큼 빈 별(☆)을 출력합니다.
        예시: 평점이 8점이면 ★★★★★★★★☆☆ (총 10개의 별)
        선언 코드:
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};
        출력 예시:
        히든페이스      ★★★★★★★★☆☆
        위키드         ★★★★☆☆☆☆☆☆
        글래디에이터2  ★★★★★★★☆☆☆
        청설          ★★★★★★☆☆☆☆
*/

        // 별 넣을 빈 문자열 생성 이건 안써요
//        String star = "";

        /*
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};

        for (int i = 0; i <= movieNames.length - 1; i++) {
            String movie = movieNames[i];   // i번째 영화명 추출
            System.out.print(movie);      // i번째 영화명 출력
            for (int s = 1; s <= 10; s++) { // 총 별의 갯수는 10개. 10번 반복 출력
                // 현재 평점이 현재 별보다 크거나 같으면 검은별, 아니면 빈별
                if (s <= movieRatings[i]) { // 
                    System.out.print("★");
                } else {
                    System.out.print("☆");
                }
            }   // for 2 end
            System.out.println();   // 줄바꿈 처리해주기
        }   // for 1 end
*/

        /*
[문제 10] 차량별 주차 시간 데이터가 주어졌을 때, 아래의 요금 규정에 따라 각 차량이 지불해야 할 최종 주차 요금을 계산하여 출력하시오.
        요금 규정:
        기본 요금: 최초 30분까지 1,000원
        추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
        일일 최대 요금: 20,000원 (아무리 오래 주차해도 20,000원을 초과할 수 없음)
        선언 코드:
        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};
        출력 예시:
        210어7125: 65분 주차, 최종 요금: 2500원
        142가7415: 30분 주차, 최종 요금: 1000원
        888호8888: 140분 주차, 최종 요금: 6500원
        931나8234: 420분 주차, 최종 요금: 20000원
*/

        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};


        for (int i = 0; i <= carNumbers.length - 1; i++) {  // 차 번호 for문
            System.out.print(carNumbers[i] + " : ");
            int minute = usageMinutes[i];       // 인덱스를 분 정수 변수로 치환
            int charge = 0;                 // 기본 30분 요금 내야할 비용 책정
            if (minute <= 30) {
                charge = 1000;
            } else if (minute > 30) {
                charge = (minute/10 * 500) - 500;   // 500원 증가 계산법에서 , 기본금액 1000원 더하고 30분 금액 1500원 뺌
            }

            if (charge >= 20000) {      // 차지 2만원 넘는거 따로 계산
                charge = 20000;
            }


            System.out.println(minute + "분 주차, 최종 요금: " + charge + "원");

        }

    }   // main end
} // class end
