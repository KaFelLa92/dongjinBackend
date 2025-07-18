package day15;

// 1-1. 추상 메소드를 가진 사운드에이블 인터페이스 정의
interface Soundable {
    void makeSound();   // 소리를 냅니다.
}

// 1-2. 인터페이스 임플리케이트하는 캣, 도그 클래스 만들기
// 1-3. 각 클래스에서 makeSound 오버라이딩, 출력문 바꾸기
class Cat implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

class Dog implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

// 2-1. 리모트컨트롤 인터페이스

interface RemoteControl {
    // 2-2. 인터페이스 안에 상수 정의/
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;

}

// 3-1. 추상메소드 run()가진 런에이블 인터페이스 정의
interface Runnable {
    void run(); // 달립니다.
}

// 3-2. 런에이블 받아서 구현하고 출력하는 사람과 차 클래스 만들기. 오버라이드 해야함
class Person implements Runnable {
    @Override
    public void run() {
        System.out.println("사람이 달립니다.");
    }
}

class Car implements Runnable {
    @Override
    public void run() {
        System.out.println("자동차가 달립니다.");
    }
}

// 4-1. 추상메소드 어택() 가진 어택에이블 인터페이스 정의
interface Attackable {
    void attack();
}

// 4-2. 어택에이블 구현하는 칼과 총 클래스 만들기(구현체)
class Sword implements Attackable {
    @Override
    public void attack() {
        System.out.println("[칼질]");
    }
}

class Gun implements Attackable {
    @Override
    public void attack() {
        System.out.println("[총질]");
    }
}

// 4-3. 매개변수로 Attackable 타입을 받고, 객체 어택() 메소드 호출하는 캐릭터 클래스와 유즈 웨폰 메소드 생성
class Character {
    public void useWeapon(Attackable weapon) {   // 매개변수타입을 공격가능으로
        weapon.attack();                        // 공격 메소드 호출
    }
}

// 5-1. 하늘을 납니다를 출력하는 fly() 추상메소드를 가진 플라이에이블 인터페이스
interface Flyable{
    void fly();
}

// 5-2. 물에서 헤엄칩니다 출력하는 스윔 에이블 추상메소드
interface Swimmable{
    void swim();
}

// 5-3. 오리 클래스로 둘 다 구현
class Duck implements Flyable , Swimmable{
    @Override
    public void fly() {
        System.out.println("하늘을 납니다.");
    }

    @Override
    public void swim() {
        System.out.println("물에서 헤엄칩니다.");
    }
}

// 7-1. 추상메소드 save를 가진 인터페이스 만들기

interface DataAccessObject{
    void save();    // 데이터를 저장합니다.
}

// 7-2. 구현하여 오라클 디비 , 에스큐엘 디비에 저장하는 클래스 각각 만들기
class OracleDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
}

class MySqlDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("MySQL DB에 저장");
    }
}

// 8-1. welcome() 추상메소드 가진 Greeting 인터페이스
interface Greeting{
    void welcome(); // "환영합니다."
}

// 9-1. 디바이스 인터페이스. 추상메소드로 불키고 끄기, 디폴드 메소드로 무음 처리합니다.
interface Device{
    void turnOn();
    void turnOff();
    public default void setMute(boolean mute){
        if(mute == true){
            System.out.println("무음 처리합니다.");
        } else {
            System.out.println("무음을 해제합니다.");
        }
    } // "무음 처리합니다.
}

// 9-2. 클래스 TV 만들어 구현하도록 하고, 턴온 턴오프만 오버라이딩
class Television implements Device{
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}

// 10-1. 계산기 인터페이스, 정수 합 반환(int)하는 플러스 '정적' 메소드 정의
interface Calculator{
    static int plus(int x , int y){
      return x + y;
    }
}


public class 실습13 {
    public static void main(String[] args) {

                /*
                [JAVA] 실습13 : 인터페이스
            [ 문제 ] 아래 인터페이스 관련 문제를 해결하시오.
            [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
            */

    /*
            [문제 1] 기본 인터페이스와 구현
            1. "소리를 냅니다."라는 추상 메소드 makeSound()를 가진 Soundable 인터페이스를 정의하세요.
            2. Soundable 인터페이스를 구현(implements)하는 Cat 클래스와 Dog 클래스를 만드세요.
            3. 각 클래스에서 makeSound() 메소드를 오버라이딩하여, 각각 "야옹", "멍멍"을 출력하도록 구현하세요.
            4. main 함수에서 Cat 객체와 Dog 객체를 생성하고, 각 객체의 makeSound() 메소드를 호출하여 결과를 확인하세요.
*/

        // 1-4. 고양이 개 객체 생성 후 메소드 호출
        Cat cat = new Cat();        // 클래스 타입에 클래스 객체 생성
        Soundable dog = new Dog();  // 인터페이스 타입에 클래스 객체 생성

        cat.makeSound();            // 야옹. 클래스 타입 호출
        dog.makeSound();            // 멍멍. 클래스 타입 호출

        // 구현은 하나의 리모콘으로 삼성 QLED, LG 스탠바이미의 전원을 킬 수 있는 것과 같은 방식.

            /*
            [문제 2] 인터페이스 상수
            1. RemoteControl 인터페이스를 만드세요.
            2. 이 인터페이스 안에, public static final로 최대 볼륨 MAX_VOLUME = 10과 최소 볼륨 MIN_VOLUME = 0 상수를 정의하세요.
            3. main 함수에서 객체를 생성하지 않고, RemoteControl.MAX_VOLUME과 같이 인터페이스 이름으로 직접 접근하여 두 상수를 출력하세요.
*/
        // 2-3. 객체 대신 인터페이스 이름으로 접근하여 상수 출력.
        // 인터페이스 타입으로 변수 선언하면 된다.
        System.out.println(RemoteControl.MAX_VOLUME);
        System.out.println(RemoteControl.MIN_VOLUME);

        // 구현은 객체 생성 X 타입 변수 선언 O





    /*
            [문제 3] 다형성: 인터페이스 타입 변환
            1. "달립니다."라는 추상 메소드 run()을 가진 Runnable 인터페이스를 정의하세요.
            2. Runnable을 구현하여 각각 "사람이 달립니다.", "자동차가 달립니다."를 출력하는 Person 클래스와 Car 클래스를 만드세요.
            3. main 함수에서 Runnable 타입의 변수 runner를 선언하세요.
            4. runner 변수에 new Person()을 대입하여 run() 메소드를 호출하고, 그 다음 new Car()를 대입하여 run() 메소드를 호출하여 결과가 다르게 나오는 것을 확인하세요.
*/

        // 3-3. 인터페이스 타입의 변수 runner 선언
        Runnable runner;
        // 하단 문구가 생략된 것. 하단은 클래스 없는 익명구현체.
//        Runnable runner = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };

        // 3-4. 러너 변수에 구현체를 대입. 퍼슨과 카 한번씩 하고, run() 메소드 호출
        runner = new Person();
        runner.run();
        runner = new Car();
        runner.run();




    /*
            [문제 4] 다형성을 활용한 매개변수
            1. "공격!"이라는 추상 메소드 attack()을 가진 Attackable 인터페이스를 정의하세요.
            2. Attackable을 구현하는 Sword 클래스와 Gun 클래스를 만드세요.
            3. Attackable 타입의 객체를 매개변수로 받아, 해당 객체의 attack() 메소드를 호출하는 Character 클래스와 useWeapon(Attackable weapon) 메소드를 만드세요.
            4. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 useWeapon() 메소드에 인자로 전달하여 동작을 확인하세요.
*/
        // 4-4. Sword 객체와 Gun 객체 생성 후, 캐릭터의 useWeapon() 메소드에 인자로 전달 후 동작 확인
        Sword sword = new Sword();
        Gun gun = new Gun();

        // 캐릭터 타입의 플레이어 변수 만들어서, 생성한 칼총의 변수를 매개변수로 전달.
        Character player = new Character();
        player.useWeapon(sword);
        player.useWeapon(gun);



    /*
            [문제 5] 다중 인터페이스 구현
            1. "하늘을 납니다."를 출력하는 fly() 추상 메소드를 가진 Flyable 인터페이스를 만드세요.
            2. "물에서 헤엄칩니다."를 출력하는 swimmable() 추상 메소드를 가진 Swimmable 인터페이스를 만드세요.
            3. Duck 클래스가 Flyable과 Swimmable 두 인터페이스를 모두 구현하도록 작성하세요.
            4. main 함수에서 Duck 객체를 생성하고, fly()와 swimmable() 메소드를 모두 호출하여 결과를 확인하세요.
*/

        // 5-4. 오리 객체 생성 후 날기 헤엄치기 메소드 호출
        Duck goose = new Duck();
        goose.fly();
        goose.swim();


    /*
            [문제 6] instanceof와 인터페이스
            1. 문제 5에서 만든 Flyable, Swimmable 인터페이스와 Duck 클래스를 활용합니다.
            2. main 함수에서 Duck 객체를 생성하고, Object 타입의 변수에 저장하세요.
            3. if문과 instanceof 연산자를 사용하여, 해당 객체가 Flyable 타입인지, Swimmable 타입인지 각각 확인하고, 맞다면 해당 인터페이스 타입으로 강제 형변환하여 메소드를 호출하세요.
*/

        // 6-2. Duck 객체 생성 후 Object 타입 변수에 저장
        Object duck = new Duck();

        // 6-3. if문, instanceof 연산자로 날 수 있고 수영 가능한지 확인. 
        // 가능하면 해당 인터페이스 타입으로 강제 형변환 후 메소드 호출
        if(duck instanceof Flyable){
            ((Flyable) duck).fly(); // 강제형변환 duck.fly()쳐도 자동완성됨
        }
        if (duck instanceof Swimmable){
            ((Swimmable) duck).swim();
        }



    /*
            [문제 7] 인터페이스를 이용한 객체 교체
            1. "데이터를 저장합니다."라는 추상 메소드 save()를 가진 DataAccessObject 인터페이스를 만드세요.
            2. DataAccessObject를 구현하여 각각 "Oracle DB에 저장", "MySQL DB에 저장"을 출력하는 OracleDao, MySqlDao 클래스를 만드세요.
            3. main 함수에서 DataAccessObject 타입의 변수 dao를 선언하세요.
            4. dao에 new OracleDao()를 대입하여 save()를 호출하고, 그 다음 new MySqlDao()를 대입하여 save()를 호출하여 DB가 쉽게 교체되는 것을 확인하세요.
*/

        // 7-3. 인터페이스 타입 변수 dao 선언
        DataAccessObject dao;

        // 7-4. 변수 dao에 오라클다오 대입하여 메소드 호출, 마이에스큐엘도 대입하여 메소드 호출해보기.
        dao = new OracleDao();
        dao.save();
        dao = new MySqlDao();
        dao.save();


    /*
            [문제 8] 익명 구현 객체
            1. "환영합니다."를 출력하는 welcome() 추상 메소드를 가진 Greeting 인터페이스를 만드세요.
            2. main 함수에서, 별도의 클래스 파일을 만들지 않고, Greeting 인터페이스 타입의 변수를 선언하면서 익명 구현 객체를 생성하여 welcome() 메소드를 즉석에서 구현하고 호출하세요.
            예] Greeting g = new Greeting() { ... };
*/

        // 8-2. 별도 클래스 파일 없이 인터페이스 타입 변수 선언하면서 익명 구현 객체 생성하여 welcome() 메소드 구현 호출
        Greeting hi = new Greeting() {
            @Override
            public void welcome() {
                System.out.println("환영합니다.");
            }
        };
        // 익명구현체 활용하여 메소드 호출
        hi.welcome();

    /*
            [문제 9] 디폴트 메소드 (Default Method)
            1.Device 인터페이스에, turnOn(), turnOff() 추상 메소드와 함께, public default void setMute(boolean mute) 디폴트 메소드를 추가하세요. 디폴트 메소드는 "무음 처리합니다."를 출력하도록 구현합니다.
            2.Television 클래스가 Device를 구현하도록 하되, turnOn(), turnOff()만 오버라이딩하세요.
            3.main 함수에서 Television 객체를 생성하고, turnOn(), turnOff()와 함께 디폴트 메소드인 setMute()도 호출되는 것을 확인하세요
*/

        // 9-3. TV 객체 생성 후 메소드 전부 호출
        Television tv = new Television();
        tv.turnOn();
        tv.turnOff();
        tv.setMute(false);


    /*
            [문제 10] 정적 메소드 (Static Method)
            1. Calculator 인터페이스를 만들고, 두 정수의 합을 반환하는 plus(int x, int y) 정적 메소드를 정의하세요.
            2. main 함수에서 Calculator 인터페이스를 구현하는 클래스나 객체를 만들지 않고, Calculator.plus(10, 20)과 같이 인터페이스 이름으로 직접 정적 메소드를 호출하여 결과를 출력하세요.
*/
        // 10-2. 인터페이스 이름으로 직접 계산. 출력식 만들기
        System.out.println(Calculator.plus(10, 20));



    } // main end
}   // class end
