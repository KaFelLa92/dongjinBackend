package day08;

public class Book {

    // 멤버변수
    String title;
    String author;
    int price;

    // 멤버변수를 기본 생성자의 매개변수로
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;

        System.out.print(title + " ");
        System.out.print(author);
        System.out.println(" " + price);
    }

}
