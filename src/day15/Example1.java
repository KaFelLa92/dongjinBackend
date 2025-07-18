package day15;  // package end

// 인터페이스란? 상수와 추상메소드를 갖는 타입
interface Keyboard {
    // [1] 상수 : 초기(처음)값이 필수다.
    public static final String manufacture = "intel";
    String manuDate = "2025-07-18"; // 상수 키워드 생략가능

    // [2] 추상메소드 : 구현부{} 제외한 선언부만 메소드 선언
    public abstract void akey();

    void bKey();            // 추상 키워드 생략가능
}   // class end

// 구현체란 ? 추상메소드를 구현한 클래스
class FightGame implements Keyboard {
    // implements 했을 경우 무조건 *구현* 해야함!
    // (1)
    @Override
    public void akey() {
        System.out.println("[공격]");
    }

    @Override
    public void bKey() {
        System.out.println("[방어]");
    }
}   // class end

class SoccerGame implements Keyboard {
    @Override
    public void akey() {
        System.out.println("[슈팅]");
    }

    @Override
    public void bKey() {
        System.out.println("[태클]");
    }
}   // class end


public class Example1 {
    public static void main(String[] args) {

        // [1] 인터페이스 객체 생성 안된다.
        // new keyboard();

        // [2] 인터페이스/타입 변수 선언된다.
        Keyboard myKeyBoard;

        // [*] 변수내 구현체(진짜)가 없다
        // myKeyBoard.akey(); 오류남

        // [3] 구현체 대입
        myKeyBoard = new FightGame();
        myKeyBoard.akey();
        myKeyBoard.akey();
        myKeyBoard.akey();

        // [4] 다형성 특징 : 중간에 타입변환
        myKeyBoard = new SoccerGame();
        myKeyBoard.akey();
        myKeyBoard.akey();

        // [5] 익명구현체 : 클래스없이(이름없는) 객체 만들기
        // 타입 변수 = new 인터페이스(){ 구현 };
        Keyboard yourKeyBoard = new Keyboard() {
            // 클래스 선언 없이 [여기]에서 구현(오버라이딩)
            @Override
            public void akey() {
                System.out.println("[키보드A]");
            }

            @Override
            public void bKey() {
                System.out.println("[키보드B]");
            }
        };  // 세미콜론 필수

        // [6] 익명구현체로 메소드 실행
        yourKeyBoard.akey();    // [키보드A] 출력

    }   // main end
}   // class end
