package day09;

public class CircleCalculator {
    // 1. 원주율 저장할 final double PI = 3.14159; 상수 선언
    final double PI = 3.14159;

    // 2. printCircleArea 반지름r을 매개변수로 받아, 원의 넓이(r * r * PI) 계산 및 출력하는
    double printCircleArea(int r){
        return r * r * PI;
    }
}
