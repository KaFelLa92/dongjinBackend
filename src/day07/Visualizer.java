package day07;

public class Visualizer {

    // 매개변수 O 반환값 O

    // 메소드
    int getStars(int a) {
        for (int i = 1; i <= a; i++) {
            char star = '★';
            System.out.print(star);
        }
        System.out.println();
        return a;
    }
}// class e

// 강사님 풀이법

class Visualizer2 {
    String getstars2(int s) {
        String stars = "";
        for (int i = 1; i <= s; i++){
            stars += "★";
        }
        return stars;
    }
}