package 종합.과제9;

import 종합.과제9.controller.ProductControl;
import 종합.과제9.model.dto.ProductDto;
import 종합.과제9.view.ProductView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // 물품등록 테스트 (잘 됨)
//        boolean result = ProductControl.getInstance().productAdd("고려청자" , "비싼거임" , 10000000 , "양영순" , "1234");
//        System.out.println(result);

        // 전체조회 테스트 (잘 됨. 생성자는 필요할 때마다 만들어라)2
//        ArrayList<ProductDto> result2 = ProductControl.getInstance().productPrint();
//        System.out.println(result2);

        // 물품수정 테스트 (잘 됨. SQL 문법 순서대로 매개변수 넣으셈)
//        boolean result3 = ProductControl.getInstance().productUpdate("이조백자" , "상감 방식으로 만들었습니다." , 15000000 , false ,1 , "pinemokpo");
//        System.out.println(result3);
        // 물품삭제 테스트

        ProductView.getInstance().index();
    }
}
