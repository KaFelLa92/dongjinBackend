package day08;

public class Pet {

    // 멤버변수
    String name;
    String species;
    int age;

    // 멤버변수를 기본 생성자의 매개변수로
    Pet(String name , String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;

        System.out.println("=== 더조은애견샵 ===");
        System.out.println("이름 : " + name);
        System.out.println("견종 : " + species);
        System.out.println("연령 : " + age);
        System.out.println("==================");
    }
}
