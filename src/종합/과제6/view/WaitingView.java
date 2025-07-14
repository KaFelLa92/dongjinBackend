package 종합.과제6.view;

import 종합.과제6.controller.WaitingController;
import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // 1) 싱글톤
    private WaitingView() {
    }

    private static final WaitingView instance = new WaitingView();

    public static WaitingView getInstance() {
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private WaitingController waitingController = WaitingController.getInstance();

    // * 모든 메소드에서 사용 가능한 Scanner 입력객체 생성
    private Scanner scan = new Scanner(System.in);

    // * 프로그램 최초화면
    public void index(){
        for (;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("=====================================");
            System.out.print("선택 > ");
            int select = scan.nextInt();
            if(select == 1 ){
                inputWait();
            }
            if (select == 2 ){
                showWaitList();
            }
        }
    }

    // 3) 대기등록 입출력 구현
    public void inputWait() {
        // 1. 안내 후 입력받기
        System.out.print("전화번호 : ");
        String number = scan.next();
        System.out.print("인원 수 : ");
        int count = scan.nextInt();
        // 2. controller에 입력받은 값 인수로 전달후 리턴받기
        boolean result = waitingController.inputWait(number, count);
        // 3. 결과/리턴 따른 출력물
        if (result) {
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        } else {
            System.out.println("[경고] 대기 등록 실패");
        }
    }

    // 4) 대기출력 입출력 구현
    public void showWaitList() {
        // 1. controller에게 요청후 리턴받기
        ArrayList<WaitingDto> result = waitingController.showWaitList();
        // 2. 받은 리턴을 반복문으로 출력
        for (int i = 0; i < result.size(); i++) {
            WaitingDto wait = result.get(i);
            System.out.println(i + 1 + ". 연락처 : " + wait.getNumber() + " 인원 : " + wait.getCount() + "명");
            System.out.println("------------------------------------");
        }
    }

}
