package 종합.과제9.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    // (*) 싱글톤
    private ProductView() {
    }

    public static final ProductView instance = new ProductView();

    public static ProductView getInstance() {
        return instance;
    }

    // (*) 입력 객체 생성
    private Scanner scan = new Scanner(System.in);

    // (*) 메인 화면
    public void index() {
        for (; ; ) {
            try {
                home: System.out.println("================  가장 빠른 중고시장 뚝딱마켓  홈 화면 ================");
                System.out.println("1. 중고물품등록 | 2. 물품목록조회 | 3. 등록랭킹조회 | 4. 검색조회 | 5. 앱 종료");
                System.out.println("==================================================================");
                int select1 = scan.nextInt();
                if (select1 == 1) {
                    // productAdd()
                } else if (select1 == 2) {
                    // productPrint() 함수 다음에 선택지 다시 제시
                    System.out.println("=================  뚝딱마켓 물품 조회 화면 =================");
                    System.out.println("1. 물품 상세 조회  | 2. 홈 화면");
                    System.out.println("========================================================");
                    int select2 = scan.nextInt();
                    if (select2 == 1) {
                        // productPrintDetail() 함수 다음에 선택지 다시 제시

                        System.out.println("======================  뚝딱마켓 물품 상세 화면 ======================");
                        System.out.println("1. 익명 문의 남기기 | 2. 물품 정보 수정 | 3. 등록 물품 삭제 | 4. 홈 화면");
                        System.out.println("==================================================================");
                        int select3 = scan.nextInt();
                        if (select3 == 1) {
                            // inquiryAdd()
                        } else if (select3 == 2) {
                            // productUpdate()
                        } else if (select3 == 3) {
                            // productDelete()
                        } else if (select3 == 4) {
                            continue;
                        } else {
                            System.out.println("[경고] 제시한 번호를 입력해주세요.");
                        }


                    } else if (select2 == 2) {
                        continue;
                    } else {
                        System.out.println("[경고] 제시한 번호를 입력해주세요.");
                    }

                } else if (select1 == 3) {
                    // rankPrint()
                } else if (select1 == 4) {
                    // searchPrint()
                } else if (select1 == 5) {
                    break;
                } else {
                    System.out.println("[경고] 제시한 번호를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 정수를 입력해주세요. <다시 입력>");
                scan = new Scanner(System.in); // 입력객체 초기화로 오류 데이터 지우기
            } catch (Exception e) {
                System.out.println("[오류] 관리자에게 문의해주세요.");
            }
        } // for end
    } // index end

}
