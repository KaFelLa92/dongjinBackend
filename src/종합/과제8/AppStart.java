package 종합.과제8;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dto.WaitingDto;
import 종합.과제8.view.WaitingView;

import java.util.ArrayList;


public class AppStart {
    public static void main(String[] args) {

        // 등록 테스트 (성공)
//        boolean result = WaitingController.getInstance().waitAdd("010-1234-5678" , 3);
//        System.out.println( result );
        
        // 전체조회 테스트 (성공)
//        ArrayList<WaitingDto> result2 = WaitingController.getInstance().waitPrint();
//        System.out.println(result2);
        
        // 취소 테스트 (패스)
        
        // (*) 메인화면 호출
        WaitingView.getInstance().index();

    } // main end
} // class end
