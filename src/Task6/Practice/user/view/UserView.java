package Task6.Practice.user.view;

import Task6.Practice.user.control.UserControl;

import java.util.Scanner;

public class UserView {
    // 1) 싱글톤 세팅
    private UserView() {
    }

    private static final UserView instance = new UserView();

    public static UserView getInstance() {
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private UserControl userControl = UserControl.getInstance();

    // * Scanner 입력 객체
    private Scanner scan = new Scanner(System.in);

    // * 프로그램 최초화면
    public void index() {
        for (; ; ) {
            System.out.println("마음전서구 서비스를 찾아줘서 반갑다구.");
            System.out.println("먼저 귀하의 정보가 필요하다구.");
            System.out.println("1. 이번이 첫 방문이야. | 2. 방문 기록이 있을걸");
            int select = scan.nextInt();
            if(select == 1){
                insertUser();
            }
            if(select == 2){
                getUserList();
            }
        }
    }

    // 3) 등록 입출력 구현
    public void insertUser(){
        // 1. 사용자 정보 입력받기
        System.out.println("이름을 입력해달라구.");
        String uname = scan.next();
        System.out.println("나이를 입력해달라구.");
        int uage = scan.nextInt();
    }

}
