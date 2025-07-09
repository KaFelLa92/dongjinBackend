package 종합.예제5;

public class Board {
    // 클래스는 설계 기능을 분할하기 위해서 만드는 것.
    // 실체를 만들기 위한 무형 설계도
    // 실체(메모리/객체)를 만들기 위한 것.
    // 1. 멤버변수
    String content;
    String writer;

    // 2. 생성자
        // 인텔리제이에서 자동 생성자 지원
        // 1. 코드파일내 빈공간을 오른쪽 클릭
        // 2. [생성] --> [생성자]
        // 3. ctrl키 이용한 멤버변수 복수 선택 후 -> [선택]

    Board(String content , String writer){
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드
}
