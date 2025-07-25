package 종합.과제9.view;

import 종합.과제9.controller.ProductControl;
import 종합.과제9.model.dto.ProductDto;

import java.util.ArrayList;
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
                home: System.out.println("================  가장 빠른 중고시장 뚝딱마켓 홈 화면 ================");
                System.out.println("1. 중고물품등록 | 2. 물품목록조회 | 3. 등록랭킹조회 | 4. 검색조회 | 5. 앱 종료");
                System.out.println("==================================================================");
                System.out.print("선택>");
                int select1 = scan.nextInt();
                if (select1 == 1) {
                    productAdd();
                } else if (select1 == 2) {
                    productPrint();
                    System.out.println("=================  뚝딱마켓 물품 조회 화면 =================");
                    System.out.println("1. 물품 상세 조회  | 2. 홈 화면");
                    System.out.println("========================================================");
                    System.out.print("선택>");
                    int select2 = scan.nextInt();
                    if (select2 == 1) {
                        // productPrintDetail() 함수 다음에 선택지 다시 제시

                        System.out.println("======================  뚝딱마켓 물품 상세 화면 ======================");
                        System.out.println("1. 익명 문의 남기기 | 2. 물품 정보 수정 | 3. 등록 물품 삭제 | 4. 홈 화면");
                        System.out.println("==================================================================");
                        System.out.print("선택>");
                        int select3 = scan.nextInt();
                        if (select3 == 1) {
                            // inquiryAdd()
                        } else if (select3 == 2) {
                            productUpdate();
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

    // (*) 컨트롤러 싱글톤 호출
    private ProductControl productControl = ProductControl.getInstance();

    // (1) 물품 등록 화면 구현
    public void productAdd(){
        // 1. 입력받기 판매자닉네임, 판매자비밀번호, 물품명, 물품설명, 물품가격, 입력 받아 저장.
        scan.nextLine(); // 버퍼 문제 해결
        System.out.print("닉네임 : ");
        String paka = scan.next();
        System.out.print("비밀번호 : ");
        String ppwd = scan.next();
        System.out.print("물품명 : ");
        String pname = scan.nextLine();
        System.out.print("물품가격 : ");
        int pprice = scan.nextInt();
        System.out.println("물품설명을 입력해주세요");
        String pcontent = scan.nextLine();
        // 2. 컨트롤러에 전달 후 리턴 값 저장
        boolean result = productControl.productAdd(pname , pcontent , pprice , paka , ppwd);
        // 3. 리턴값 출력
        if (result){
            System.out.println("[안내] 중고물품 등록 성공");
        } else {
            System.out.println("[경고] 중고물품 등록 실패");
        }
    } // func end

    // (2) 전체조회 화면 구현
    public void productPrint(){
        // 1. 입력 받기
        // 2. 컨트롤러에 전달 후 리턴값 저장
        ArrayList<ProductDto> result = productControl.productPrint();
        // 3. 화면 구현 : 잼민이 비주얼 시술 받음
        // DB에 저장된 판매자닉네임, 물품명, 물품설명,
        //    물품가격, 판매여부, 등록일 정보(dto) 호출한다.
        // pno ,pname ,  pcontent , pprice , pboolean , pdate , paka 순으로 출력한다.
        // 상단 목차
        System.out.printf("%-4s | %-12s | %-15s | %-12s | %-8s | %-19s | %-10s\n", "번호", "물품명", "물품설명", "가격", "판매여부", "등록일", "닉네임");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (ProductDto dto : result){
            String pcontent = dto.getPcontent();
            if (pcontent.length() > 12) {
                pcontent = pcontent.substring(0, 12) + "...";
            }
            String price = String.format("%,d원", dto.getPprice());
            String status = dto.isPboolean() ? "판매중" : "판매완료";

            System.out.printf("%-4s | %-12s | %-15s | %-12s | %-8s | %-19s | %-10s\n" ,
                    dto.getPno()+"번" ,
                    dto.getPname(),
                    pcontent,
                    price,
                    status,
                    dto.getPdate(),
                    dto.getPaka());
        } // for end
    } // func end

    // (3) 물품 수정 화면 구현
//    물품 상세 화면에서 물품번호 및 비밀번호를 입력한다.
//    2. 성공하면 물품명, 물품설명, 물품가격, 판매여부를 입력받아 수정한다.
//            3. 매개변수
//    int pno
//    String ppwd
//    String pname
//    String pcontent
//    int pprice
//    boolean pboolean
//    4. boolean 타입 반환
    public void productUpdate(){
        // 1. 입력 받기
        scan.nextLine(); // 버퍼 방지
        System.out.print("수정할 물품 번호 입력>");
        int pno = scan.nextInt();
        System.out.print("비밀번호 : ");
        String ppwd = scan.next();
        System.out.print("물품명 : ");
        String pname = scan.next();
        System.out.print("물품가격 : ");
        int pprice = scan.nextInt();
        System.out.print("판매여부 : (true / false)");
        boolean pboolean = scan.nextBoolean();
        System.out.println("물품설명을 입력해주세요");
        String pcontent = scan.nextLine();
        // 2. 컨트롤러 전달 후 리턴값 저장하기
        boolean result = productControl.productUpdate(pname , pcontent , pprice , pboolean , pno , ppwd);
        // 3. 리턴값에 따른 출력
        if (result){
            System.out.println("[안내] 물품 수정 완료");
        } else {
            System.out.println("[경고] 물품번호가 없거나 비밀번호 오류입니다.");
        }
    } // func end

} // class end
