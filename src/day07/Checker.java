package day07;

public class Checker {
    // 매개변수 O 반환값 O
    boolean isEven (int i) {
        if (i % 2 == 0) {
            System.out.println("짝수입니다.");
            return true;
        } else {
            System.out.println("홀수입니다.");
            return false;
        }
    }
}
