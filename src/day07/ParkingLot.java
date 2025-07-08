package day07;

public class ParkingLot {

    // 매개변수 O(주차 시간) 리턴값 O(주차 요금)

    // 메소드 정의
    int calculateFee(int m) { // 매개변수는 minute의 m
        int charge = 0;
        if (m <= 30) {
            charge = 1000;
        } else {
            charge = (m / 10 * 500) - 500;
        }

        if (charge >= 20000) {
            charge = 20000;
        }
        System.out.println("이용해주셔서 감사합니다. 주차비는 " + charge + "원 입니다." );
        return charge;
    }
// 리턴은 주차 요금을 써야함
}
