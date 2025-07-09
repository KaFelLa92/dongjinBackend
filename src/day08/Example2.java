package day08; // package name

class studentBlueprint {
    // 멤버변수 = 속성/상태/특징/데이터
    String name;        // 이름
    String lunchBox;    // 점심도시락

    // 메소드 = 이벤트/행위/동작/사용법
    void 밥먹기(){
        System.out.println(name + "은(는) " + lunchBox + " 먹습니다.");
    } // class end

} // class end 이 기준으로 클래스 1개, 객체 없음

public class Example2 { // class s
    public static void main(String[] args) { // main s
        studentBlueprint s1 = new studentBlueprint();
        s1.name = "유재석";
        s1.lunchBox = "신라면";
        // 이 기준으로 클래스 1개, 객체 1개
        
        studentBlueprint s2 = new studentBlueprint();
        s2.name = "강호동";
        s2.lunchBox = "김밥";
        // 이 기준으로 클래스 1개, 객체 2개

        s1.밥먹기();
        s2.밥먹기();
        //
        studentBlueprint[] studentNamelist = new studentBlueprint[100];
        studentNamelist[0] = s1;

        studentNamelist[0].밥먹기();   // 0번째 인덱스라서 유재석은 신라면을 먹습니다 나옴.

        //
        int a = 3;
        int b = a;

        System.out.println(b);




    } // main e
} // class e
