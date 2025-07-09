package day08;

public class Member {
    // 멤버변수
    String id;
    boolean isLogin;

    // 기본생성자 만들고 각각 초기화하기
    // 생성자 안에서 초기화한 값을 그대로 출력함
    Member(String id, boolean isLogin) {
        this.id = "guest";
        this.isLogin = false;
    }


}
