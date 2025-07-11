package 종합.과제5.model.dao;

import 종합.과제5.model.dto.WaitingDto;

// (역할) 실제 데이터 존재하면 데이터에 접근하는 기능(CRUD)
public class WaitingDao { // class start
    // (*) 싱글톤
    private WaitingDao() { }
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance(){
        return dao;
    } // func end

    // (*) DB : 추후 DB로 변경할 예정
    WaitingDto[] waitDB = new WaitingDto[100];

    // 1. 등록 처리 메소드 : controller로부터 DB(배열)에 저장할 객체를 받아 저장하기
    // 매개변수 : waitingDto , 반환값 : boolean
    public boolean waitingAdd(WaitingDto waitingDto){
        for ( int i = 0; i < waitDB.length; i++){   // (1) 빈공간 찾기 위해 인덱스 0부터 순회
            if (waitDB[i] == null) {                // (2) 배열내 i번째 값이 비어있으면
                waitDB[i] = waitingDto;             // (3) i번째에 저장할 객체를 대입
                return true;                        // (4-1) 성공 true 반환
            }
            
        } // for end
        return false;                               // (4-2) 실패 false 반환
    } // func end

    // 2. 조회 처리 메소드 : controller로부터 모든 DB(배열)을 반환한다.
    // 매개변수 : x         , 반환값 : WaitingDto[]
    public WaitingDto[] waitingShow(){
        return waitDB;
    } // func end

} // class end
