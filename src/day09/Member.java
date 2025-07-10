package day09;

public class Member {
    // 1. private 문자열 멤버변수 id
    private String id;

    // 2. public 접근제한자 가진 setId() 메소드 : 얘는 반환 안해서 void
    public void setId( String id){
        this.id = id;
    }

    // 2. 반환(void아니고 타입/클래스 필요)할 수 있는 public 접근제한자 가진 getId() 메소드
    public String getId(){
        return id;
    }

}
