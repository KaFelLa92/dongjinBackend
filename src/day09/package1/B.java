package day09.package1; // B클래스의 폴더(패키지) 위치

public class B {
    public void method(){
        A a = new A();
        System.out.println(a.publicVariable); // 가능
//      System.out.println(a.privateVariable); 불가능
        System.out.println(a.normalVariable); // 가능. A와 B가 같은 패키지라서.
    }
}
