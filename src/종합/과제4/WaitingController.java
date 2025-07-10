package 종합.과제4; // package name

public class WaitingController {    // class start

    // (1) 대기명단 배열 선언
    private static final Waiting[] waitings = new Waiting[100];
    // 프리베이트라서 한 번 거쳐야 호출 가능.
    // 스태틱으로 객체 없이 호출 가능.
    // 파이날이라 바뀌지 않음 (배열 100개 있는 건 바꿀 필요 없죠?)




    // (2) public static으로 대기 등록 기능 메소드 선언(불리언으로 반환)
    public static boolean addWaiting(String phone, int count) {
        //  매개변수 값을 생성자에 전달하여 *객체 생성*
        Waiting wait = new Waiting(phone ,count);
        //  배열 빈 공간을 찾아 생성된 객체 저장. 성공 여부 boolean 판정 확인
        for( int i = 0; i <= waitings.length - 1; i++){
            if(waitings[i] == null){    // 배열 인덱스가 비어있으면
                waitings[i] = wait;     // 매개변수가 담긴 객체를 인덱스에 넣는다.
                return true;            // 저장 성공
            }
        } // for end
        return false;   // 저장 실패다
    }

    // (3) public static으로 대기 현황 조회 기능 메소드 선언. waitings 배열 전체 반환. Waiting[] 배열을 클래스로.
    public static Waiting[] getWaitingList(){
        return waitings;
    }

} // class end
