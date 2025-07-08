package day07;


public class Lamp {
    // 매개변수 X 리턴값 X
    boolean isOn;   // 멤버변수

    void turnOn() {  // 메소드 생성
        isOn = true;
        System.out.println(isOn + "은 불 켜진 상태");
    }

    void turnOff() { // 메소드 생성
        isOn = false;
        System.out.println(isOn + "은 불 꺼진 상태");
    }
}
