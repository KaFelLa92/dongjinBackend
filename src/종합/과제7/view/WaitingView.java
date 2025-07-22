package 종합.과제7.view;

import 종합.과제7.controller.WaitingController;
import 종합.과제7.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // (*) 싱글톤
    private WaitingView() {
    }

    public static final WaitingView instance = new WaitingView();

    public static WaitingView getInstance() {
        return instance;
    }

    // (*) 입력 객체 Scanner
    private Scanner scan = new Scanner(System.in);

    // (*) WaitingController 싱글톤 호출
    private WaitingController waitingController = WaitingController.getInstance();

    // (*) 메인 뷰
    public void index() {
        for (; ; ) {
            System.out.println("=======================");
            System.out.println("1. 대기등록 | 2. 대기조회");
            System.out.println("=======================");
            System.out.print("선택> ");
            int select = scan.nextInt();
            if (select == 1) {
                waitingAdd();
            }
            if (select == 2) {
                waitingListPrint();
            }
        }
    } // index func end

    // (1) 등록 뷰
    public void waitingAdd() {
        // 입력
        System.out.println("전화번호를 입력하세요");
        String number = scan.next();
        System.out.println("인원 수를 숫자만 입력하세요.");
        int count = scan.nextInt();
        // controller에게 입력받은 값 전달하고 결과 받기
        boolean result = waitingController.waitingAdd(number, count);
        if (result) {
            System.out.println("대기 등록 성공");
        } else {
            System.out.println("대기 등록 실패");
        }
    }

    // (2) 전체조회 뷰
    public void waitingListPrint() {
        // controller 요청 후 결과 받기
        ArrayList<WaitingDto> result = waitingController.waitingListPrint();
        // 결과 반복 출력
        for (int i = 0; i < result.size(); i++) {
            WaitingDto dto = result.get(i);
            System.out.println(i + 1 + "번 고객님 | 전화번호 : " + dto.getNumber() + " | 인원 수 : " + dto.getCount());
            System.out.println("---------------------------------------------------");
        }
    }

}
