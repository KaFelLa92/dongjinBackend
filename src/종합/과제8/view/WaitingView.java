package 종합.과제8.view;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {
    // (*) 싱글톤
    private WaitingView() {
    }

    public static final WaitingView instance = new WaitingView();

    public static WaitingView getInstance() {
        return instance;
    }

    // (*) 입력 객체 (Scanner)
    private Scanner scan = new Scanner(System.in);

    // (*) 메인 화면
    public void index() {
        for (; ; ) {
            try {
                System.out.println("=============== 대기 시스템 ===============");
                System.out.println("1. 대기등록 | 2. 대기조회 | 3. 대기취소 | 4. 대기인원 수정");
                System.out.print("선택 > ");
                int select = scan.nextInt();
                if (select == 1) {
                    waitAdd();
                } else if (select == 2) {
                    waitPrint();
                } else if (select == 3) {
                    waitDelete();
                } else if (select == 4) {
                    waitUpdate();
                } else {
                    System.out.println("[경고] 제발 1번부터 4번 중에서 선택해주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 일치하지 않습니다. 제발 숫자만 써주세요.");
                scan = new Scanner(System.in); // 입력 객체 초기화
            } catch (Exception e) {
                System.out.println("[오류] 관리자에게 문의해주세요. 010-1234-5678");
            } // catch end
        } // for end
    } // func end

    // (*) 컨트롤러 싱글톤 호출
    private WaitingController waitingController = WaitingController.getInstance();

    // (1) 등록 화면 구현
    public void waitAdd() {
        // 1. 입력받기
        System.out.print("전화번호 : ");
        String wnumber = scan.next();
        System.out.print("인원 수 : ");
        int wcount = scan.nextInt();
        // 2. 컨트롤러에 전달 후 리턴값 저장하기
        boolean result = waitingController.waitAdd(wnumber, wcount);
        // 3. 리턴값 출력하기
        if (result) {
            System.out.println("[안내] 대기 등록 성공");
        } else {
            System.out.println("[경고] 대기 등록 실패");
        }


    } // func end

    // (2) 조회 화면 구현
    public void waitPrint() {
        // 1. 컨트롤러에게 doa 전달 후 리턴값 저장하기
        ArrayList<WaitingDto> result = waitingController.waitPrint();
        // 2. 화면 구현
        System.out.println("대기순서 \t 전화번호 \t 인원 수"); // 표 상단 인덱스
        for (WaitingDto dto : result) {
            System.out.printf("%s번 \t %s \t %s명 \n", dto.getWno(), dto.getWnumber(), dto.getWcount());
        } // for end
    }  // func end

    // (3) 취소 화면 구현
    public void waitDelete() {
        // 1. 입력 받기
        System.out.print("취소할 대기 번호 : ");
        int wno = scan.nextInt();
        // 2. 컨트롤러에 전달 후 리턴값 저장하기
        boolean result = waitingController.waitDelete(wno);
        // 3. 리턴값에 따른 출력
        if (result) {
            System.out.println("[안내] 대기 취소 성공");
        } else {
            System.out.println("[경고] 없는 대기 번호입니다.");
        }
    } // func end

    // (4) 수정 화면 구현
    public void waitUpdate() {
        // 1. 입력 받기
        System.out.print("변경할 대기 번호 : ");
        int wno = scan.nextInt();
        System.out.print("변경할 인원 수 : ");
        int wcount = scan.nextInt();
        // 2. 컨트롤러 전달 후 리턴값 저장하기
        boolean result = waitingController.waitUpdate(wno, wcount);
        // 3. 리턴값에 따른 출력
        if (result) {
            System.out.println("[안내] 대기 인원 변경 성공");
        } else {
            System.out.println("[경고] 없는 대기 번호입니다.");
        }
    } // func end

} // class end
