package Practice.Example7.view;

import Practice.Example7.controller.BoardController;
import Practice.Example7.model.dto.BoardDto;

import java.util.Scanner;

public class BoardView {
    // 싱글톤
    private BoardView(){}
    private static final BoardView view = new BoardView();
    public static BoardView getInstance() {
        return view;
    }

    // 스캐너 멤버변수 선언
    private Scanner scan = new Scanner(System.in);

    // 컨트롤러 객체 멤버변수로 가져오기
    private BoardController boardController = BoardController.getInstance();

    // 메인view
    public void index(){
        for (;;){
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int select = scan.nextInt();
            if (select == 1){
                boardWrite();
            }
            if ( select == 2){
                boardPrint();
            }
        }
    }

    // 등록view
    public void boardWrite(){
        System.out.println("내용 : ");
        String content = scan.next();
        System.out.println("작성자 : ");
        String writer = scan.next();
        boolean result = boardController.boardWrite(content, writer);
        if(result){
            System.out.println("[안내] 글쓰기 성공");
        } else {
            System.out.println("[경고] 글쓰기 실패");
        }

    }

    // 조회view
    public void boardPrint(){
        System.out.println("============= 게시물 목록 =============");
        BoardDto[] result = boardController.boardPrint();
        for (int i = 0; i < result.length; i++){
            BoardDto boardDto = result[i];
            if( boardDto != null){
                System.out.println("작성자 : " + boardDto.getWriter());
                System.out.println("내용 : " + boardDto.getContent());
                System.out.println("------------------------------------");
            }
        }
    }

}
