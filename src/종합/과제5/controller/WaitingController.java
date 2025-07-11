package 종합.과제5.controller; // package name

import 종합.과제5.model.dao.WaitingDao;
import 종합.과제5.model.dto.WaitingDto;

// (역할) view와 model(dto, dao)의 중간제어자
public class WaitingController { // class start

    // Controller 싱글톤 만들기 (DTO 빼고는 싱글톤 모두 만들기)
    private WaitingController() {
    } // 1단계

    private static final WaitingController control = new WaitingController(); // 2단계
    // control = 객체(instance)
    public static WaitingController getInstance() {
        return control; // 3단계
    } // func end

    // DAO (싱글톤으로 만든) 객체 가져오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 등록 처리 메소드 :
    // view에서 전달받은 phone , count 객체로 구성하여 dao에게 전달 -> 결과를 view에게 전달
    public boolean waitingAdd(String phone, int count) {
        WaitingDto waitingDto = new WaitingDto(phone, count);   // 1) 매개변수 객체화
        boolean result = waitingDao.waitingAdd(waitingDto);     // 2) dao에게 객체 전달 후 결과받기
        return result;                                          // 3) dao에게 받은 결과를 view에게 반환하기
    } // func end

    // 2. 조회 처리 메소드
    public WaitingDto[] waitingShow() { // 배열 클래스를 반환한다.
        WaitingDto[] result = waitingDao.waitingShow();         // dao에게 게시물 조회 요청 후 반환값 저장
        return result;  // dio에게 받은 결과 반환

    } // func end

} // class end
