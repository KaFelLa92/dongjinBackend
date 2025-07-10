package day09;

public class TicketMachine {

    // 1. static int totalTickets = 0; 정적 변수 선언
    static int totalTickets = 0;
    
    // 2. 호출 시 totalTickets += 1 시키는 issueTicket(){} 객체 메소드 만들기
    void issueTicket() {
        totalTickets += 1;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    // 3. 현재까지 발권된 총 티켓 수 출력하는 정적 메소드 만들기
    static void printTotalTickets() {
        System.out.println(totalTickets);
    }

}
