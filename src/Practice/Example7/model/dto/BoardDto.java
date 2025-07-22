package Practice.Example7.model.dto;

// 데이터모델 겸 이동객체
public class BoardDto {
    // 1. 멤버변수
    private String content;
    private String writer;
    
    // 2. 생성자
    public BoardDto(){}
    public BoardDto(String content , String writer ){
        this.content = content;
        this.writer = writer;
    }
    
    // 3. 메소드 게터 앤 세터, 투스트링


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
