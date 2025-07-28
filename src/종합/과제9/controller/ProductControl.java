package 종합.과제9.controller;

import 종합.과제9.model.dao.ProductDao;
import 종합.과제9.model.dto.ProductDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProductControl {
    // (*) 싱글톤
    private ProductControl (){}
    public static final ProductControl instance = new ProductControl();
    public static ProductControl getInstance(){
        return instance;
    }

    // (*) dao 싱글톤 호출
    private ProductDao productDao = ProductDao.getInstance();

    // (1) 중고 물품 등록 기능
    // 매개변수 String pname
    //    String pcontent
    //    int pprice
    //    String paka
    //    String ppwd
    //    2. 판매여부 판매중으로 저장한다.
    //    3. 등록일 현재 날짜/시간으로 저장한다.
    public boolean productAdd(String pname , String pcontent , int pprice , String paka , String ppwd){
        // 1. 유효성 검사
        // 2. 객체화
        ProductDto productDto = new ProductDto(0 , pname , pcontent , pprice , false , "" , paka , ppwd);
        // 3. 객체화된 dto dao에게 전달 후 result
        boolean result = productDao.productAdd(productDto);
        // 4. view에게 리턴
        return result;

    } // func end

    // (2) 전체 조회 기능
    // 매개변수 X
    public ArrayList<ProductDto> productPrint(){
        // 1. 유효성검사
        // 2. 객체화
        // 3. 객체화된 dto dao에게 전달 후 result
        ArrayList<ProductDto> result = productDao.productPrint();
        // 4. view에게 리턴
        return result;
    }
    
    // (3) 물품 수정 기능
    /*
        3. 매개변수
    int pno
    String ppwd
    String pname
    String pcontent
    int pprice
    boolean pboolean
    4. boolean 타입 반환
     */
    public boolean productUpdate(String pname , String pcontent , int pprice , boolean pboolean , int pno , String ppwd ){
        // 1. 유효성 검사
        boolean isValid = productDao.checkProduct(pno, ppwd);
        if(!isValid){
            return false;
        }
        // 2. 객체화
        ProductDto productDto = new ProductDto(pno , pname , pcontent , pprice , pboolean , "" , "" , ppwd);
        // 3. 객체화된 dao에게 수정 번호 전달 후 result
        boolean result = productDao.productUpdate(productDto);
        // 4. view에게 리턴
        return result;
    } // func end

    // (4) 물품 삭제 기능
    /*
    3. 매개변수
    int pno
    String ppwd
    4. boolean 타입 반환
     */
    public boolean productDelete(int pno, String ppwd){
        // 1. 유효성검사
        boolean isValid = productDao.checkProduct(pno , ppwd);
        if (!isValid) {
            return false;
        }
        // 2. Dao에 삭제 요청 -> 객체화를 매개변수에서 처리
        boolean result = productDao.productDelete(new ProductDto(pno, ppwd));
        // 3. 결과 반환
        return result;
    }

}
