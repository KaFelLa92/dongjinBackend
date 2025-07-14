package 종합.과제6.controller;

import 종합.과제6.model.dao.WaitingDao;
import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {

    // 1) 싱글톤
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }

    // 2) Dao 싱글톤 가져오기
    // view가 컨트롤러를 부르고 컨트롤러가 dao를 부른다
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 3) 대기등록 기능 구현
    public boolean inputWait(String number, int count){
        boolean result = false;
        // 1. dao에게 매개변수 전달 후 리턴값 받기
        result = waitingDao.inputWait(number, count);
        return result;
    }

    // 4) 대기출력 기능 구현
    public ArrayList<WaitingDto> showWaitList(){
        return waitingDao.showWaitList();
    }

}
