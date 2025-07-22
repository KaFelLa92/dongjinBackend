package 종합.과제7.controller;

import 종합.과제7.model.dao.WaitingDao;
import 종합.과제7.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // (*) 싱글톤
    private WaitingController() {
    }

    public static final WaitingController instance = new WaitingController();

    public static WaitingController getInstance() {
        return instance;
    }

    // (*) Dao 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // (1) 등록
    public boolean waitingAdd(String number, int count) {
        // 매개변수 dto 객체 생성
        WaitingDto waitingDto = new WaitingDto(number, count);
        // dao 저장 객체 전달하여 결과
        boolean result = waitingDao.waitingAdd(waitingDto);
        return result;
    }

    // (2) 전체조회
    public ArrayList<WaitingDto> waitingListPrint(){
        // dao에게 매개변수 없이 모든 dto 정보 요청하여 받기
        ArrayList<WaitingDto> result = waitingDao.waitingListPrint();
        return result;
    }


} // class end
