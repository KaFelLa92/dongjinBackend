package Example7.Practice.model.dto;

public class BoardDto {

    // 멤버변수
    private String content;
    private String writer;

    // 생성자
    public BoardDto(){}
    public BoardDto(String content, String writer){
        this.content = content;
        this.writer = writer;
    }

    // getter and setter , toString

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
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
