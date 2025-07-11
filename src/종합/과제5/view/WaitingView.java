package 종합.과제5.view;

import 종합.과제5.controller.WaitingController;
import 종합.과제5.model.dto.WaitingDto;

import java.util.Scanner;

// (역할) 대기 시스템 관련 입출력 클래스
public class WaitingView { // class start
    // (*) 싱글톤 만들기 1~3단계

    private WaitingView() {
    } // (1단계)

    private static WaitingView view = new WaitingView(); // (2단계)

    public static WaitingView getInstance() {
        return view;    // (3단계)
    }

    // (*) 다른 메소드에서도 사용할 scan 객체를 멤버변수 선언
    private Scanner scan = new Scanner(System.in);

    // controller 객체 가져오기 : 멤버변수
    // 미리 만들어둔 객체 싱글톤으로 꺼내라
    private WaitingController waitingController = WaitingController.getInstance();

    // (1) 메인 view : 최초 화면 설계
    public void index() {
        for (; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("=====================================");
            System.out.print("선택 > ");
            int select = scan.nextInt();
            if (select == 1) {
                waitingAdd();
            }
            if (select == 2) {
                waitingShow();
            }
        }
    } // func end

    // (2) 등록 view
    public void waitingAdd() {
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원 수 : ");
        int count = scan.nextInt();
        boolean result = waitingController.waitingAdd(phone, count);
        // 입력받은 값 controller에게 전달 후 반환값 저장
        if (result) {
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        } else {
            System.out.println("[경고] 등록할 공간이 부족합니다.");
        }
    } // func end

    // (3) 현황 view
    public void waitingShow() {
        System.out.println("============= 대기 현황 =============");
        WaitingDto[] result = waitingController.waitingShow(); // controller에게 조회 요청 후 결과 저장
        for (int i = 0; i < result.length; i++){ // 모든 결과값을 출력한다.
            WaitingDto waitingDto = result[i];
            if( waitingDto != null ){   // Dto에 저장된 null로 초기화된 배열 인덱스 값을 빼고 모두 출력
                System.out.println(i + 1 + ". 연락처 : " + waitingDto.getPhone() + " - 인원 : " + waitingDto.getCount() + "명");
                System.out.println("------------------------------------");
            }

        }
    } // func end


} // class end
