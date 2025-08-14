package backJun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt(); // 시계 시 변수
        int B = scan.nextInt(); // 시계 분 변수
        int C = scan.nextInt(); // 조리시간 분 변수
        int endTime = A;        // 구할 시간 변수
        int endMinute = 0;      // 구할 분 변수
        endMinute = B + C;
        if (endMinute > 60) {       //
            endTime += (endMinute)/60;
            endMinute += C % 60; // 분은 359면 59여야함
        }
        if (endTime > 24) {
            endTime -= 24;
        }
        System.out.println(endTime + " " + endMinute);
        // 예를 들어 14시 30분이고 C가 20이면, 14시 50분이 출력되어야함.
        // 디지털시계는 23시 59분에서 1분 지나면 0 0이 됨

    }
}