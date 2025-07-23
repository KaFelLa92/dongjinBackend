package 종합.과제8.controller;

import 종합.과제8.model.dao.WaitingDao;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // (*) 싱글톤
    private WaitingController() {}
    public static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }

    // (*) dao 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // (1) 등록 기능
    // 매개변수 wnumber , wcount (이거 땜에 생성자 따로 만들어줌)
    public boolean waitAdd( String wnumber , int wcount){
        // 1. 유효성 검사 (로그인 세션, 관리자 권한 등이 있겠지요?)
        // 2. 객체화 (동일한 생성자 있어야함)
        WaitingDto waitingDto = new WaitingDto(0 , wnumber , wcount);
        // 3. 객체화된 dto를 dao에게 전달 후 result
        boolean result = waitingDao.WaitAdd(waitingDto);
        // 4. view에게 리턴
        return result;
    }

    // (2) 조회 기능
    // 매개변수 X
    public ArrayList<WaitingDto> waitPrint(){
        // 1. 유효성 검사 패스
        // 2. 객체화 패스
        // 3. 객체화된 dto를 dao에게 전달 후 result
        ArrayList<WaitingDto> result = waitingDao.waitPrint();
        // 4. view에게 리턴
        return result;
    }

    // (3) 삭제 기능
    // 매개변수 wno
    public boolean waitDelete(int wno){
        // 1. 유효성 검사 패스
        // 2. 객체화 패스
        // 3. dao에게 삭제 번호 전달
        boolean result = waitingDao.waitDelete( wno );
        // 4. 결과 view에 리턴
        return result;
    }

    // (4) 수정 기능
    // 매개변수 wno , wcount
    public boolean waitUpdate(int wno , int wcount){
        // 1. 유효성 검사 패스
        // 2. 객체화
        WaitingDto waitingDto = new WaitingDto(wno , null , wcount);
        // 3. dao에게 수정 번호 전달 후 result
        boolean result = waitingDao.waitUpdate(waitingDto);
        // 4. 결과 view에 리턴
        return result;
    }



} // class end
