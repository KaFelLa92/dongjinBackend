package 종합.과제7;

import 종합.과제7.controller.WaitingController;
import 종합.과제7.model.dto.WaitingDto;
import 종합.과제7.view.WaitingView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

//        // 다오, 컨트롤러 코드 작성 후 테스트 실행해보기
//        WaitingController wc = WaitingController.getInstance();
//        // 등록 테스트
//        boolean result1 = wc.waitingAdd("010-1234-5678" , 3);
//        System.out.println(result1);
//        // 전체조회 테스트
//        ArrayList<WaitingDto> result2 = wc.waitingListPrint();
//        System.out.println(result2);

        WaitingView.getInstance().index();

        /*
        [JAVA] 종합과제7 : 식당 대기번호 프로그램 ( MVC , +CSV  ) * boardService9 참고하시오.
        [ 목표 ] 종합과제6 요구사항 동일

                [ 실행 예시 ]
=========== 맛집 대기 시스템 ===========
                1.대기 등록 | 2.대기 현황
========================================
        선택 > 1
        전화번호 : 010-1234-5678
        인원수 : 2
                [안내] 대기 등록이 완료되었습니다.



               =========== 맛집 대기 시스템 ===========
        1.대기 등록 | 2.대기 현황
        ========================================
        선택 > 1
        전화번호 : 010-8765-4321
        인원수 : 4
                [안내] 대기 등록이 완료되었습니다.



                =========== 맛집 대기 시스템 ===========
        1.대기 등록 | 2.대기 현황
        ========================================
        선택 > 2
                ============= 대기 현황 =============
                연락처: 010-1234-5678 - 인원: 2명
                ------------------------------------
        연락처: 010-8765-4321 - 인원: 4명
                ------------------------------------

         */
    }
}
