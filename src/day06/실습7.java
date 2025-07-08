package day06;  // package name

import java.util.Scanner;

public class 실습7 {  // class start
    public static void main(String[] args) {    // main start

        /*
        JAVA] 실습7 : 클래스와 객체의멤버변수
[ 문제 ] 아래 클래스와 멤버변수 관련 문제
                [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/

        /*
[문제 1] Book 클래스를 만드세요. 이 클래스는 title(문자열), author(문자열), price(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Book 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "이것이 자바다", "신용권", 30000을, 두 번째 객체에는 "자바의 정석", "남궁성", 28000을 각각 저장하세요.
        3. 두 객체의 모든 정보를 각각 출력하세요.
*/
        // Book b1 객체를 생성하기
        Book b1 = new Book();
        b1.title = "이것이 자바다";
        b1.author = "신용권";
        b1.price = 30000;

        // Book b2 객체를 생성하기
        Book b2 = new Book();
        b2.title = "자바의 정석";
        b2.author = "남궁성";
        b2.price = 28000;

        // Book 객체들 모아주기
//        Book[] bookInfo = {b1, b2};
//        System.out.println(bookInfo);

        // Book 객체 정보 모두 출력
        System.out.println(b1.title + " " + b1.author + " " + b1.price);
        System.out.println(b2.title + " " + b2.author + " " + b2.price);

        /*
[문제 2] Pet 클래스를 만드세요. name(문자열), species(문자열, 품종), age(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Pet 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "초코", "푸들", 3을, 두 번째 객체에는 "나비", "코리안숏헤어", 5를 각각 저장하세요.
        3. "이름: [이름], 종류: [품종], 나이: [나이]살" 형식으로 각 반려동물의 프로필을 출력하세요.
*/


        Pet p1 = new Pet();
        p1.name = "초코";
        p1.species = "푸들";
        p1.age = 3;

        Pet p2 = new Pet();
        p2.name = "나비";
        p2.species = "코리안숏헤어";
        p2.age = 5;

        System.out.println("이름: " + p1.name + " 종류: " + p1.species + " 나이: " + p1.age + "살");
        System.out.println("이름: " + p2.name + " 종류: " + p2.species + " 나이: " + p2.age + "살");



        /*
[문제 3] Rectangle 클래스를 만드세요. width(정수)와 height(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Rectangle 객체를 하나 생성하고, width에 10, height에 5를 저장하세요.
        2. 해당 객체의 width와 height 값을 곱하여 "사각형의 넓이: [넓이]"를 출력하세요.
*/

        Rectagle r1 = new Rectagle();
        r1.width = 10;
        r1.height = 5;
        System.out.println("사각형의 넓이: " + r1.width * r1.height);


        /*
[문제 4] BankAccount 클래스를 만드세요. accountNumber(문자열), ownerName(문자열), balance(정수, 잔액) 멤버 변수를 가집니다.
        1. main 함수에서 BankAccount 객체를 하나 생성하고, 계좌번호는 "111-222-3333", 예금주는 "유재석", 초기 잔액은 10000으로 저장하세요.
        2. balance에 5000을 더하여 입금 상황을 구현하고, "입금 후 잔액: [잔액]"을 출력하세요.
        3. 다시 balance에서 3000을 빼서 출금 상황을 구현하고, "출금 후 잔액: [잔액]"을 출력하세요.
         */

        BankAccount bA = new BankAccount();
        bA.accountNumber = "111-222-3333";
        bA.ownerName = "유재석";
        bA.balance = 10000;

        bA.balance += 5000;
        System.out.println("입급 후 잔액: " + bA.balance);
        bA.balance -= 3000;
        System.out.println("출금 후 잔액: " + bA.balance);




        /*
[문제 5] Product 클래스를 만드세요. name(문자열)과 price(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Product 객체 2개를 생성하고, 각각 "새우깡", 1500과 "콜라", 2000 정보를 저장하세요.
        2. if문을 사용하여 두 객체의 price를 비교하고, 더 비싼 상품의 이름을 출력하세요.
*/

        // 제품 객체 1번 생성
        Product p3 = new Product();
        p3.name = "새우깡";
        p3.price = 1500;

        // 제품 객체 2번 생성
        Product p4 = new Product();
        p4.name = "콜라";
        p4.price = 2000;

        // 더 비싼 상품 출력할 빈 문자열 생성
        String morePricePro = "";
        // if문 돌려서 가격 비교
        if (p3.price > p4.price) {
            morePricePro = p3.name;
        } else {
            morePricePro = p4.name;
        }
        System.out.println("더 비싼 상품은 " + morePricePro + "입니다.");


        /*
[문제 6] Member 클래스를 만드세요. id(문자열)와 isLogin(boolean) 멤버 변수를 가집니다.
        1. main 함수에서 Member 객체를 하나 생성하고, 아이디는 "admin", isLogin은 false로 초기화하세요.
        2. "로그인 전 상태: [isLogin 값]"을 출력하세요.
        3. 객체의 isLogin 값을 true로 변경하여 로그인 상황을 구현하세요.
        4. "로그인 후 상태: [isLogin 값]"을 출력하세요.
*/

        Member m1 = new Member();
        m1.id = "admin";
        m1.isLogin = false;
        System.out.println("로그인 전 상태: " + m1.isLogin);
        m1.isLogin = true;
        System.out.println("로그인 후 상태: " + m1.isLogin);



        /*
[문제 7] Television 클래스를 만드세요. channel(정수)과 volume(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Television 객체를 생성하고, channel은 7, volume은 20으로 초기화하세요.
        2. 객체의 channel 값을 11로 변경하고, volume 값은 2 감소시킨 뒤, 변경된 채널과 볼륨을 출력하세요.
*/

        // 1. 객체 생성 및 초기화
        Television t1 = new Television();
        t1.channel = 7;
        t1.volume = 20;
        t1.channel = 11;
        t1.volume -= 2;
        System.out.println("채널: " + t1.channel + "볼륨: " + t1.volume);


        /*
[문제 8] Player 클래스를 만드세요. name(문자열), power(정수), speed(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Player 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "손흥민", 90, 95를, 두 번째 객체에는 "이강인", 85, 92를 각각 저장하세요.
        3. 두 객체의 power와 speed의 합을 각각 계산하고, 합이 더 높은 선수의 이름을 출력하세요.
*/

        // 흥민햄 스탯 입력
        Player play1 = new Player();
        play1.name = "손흥민";
        play1.power = 90;
        play1.speed = 95;

        // 강인좌 스탯 입력
        Player play2 = new Player();
        play2.name = "이강인";
        play2.power = 85;
        play2.speed = 92;

        if (play1.power + play1.speed > play2.power + play2.speed) {
            System.out.println(play1.name);
        } else {
            System.out.println(play2.name);
        }



        /*
[문제 9] MenuItem 클래스를 만드세요. name(문자열), price(정수), isSignature(boolean, 대표메뉴 여부) 멤버 변수를 가집니다.
        1. main 함수에서 MenuItem 객체 3개를 생성하고, 첫 번째는 "김치찌개", 8000, true, 두 번째는 "된장찌개", 8000, false, 세 번째는 "계란찜", 3000, false로 저장하세요.
        2. if문을 사용하여 isSignature가 true인 메뉴 객체를 찾아, "[대표메뉴] [메뉴이름] : [가격]원" 형식으로 출력하세요.
*/

        // 메뉴 객체 3개 정보 각각 입력
        MenuItem menu1 = new MenuItem();
        menu1.name = "김치찌개";
        menu1.price = 8000;
        menu1.isSignature = true;

        MenuItem menu2 = new MenuItem();
        menu2.name = "된장찌개";
        menu2.price = 8000;
        menu2.isSignature = false;

        MenuItem menu3 = new MenuItem();
        menu3.name = "계란찜";
        menu3.price = 3000;
        menu3.isSignature = false;

        if (menu1.isSignature == true) {
            System.out.println("[대표메뉴] [메뉴이름] : " + menu1.name + "[가격]" + menu1.price + "원");
        }
        if (menu2.isSignature == true) {
            System.out.println("[대표메뉴] [메뉴이름] : " + menu2.name + "[가격]" + menu2.price + "원");
        }
        if (menu3.isSignature == true) {
            System.out.println("[대표메뉴] [메뉴이름] : " + menu3.name + "[가격]" + menu3.price + "원");
        }
        if (menu1.isSignature == false && menu2.isSignature == false && menu3.isSignature == false ) {
            System.out.println("시그니처가 없는 식당입니다.");
        }

        /*
[문제 10] UserProfile 클래스를 만드세요. name(문자열), age(정수), mbti(문자열) 멤버 변수를 가집니다.
        1. main 함수에서 UserProfile 객체를 하나 생성하세요.
        2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 순서대로 입력받으세요.
        3. 입력받은 값들을 생성된 객체의 각 멤버 변수에 저장하세요.
        3. 모든 정보가 저장된 객체의 멤버 변수들을 가져와 "--- 프로필 ---", "이름: [이름]", "나이: [나이]", "MBTI: [MBTI]" 형식으로 출력하세요.
*/

        Scanner scan = new Scanner(System.in);
        System.out.println("첫 번째 멤버의 이름, 나이, MBTI를 순서대로 입력하세요.");
        String name1 = scan.next();
        int age1 = scan.nextInt();
        String mbti1 = scan.next();

        System.out.println("두 번째 멤버의 이름, 나이, MBTI를 순서대로 입력하세요.");
        String name2 = scan.next();
        int age2 = scan.nextInt();
        String mbti2 = scan.next();

        System.out.println("세 번째 멤버의 이름, 나이, MBTI를 순서대로 입력하세요.");
        String name3 = scan.next();
        int age3 = scan.nextInt();
        String mbti3 = scan.next();

        UserProfile u1 = new UserProfile();
        u1.name = name1;
        u1.age = age1;
        u1.mbti = mbti1;

        UserProfile u2 = new UserProfile();
        u2.name = name2;
        u2.age = age2;
        u2.mbti = mbti2;

        UserProfile u3 = new UserProfile();
        u3.name = name3;
        u3.age = age3;
        u3.mbti = mbti3;


        System.out.println("--- 프로필 ---");
        System.out.println("이름: " + u1.name);
        System.out.println("나이: " + u1.age);
        System.out.println("MBTI: " + u1.mbti);

        System.out.println("--- 프로필 ---");
        System.out.println("이름: " + u2.name);
        System.out.println("나이: " + u2.age);
        System.out.println("MBTI: " + u2.mbti);

        System.out.println("--- 프로필 ---");
        System.out.println("이름: " + u3.name);
        System.out.println("나이: " + u3.age);
        System.out.println("MBTI: " + u3.mbti);




    }   // main end
}   // class end

// 실무에서는 한 파일에 클래스 많이 넣는 것 비권장. 패키지에 추가하세요.
//class Book {
//    String title;
//    String author;
//    int price;
//}

//class Pet {
//    String name;
//    String species;
//    int age;
//}


