import java.util.Scanner; // 스캐너 쓰려면 임포트 해야함

public class GPT {  // class s
    public static void main(String[] args) { // main s
        // Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        /*
        // 초급 1
        System.out.print("첫 번째 정수를 입력하세요 : ");
        int a = scan.nextInt();
        System.out.print("두 번째 정수를 입력하세요 : ");
        int b = scan.nextInt();
        System.out.println("두 정수의 합은 " + (a + b) + " 입니다.");
        */

        /*
        // 초급 2
        System.out.print("이름을 입력하세요 : ");
        String name = scan.nextLine();
        System.out.println(name + "님 안녕하세요!");
        */

        /*
        // 중급 3
        System.out.print("나이를 입력하세요 : ");
        int age = scan.nextInt();
        if(age >= 19){
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }

        */

        // 중급 4
        /*
        System.out.print("평균값을 구할 정수 5개를 입력하세요 : ");
        int i1 = scan.nextInt();
        int i2 = scan.nextInt();
        int i3 = scan.nextInt();
        int i4 = scan.nextInt();
        int i5 = scan.nextInt();

        int sum1 = (i1 + i2 + i3 + i4 + i5) / 5;
        double sum2 = (double) sum1;
        System.out.printf("평균%.1f : ", sum2);
        */


        // 응용 5
        /*
        System.out.println("정수 두 개와 처리할 연산자 하나를 입력하시오 :");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c ;
        char cal = scan.next().charAt(0);
        if (cal == '+') {
            c = a + b;
        } else if (cal == '-') {
            c = a - b;
        } else if (cal == '*') {
            c = a * b;
        } else if (cal == '/') {
            c = a / b;
        } else {
            c = a % b;
        }
        System.out.println(c);

         */

        // if문 초급 1
        int i1 = 6;
        if (i1 % 2 == 1) {
            System.out.println("홀수입니다.");
        } else {
            System.out.println("짝수입니다.");
        }

        // 초급 2
        int i2 = 1;
        if (i2 > 0) {
            System.out.println("양수입니다.");
        } else if (i2 < 0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0입니다.");
        }

        // 중급 3
        int i3 = 4;
        int i4 = 9;
        if (i3 > i4){
            System.out.println("더");
        }


    }   // main e
}   // class e
