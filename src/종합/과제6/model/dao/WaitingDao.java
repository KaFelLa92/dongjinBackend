package 종합.과제6.model.dao;

import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingDao {
    // 1) 싱글톤
    private WaitingDao(){}
    public static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // 2) 게시물(DTO) 저장 리스트 선언
    private ArrayList<WaitingDto> waitingDB = new ArrayList<WaitingDto>();

    // 3) 대기등록 기능 구현
    public boolean inputWait(String number , int count){
        boolean result = false;
        // 1) 매개변수 값들을 객체화
        WaitingDto waitingDto = new WaitingDto(number, count);
        // 2) 리스트(db)에 생성한 객체 대입
        waitingDB.add(waitingDto);
        // 3) 성공시 result에 true
        result = true;
        return result;
    }

    // 4) 대기출력 기능 구현
    public ArrayList<WaitingDto> showWaitList(){
        return waitingDB;
    }
}
