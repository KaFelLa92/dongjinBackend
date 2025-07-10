package day09.package2; // C클래스의 폴더(패키지) 위치

public class C {
    // 비공개 멤버변수. 앞으로 멤버변수는 비공개로 다 막아놓으세요.
    private int privateVariable;

    // 비공개 멤버변수를 반환하는 공개 메소드 , getter
    // 공개 메소드
    public int methodReturn(String pwd) {
        // 보안 필요한 상황에서 이렇게 함
        // 한 번 우회해서 유효성 검사, 비밀번호, 보안 요소 추가할 수 있음
        return privateVariable; // 클래스내 비공개 변수 반환
    }

    private void methodSave(int value) {
        privateVariable = value;
    }
}   // class end
