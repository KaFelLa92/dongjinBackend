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
        System.out.print("평균값을 구할 정수 5개를 입력하세요 : ");
        int i1 = scan.nextInt();
        int i2 = scan.nextInt();
        int i3 = scan.nextInt();
        int i4 = scan.nextInt();
        int i5 = scan.nextInt();

        int sum1 = (i1 + i2 + i3 + i4 + i5) / 5;
        double sum2 = (double) sum1;
        System.out.printf("평균%.1f : ", sum2);

        // 중급 5
        System.out.println("정수 두 개를 처리할 연산자 하나를 입력하시오 :");
        int a = scan.nextInt();
        int b = scan.nextInt();
        char cal =

    }   // main e
}   // class e
