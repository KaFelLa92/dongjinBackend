package day09;

public class Score {
    // 1. private 접근 제한자 int score 멤버변수
    private int score;

    // 2. setScore(int score는 매개변수) 메소드 정의 , 반환값 없으므로 void
    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
            System.out.println("점수는 " + score + "점 입니다.");
        } else {
            System.out.println("유효하지 않은 점수입니다.");
        }

    } // func end

//    // 3. if score >= 100 && score <= 0 일때 값 저장. 벗어나면 유효성 검사
//    // 불리언체크를 하는 게 낫겠다.
//
//    public boolean getScore() {
//        if (score <= 100 && score >= 0) {
//            System.out.println("점수는 " + score + "점 입니다.");
//            return true;
//        }
//        System.out.println("유효하지 않은 점수입니다.");
//        return false;
//    }

}
