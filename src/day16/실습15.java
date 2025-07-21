package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class 실습15 {
    public static void main(String[] args) {
        /*
        [JAVA] 실습15 : 파일 처리
[ 문제 ] 아래 파일 처리 관련 문제를 해결하시오.
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/

        /*
[문제 1] 파일에 일기 쓰기
        1. FileOutputStream을 사용하여 src 폴더 내에 src/diary.txt 파일을 생성하세요.
        2. "오늘 날씨는 맑았다. 자바 공부는 재미있다." 라는 문자열을 바이트로 변환하여 파일에 쓰세요.
        3. try-catch를 사용하여 예외 처리하세요.
*/

        // 1-1. 파일아웃풋스트림 사용하여 스트링 경로 변수 생성 후, txt 파일 생성
        // 1-3. 이거는 트라이 캐치 문으로 가둬줘야함
//        try {
//            String path = "src/day16/diary.txt";
//            FileOutputStream txt = new FileOutputStream(path);
//            // 1-2. 스캐너로 txt 파일에 문자열 추가
//            Scanner scan = new Scanner(System.in);
//            System.out.print("일기장에 뭐라고 쓸까?");
//            String today = scan.nextLine();
//            // 문자열 바이트로 변환
//            byte[] writeDiary = today.getBytes();
//            // 바이트 내보내기
//            txt.write(writeDiary);
//
//
//
//        /*
//[문제 2] 파일에 작성된 일기 읽기
//        1. FileInputStream을 사용하여 문제 1에서 생성한 src/diary.txt 파일을 읽어오세요.
//        2. 읽어온 바이트 데이터를 String으로 변환하여 콘솔에 출력하세요.
//*/
//
//            // 2-1. 파일인풋스트림으로 텍스트 파일 읽어오기
//            FileInputStream read = new FileInputStream(path);
//            // 2-2. 바이트 데이터를 String으로 변환 후 콘솔 출력
//            // today로 일기장에 쓴 후, 저장할 byte 배열 선언
//            byte[] inByte = new byte[(int) today.length()];
//            // 바이트 읽어오기
//            read.read(inByte);
//            // 문자열 변환 후 출력
//            String inStr = new String(inByte);
//            System.out.println(inStr);
//
//
//        /*
//[문제 3] File 클래스로 파일 정보 확인하기
//        1. File 객체를 src/diary.txt 경로로 생성하세요.
//        2. .exists(), .getPath(), .getName(), .length() 메소드를 각각 사용하여 해당 파일의 존재 여부, 경로, 이름, 크기(바이트)를 출력하세요.
//*/
//
//            // 3-1. File 객체를 다이어리 경로로 생성
//            File file = new File(path);
//
//            // 3-2. 메소드 활용으로 존재여부, 경로, 이름, 크기(바이트) 확인 및 출력
//            System.out.println(file.exists());
//            System.out.println(file.getPath());
//            System.out.println(file.getName());
//            System.out.println(file.length());
//
//
//        } catch (Exception e) {
//            System.out.println("일기장 잃어버림");
//        }


        /*
[문제 4] 방문 로그 누적 기록하기
        1. FileOutputStream을 사용하여 src/visit_log.txt 파일을 여세요.
        2. Scanner로 방문자 이름을 입력받아, "OOO님이 방문했습니다.\n" 형식의 문자열을 visit_log.txt 파일의 기존 내용 뒤에 추가하세요.
        3. 프로그램을 여러 번 실행하여 방문 기록이 계속 누적되는지 확인하세요.
*/

        // 4-1. 파일아웃풋스트림으로 메모장 파일 생성
        /*
        try {
            String path = "src/day16/visit_log.txt";
            FileOutputStream visit = new FileOutputStream(path , true); // true 설정하면 배열처럼 쌓을 수 있음

            // 4-2. 스캐너로 방문자 이름 배열화하여 추가
            Scanner scan = new Scanner(System.in);
            System.out.println("방문자 성함을 작성해주세요.");
            String visitor = scan.next();
            String log = visitor + "님이 방문했습니다 \n";  // 출력 형식에 맞도록
            // (1) 문자열 바이트로 변환
            byte[] outByte = log.getBytes("UTF-8");
            // (2) 바이트 내보내기
            visit.write(outByte);
            // (3) 파일 존재여부 확인
            File file = new File(path);
            // (4) 파일 존재하면 파일 읽어오기
            if(file.exists()){
                FileInputStream fin = new FileInputStream(path);
                byte[] bytes = new byte[(int) file.length()];
                fin.read(bytes);
                // 바이트를 문자열로 변환
                String str = new String(bytes , "UTF-8");
                System.out.println(str);
            }

        } catch (Exception e){
            System.out.println("방문자 기록을 열람할 수 없습니다.");
        }
*/

        /*
[문제 5] 연락처를 CSV 형식으로 파일에 저장하기
        1. Scanner를 사용하여 사용자로부터 이름, 전화번호, 사는 도시를 순서대로 입력받으세요.
        2. 입력받은 데이터들을 쉼표(,)로 연결하여 하나의 String으로 만드세요. (예: "유재석,010-1234-5678,서울")
        3. 해당 문자열을 contacts.csv 파일에 저장하세요. (줄바꿈 문자 \n 포함)
*/

        /*
        try {

            // 5-1. 스캐너로 이름, 전화번호, 도시 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.print("이름 : ");
            String name = scan.next();
            System.out.print("전화번호 : ");
            String number = scan.next();
            System.out.print("거주하는 도시 : ");
            String city = scan.next();

            // 5-2. 입력받은 데이터를 ,로 연결하여 하나의 String으로
            // 문자열을 각각 바이트로 변환한 후, 스트링으로 저장한다.

                // 5-3. contacts.csv 파일에 저장
                String path = "src/day16/contacts.csv";
                FileOutputStream fout = new FileOutputStream(path, true);   // 어펜드에 트루를 먹이면 배열처럼 계속 쌓입니다

                // 스트링 구문을 하나로 묶어주고 바이트 내보내기
            String content = name + "," + number + "," + city + "\n";
            byte[] bytes = content.getBytes();
//            byte[] bytes = name.getBytes();
//            byte[] byte2 = number.getBytes();
//            byte[] byte3 = city.getBytes();

            // 변환된 바이트 내보내기
            fout.write(bytes);
//            fout.write(byte1);
//            fout.write(byte2);
//            fout.write(byte3);

            // 파일로부터 텍스트 호출
            File file = new File(path);

            // 파일이 존재할 경우 문자열 변환 준비
            if(file.exists()){
                FileInputStream fin = new FileInputStream(path);
                // 변환된 바이트를 저장할 바이트 배열 선언(스트링 하나로 묶을 거니까 하나만 만들기)
                byte[] inByte = new byte[(int)file.length()];
                // 파일내 바이트 읽어오기
                fin.read( inByte );
                // 바이트 배열을 하나의 문자열로 변환
                String str = new String(inByte, "UTF-8");
                // 출력
                System.out.println(str);
            }


        } catch (Exception e){
            System.out.println("파일을 저장할 수 없습니다.");
        }

         */

        /*
[문제 6] 영화 감상평을 파일에 저장하기
        1. Scanner를 사용하여 사용자로부터 좋아하는 영화 제목과 감상평을 한 줄로 입력받으세요.
        2. 입력받은 내용을 src 폴더 내의 src/movie_review.txt 파일에 저장하세요.
*/

/*
        try {
            // 6-1. 스캐너로 영화제목, 감상평 한 줄로 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.print("좋아하는 영화 제목을 입력하세요.");
            String title = scan.nextLine();
            System.out.print("해당 영화의 감상평을 입력하세요.");
            String rate = scan.nextLine();
            String cinefill = title + " " + rate + "\n";


            // 6-2. 입력받은 내용 txt 파일에 저장
            // (1) 입력받은 텍스트 경로 저장
            String path = "src/day16/movie_review.txt";
            FileOutputStream fout = new FileOutputStream(path , true);
            byte[] bytes = cinefill.getBytes();
            fout.write( bytes );

*/


        /*
[문제 7] 저장된 감상평 파일 읽기
        1. 문제 3에서 생성된 src/movie_review.txt 파일의 내용을 읽어오세요.
        2. File 클래스의 .length()를 사용하여 파일 크기만큼 바이트 배열을 선언하고, 파일 전체를 한 번에 읽어오세요.
        3. 읽어온 내용을 콘솔에 출력하세요.
*/

        /*
        // (2) 파일로부터 텍스트 호출
        File file = new File(path);

        // (3) 파일 존재하면 조회
        if ( file.exists()){
            FileInputStream fin = new FileInputStream(path);
            // 2-2. length() 사용하여 바이트 배열 선언
            byte[] inByte = new byte[(int)file.length()];
            // 파일 한 번에 읽기
            fin.read(inByte);
            // 콘솔 찍기 위해 문자열
            String str = new String(inByte);
            System.out.println(str); // 프린트 찍어보기
        }


    } catch (Exception e){
        System.out.println("저장할 수 없습니다.");
    }

*/

        /*
[문제 8] 공공데이터 CSV 파일 읽고 분석하기
        1. **공공데이터포털(data.go.kr)**에서 '부평구_인구현황'을 검색하여 CSV 파일을 다운로드하고, src 폴더에 bupyeong_population.csv 라는 이름으로 저장하세요.
        2. FileInputStream을 사용하여 해당 파일을 읽어오세요. (주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)
        3. 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.
        4. for문을 사용하여 배열의 각 줄(각 동의 인구 정보)을 순회하며, '행정기관'과 '총인구수'만 추출하여 "동별: [ 동별 ], 총 인구: [ 인구수(계)   ]명" 형식으로 출력하세요.
    */

        try {
            // 8-1. 부평구 인구현황 CSV 다운받고 bupyeong_population.csv 이름으로 저장
            // 8-2. 파일인풋스트림으로 부평구 인구현황 읽어오기
            String path = "src/day16/bupyeong_population.csv";
            File file = new File(path);
            FileInputStream fin = new FileInputStream(path);
            // 바이트 배열 용량만큼 선언
            byte[] bytes = new byte[(int) file.length()];
            // 배열 저장
            fin.read(bytes);
            // 바이트를 문자열로 변환 한글깨짐 방지를 위해 "EUC-KR" 사용
            String str = new String(bytes, "EUC-KR");
            // 8-3. 읽어온 전체 내용을 줄바꿈 기준으로 분리하여 String 배열 저장
            String[] rowData = str.split("\n"); // 행 단위로 쪼개기
            // 8-4. for문 사용하여 각 줄을 순회, 행정기관과 총인구수만 추출하기
            // 출력 방식 = "동별 : [ 동별 ], 총 인구 : [ 인구수(계) ] 명"
            for (int i = 0; i < rowData.length; i++) {
                // 행데이터의 인덱스는 행
                String row = rowData[i];
                // 열데이터는 행을 열 단위로 스플릿하여 추출. like 구구단
                String[] columnData = row.split(",");
                System.out.printf("동별 : [ %5s ], 총 인구 : [ %5s ] 명 \n" , columnData[0], columnData[1]);
            }

        } catch (Exception e) {
            System.out.println("공공데이터를 읽을 수 없습니다.");
        }

    } // main end
}   // class end
