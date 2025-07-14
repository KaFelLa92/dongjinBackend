package day11;

public class Book {
    // 멤버변수
    private String title;
    private String author;

    // 생성자
    public Book() {}
    public Book(String title , String author){
        this.title = title;
        this.author = author;
    }

    // 메소드

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autuor) {
        this.author = autuor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
