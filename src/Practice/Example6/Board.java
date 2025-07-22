package Practice.Example6;

public class Board {
    // 1. 멤버변수
    private String content;
    private String writer;

    // 2. 생성자
    public Board() {
    }

    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }


    // 3. 메소드

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
