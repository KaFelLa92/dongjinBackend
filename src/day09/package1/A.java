package day09.package1; // A클래스의 폴더(패키지) 위치

public class A {
    public int publicVariable = 1;      // public
    private int privateVariable = 2;    // private
    int normalVariable = 3;             // (default) 생략

    public void method(){   // 본인 클래스에서는 접근 및 호출 가능
        System.out.println(this.publicVariable); // this는 써도 되고 안 써도 됨. 본인 클래스의 멤버변수 가리킴.
        System.out.println(privateVariable);
        System.out.println(normalVariable);
    }
}
