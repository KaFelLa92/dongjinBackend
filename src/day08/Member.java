package day08;

public class Member {
    // 멤버변수, 생성자, 메소드 먼저 쓰고 시작해라

    // 멤버변수
    String id;
    boolean isLogin;
//    Pet pet; // 반려동물. 객체를 계속 불러올 수 있다(참조)
//    Member member; // 구매자; .접근연산자로 기차놀이 가능

    // 기본생성자 만들고 각각 초기화하기
    // 생성자 안에서 초기화한 값을 객체가 보관하고, 출력식 넣어도 초기화 값을 출력
    Member(String id, boolean isLogin) {
        this.id = "guest";
        this.isLogin = false;
    }


}
