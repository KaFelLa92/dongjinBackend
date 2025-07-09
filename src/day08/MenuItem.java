package day08;

public class MenuItem {
    // 멤버변수
    String name;
    int price;
    boolean isSignature;

    // 초기화 생성자
    MenuItem(String name , int price , boolean isSignature){
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;
    }

    // void로 true일때만 출력하게 하기
    void heritageMenu(){
        if(isSignature == true){
            System.out.println("[대표메뉴] " + name + " : "  + price + "원");
        } else {
            System.out.println(name + "? 그 메뉴는 시그니처 아니거덩요.");
        }
    }
}
