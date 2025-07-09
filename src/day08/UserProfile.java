package day08;

public class UserProfile {
    // 멤버변수 선언
    String name;
    int age;
    String mbti;
    // 1. 변수 초기화 생성자 만들기
    UserProfile(String name , int age, String mbti){
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    void introduceMyself(){
        System.out.println("안녕하세요. 제 이름은 " + name + "입니다. 나이는 " + age + "이구요. 하하. 요즘 이거 모르면 리철진 신창원이죠. 제 MBTI는 " + mbti + "입니다. 구독 좋아요 알림설정 부탁드립니다.");
    }
}
