package day14;

import day09.package2.C;

class Person {
    // 1-1. name 문자열 멤버변수 만드셈
    String name;
}

// 1-2. 인간 상속받는 학생 클래스 만들고 정수 멤버변수 추가
class student extends Person {
    // 멤버변수
    int studentId;
}

// 2-1. 메잌사운드 메소드 있는 동물 클래스 만들기
class Animal {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

// 2-2. 동물 클래스를 상속받고 메소드를 재정의하는 야옹이 클래스 만들기
class Cat extends Animal {
    void makeSound() {
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}

// 3-1. 생성자에서 부모 클래스 생성자 실행 출력하는 Machine 클래스 만들기
class Machine {
    public Machine() {
        System.out.println("부모 클래스 생성자 실행");
    }
}

// 3-2. 생성자에서 자식 클래스 생성자 실행 출력하는 Computer 클래스 만들고 머신에 상속시키기
class Computer extends Machine {
    public Computer() {
        System.out.println("자식 클래스 생성자 실행");
    }
}

// 4-1. 형태 클래스 만들기
class Figure {

}

// 4-2. 형태 클래스 상속받는 삼각형 클래스 만들기
class Triangle extends Figure {

}

// 5-1. draw() 메소드를 갖는 Shape 클래스
class Shape {
    // 반환 값 없는 메소드
    void draw() {
        System.out.println("도형을 그립니다.");
    }
}

// 5-2. 쉐이프 상속받고 메소드 재정의하는 Circle 클래스
class Circle extends Shape {
    void draw() {
        System.out.println("원을 그립니다.");
    }
}

// 6-1. 차량 클래스와 상속 받는 버스 클래스 만들고, 버스 클래스에는 요금 체크 메소드 추가.
class Vehicle {

}

class Bus extends Vehicle {
    // 메소드 반환값 체크하고 없으면 보이드
    void checkFare() {
        System.out.println("요금을 확인합니다.");
    }
}

// 7-1. 드링크 메소드 가진 배버리지 클래스
class Beverage {
    // 반환값 없음? 보이드
    void drink() {
        System.out.println("음료를 마십니다.");
    }
}

// 7-2. 배버리지 상속받는 코크와 커피 클래스 만들고, 오버라이딩하여 출력문 변경
class Coke extends Beverage {
    @Override
    void drink() {
        System.out.println("콜라를 마십니다.");
    }
}

class Coffee extends Beverage {
    @Override
    void drink() {
        System.out.println("커피를 마십니다.");
    }
}

// 8-1. 무기 클래스를 만들고 상속받을 칼, 총 클래스 만들기. 어택 메소드 오버라이딩으로 만들기
class Weapon {
    void attack() {
        System.out.println("무기로 공격합니다.");
    }
}

class Sword extends Weapon{
    void attack() {
        System.out.println("검으로 공격합니다.");
    }
}

class Gun extends Weapon{
    void attack() {
        System.out.println("총으로 공격합니다.");
    }
}

// 8-2. 무기 타입 매개변수를 받아 그 객체의 메소드를 호출하는 캐릭터 클래스, 유즈 메소드 만들기
class Character{
    void use(Weapon weapon){
        weapon.attack();
    }
}

// 9-1. 슈퍼클래스 클래스만들고 멤버변수와 메소드 쓰기
class SuperClass{
    // 멤버변수(고정)
    String name = "상위";
    // 반환값 없는 메소드
    void method(){
        System.out.println("상위 메소드");
    }
}

// 9-2. 상기 클래스 상속받고 멤버변수와 메소드 갖는 섭클 만들기
class SubClass extends SuperClass{
    // 멤버변수(고정)
    String name = "하위";
    // 반환값 없는 메소드
    void method(){
        System.out.println("하위 메소드");
    }
}

// 10-1. 디바이스 클래스 만들기
class Device{

}

// 10-2. 디바이스 상속받는 전기 클래스.
class Electronic extends Device{

}

// 10-3. 전기 상속받는 랩탑 클래스.
class Laptop extends Electronic{

}

public class 실습12 {
    public static void main(String[] args) {
        /*
        [JAVA] 실습12 : 클래스의 상속
[ 문제 ] 아래 클래스 상속 관련 문제를 해결하시오.
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
/*

/*
[문제 1] 기본 상속
        1. name(문자열) 멤버 변수를 가진 Person 클래스를 만드세요.
        2. Person 클래스를 상속받는 Student 클래스를 만드세요. Student 클래스에는 studentId(정수) 멤버 변수를 추가하세요.
        3. main 함수에서 Student 객체를 생성하고, 상속받은 name과 자신의 studentId에 값을 저장한 뒤 모두 출력하세요.
*/

        // 1-3. 학생 객체 생성 후 상속받은 이름과 학생아이디에 값 저장후 출력
        student stu1 = new student();
        stu1.name = "김봉팔";
        stu1.studentId = 12;
        System.out.println(stu1.name + "은 우리 반 " + stu1.studentId + "번이다.");

        /*
[문제 2] 메소드 오버라이딩 (Method Overriding)
        1. "동물이 소리를 냅니다."를 출력하는 makeSound() 메소드를 가진 Animal 클래스를 만드세요.
        2. Animal을 상속받고, makeSound() 메소드를 재정의하여 "고양이가 야옹하고 웁니다."를 출력하는 Cat 클래스를 만드세요.
        3. main 함수에서 Cat 객체를 생성하고 makeSound() 메소드를 호출하여, 재정의된 내용이 출력되는지 확인하세요.
*/

        // 2-3. 야옹이 객체 생성 후 메소드 호출하여 재정의된 내용 나오나 봅시다.
        Cat kitty = new Cat();
        kitty.makeSound();  // 재정의된 야옹이 우는 거만 나옵니다.

        /*
[문제 3] 생성자 호출 순서
        1. 생성자에서 "부모 클래스 생성자 실행"을 출력하는 Machine 클래스를 만드세요.
        2. Machine을 상속받고, 생성자에서 "자식 클래스 생성자 실행"을 출력하는 Computer 클래스를 만드세요.
        3. main 함수에서 Computer 객체를 생성할 때, 콘솔에 출력되는 생성자 호출 순서를 확인하세요.
*/

        // 3-3. 컴퓨터 객체 생성하고 콘솔 출력되는 생성자 호출 순서 확인
        Computer com = new Computer();
        // 부모가 먼저 나오고 그 다음에 자식이 나온다. 상위 클래스가 무적권 먼저 호출되는 것 확인.


        /*
[문제 4] 다형성: 자동 타입 변환 (Upcasting)
        1. Figure 클래스를 만드세요.
        2. Figure를 상속받는 Triangle 클래스를 만드세요.
        3. main 함수에서 Triangle 객체를 생성하여 Figure 타입의 변수에 저장하는 코드를 작성하고, 이것이 가능한 이유를 주석으로 설명하세요.
*/

        // 4-3. 삼각형 객체 생성하고 형태 타입 변수에 저장하는 코드 작성. 주석으로 풀이 작성.
        Triangle tri1 = new Triangle(); // 자식 객체를 자식 타입에 저장
        Figure tri2 = new Triangle();   // 자식 객체를 부모 타입에 저장
        // 이유 : 삼각형이 형태를 상속받고 있음. 자식은 부모를 원하는대로 가져다쓸 수 있다.(자동타입변환)


        /*
[문제 5] 다형성과 오버라이딩
        1."도형을 그립니다."를 출력하는 draw() 메소드를 가진 Shape 클래스를 만드세요.
        2.Shape을 상속받고, draw() 메소드를 재정의하여 "원을 그립니다."를 출력하는 Circle 클래스를 만드세요.
        3.main 함수에서 Shape shape = new Circle(); 코드를 작성한 뒤, shape.draw()를 호출했을 때 어떤 결과가 나오는지 확인하고 그 이유를 주석으로 설명하세요.
*/

        // 5-3. 부모 타입에 자식 객체를 생성한 후, 메소드 호출 시 결과를 확인하고 풀이를 주석으로 남기시오.
        Shape shape = new Circle();
        shape.draw();   // 원을 그립니다.
        // 이유 : 메소드 네임이 다를 경우, 부모를 먼저 호출하고 자식을 호출한다. 그러나 메소드 네임이 같을 경우 '재정의'되어 자식만 호출된다.


        /*
[문제 6] instanceof와 강제 타입 변환 (Downcasting)
                1. Vehicle 클래스와 이를 상속받는 Bus 클래스를 만드세요. Bus 클래스에만 checkFare() 메소드("요금을 확인합니다.")를 추가하세요.
        2. main 함수에서 Vehicle vehicle = new Bus(); 코드를 작성하세요.
        3. if문과 instanceof 연산자를 사용하여 vehicle 변수가 Bus 타입인지 확인하세요.
        4. 만약 Bus 타입이 맞다면, Bus 타입으로 강제 변환한 뒤 checkFare() 메소드를 호출하세요.
*/

        // 6-2. 부모 타입에 자식 객체 생성
        Vehicle vehicle = new Bus();

        // 6-3. if문과 instancceof 연산자(프린트린에 넣어서 트루포스 체크) 사용하여 생성한 변수가 Bus 타입인지 확인
        if (vehicle instanceof Bus) {
            System.out.println("버스 타입 입니다.");   // 얘가 맞음
        } else {
            System.out.println("버스 타입 아닙니다.");
        }

        // 6-4. vehicle 변수를 Bus 타입으로 강제 타입변환 후 요금확인 메소드 호출
        Bus bus = (Bus) vehicle; // 강제타입변환할타입 변수 = (변경할타입)변수;
        bus.checkFare();

        /*
[문제 7] 다형성을 활용한 객체 배열
        1. "음료를 마십니다."를 출력하는 drink() 메소드를 가진 Beverage 클래스를 만드세요.
        2. Beverage를 상속받는 Coke와 Coffee 클래스를 만들고, 각 클래스에서 drink() 메소드를 오버라이딩하여 "콜라를 마십니다.", "커피를 마십니다."를 출력하도록 하세요.
        3. main 함수에서 Beverage 타입의 배열을 생성하고, 그 안에 Coke 객체와 Coffee 객체를 저장하세요.
        4. 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출하고, 각기 다른 결과가 출력되는 것을 확인하세요.
*/

        // 7-3. 배버리지 타입 배열 생성, 자식 객체 저장.
        Coke coke = new Coke();
        Coffee coffee = new Coffee();
        Beverage[] beverages = {coke, coffee};

        // 7-4. for문으로 배열 요소를 꺼내 메소드 호출.
        for (int i = 0; i < beverages.length; i++) {
            beverages[i].drink();   // 콜라를 마십니다, 커피를 마십니다.
        }



        /*
[문제 8] 다형성을 활용한 매개변수
        1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요. 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
        2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
        3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.
*/

        // 8-3. 검과 총 객체 생성 후 use 메소드로 전달하여 결과 출력 확인
        Sword sword = new Sword();
        Gun gun = new Gun();
        Character character = new Character();  // 캐릭터 객체도 생성하는거 맞나?
        character.use(sword);   // 검으로 공격합니다.
        character.use(gun);     // 총으로 공격합니다.

        /*
[문제 9] 필드와 메소드의 오버라이딩 차이
        1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
        2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
        3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤, obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고, 왜 다른 결과가 나오는지 주석으로 설명하세요.
*/
        // 9-3. (부모 타입에 자식 객체) 생성 후 호출 결과 확인하고 풀이
        SuperClass obj = new SubClass();
        System.out.println(obj.name);   // 상위가 나옴. 자식 객체는 부모 타입을 가져다쓴다.
        obj.method();                   // 하위가 나옴. 메소드는 값이 같을 경우 재정의되어 자식만 나온다.
        

        /*
[문제 10] 다중 상속 관계
        1. Device 클래스를 만드세요.
        2. Device를 상속받는 Electronic 클래스를 만드세요.
        3. Electronic을 상속받는 Laptop 클래스를 만드세요.
        4. main 함수에서 Laptop 객체를 생성한 뒤, 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.
    */

        // 10-4. 랩탑 객체 생성하여 부모 타입으로 형 변환 가능한지 인스테드오브 연산자로 확인 및 출력

        Laptop laptop = new Laptop();
        System.out.println(laptop instanceof Electronic);   // true. 랩탑의 부모(한 단계 상위)가 전기.
        System.out.println(laptop instanceof Device);       // true. 랩탑의 조부모(두 단계 상위)가 디바이스.

    }   // main end
}   // class end
