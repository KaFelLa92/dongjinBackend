package 종합.과제3;


public class WaitingController {
    // 멤버 변수
    Waiting[] waitings = new Waiting[100];

    // 메소드
    // (1) 대기 등록
    // 매개변수 phone, count
    // true, false 반환하는 불리언 메소드
    boolean addWaiting(String phone, int count) {
        // Waiting 객체 생성
        Waiting waiting = new Waiting();
        // 매개 변수로 받은 값을 객체 멤버 변수 저장
        waiting.phone = phone;
        waiting.count = count;
        // null인지 확인하고 대기열 넣기 (for, if)
        for (int i = 0; i <= waitings.length - 1; i++) {
            if (waitings[i] == null) {
                waitings[i] = waiting;  // 폰과 인원수를 배열에 넣기
                return true;
            }
        } // for end

        return false; // for문에서 null 못찾으면 false
    }

    // (2) 대기 조회
    // 매개변수 X
    // 반환값 waitings 배열 전체
    Waiting[] getWaitingList() {
        return waitings;
    }

}
