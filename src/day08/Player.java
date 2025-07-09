package day08;

public class Player {
    // 멤버변수
    String name;
    int power;
    int speed;

    // 초기화 생성자
    Player(String name, int power, int speed) {
        this.name = name;
        this.power = power;
        this.speed = speed;
    }

    // 그 선수는
    void bringMePlayer() {
        System.out.println("선수이름 : " + name + " 파워 : " + power + " 스피드 : " + speed);
    }
}
