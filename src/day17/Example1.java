package day17; // package name

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {

        // OpenCSV 라이브러리 : 목적 : CSV 규칙에 따른 자동 분해/분리
        // 각종 자바 관련 라이브러리 공유 : https://mvnrepository.com/
        // (1) https://mvnrepository.com/artifact/net.sf.opencsv/opencsv/2.3
        // (2) 2.3 버전 클릭 [JAR] 다운로드 버튼 클릭
        // (3) 해당 패키지로 넣기
        // (4) 현재 프로젝트에 지정한 라이브러리 등록
        // (5) 해당 .JAR 파일을 오른쪽 클릭 -> 가장 하단 [라이브러리 추가]

        // * OPENCSV 라이브러리 사용해보기
            // 1. new CSVReader( new FileReader( 파일경로 ) ) : CSV 읽어오는 클래스
                // -> .readAll() : 데이터를 List<String[]> 타입으로 반환하는 함수
            // 2. new CSVWriter( new FileWriter( 파일경로 ) ) : CSV 출력하는 클래스
                // -> .writeAll( List객체 ) : List객체를 CSV로 내보내는 함수


        try {
            // 1. 파일 경로 지정
            String path = "src/day17/인천광역시 부평구_맛있는 집(맛집) 현황_20240801.csv";
            // 2. 파일 읽기모드 객체 생성 , 예외처리 필수 , 한글 인코딩
            FileReader fileReader = new FileReader(path , Charset.forName("EUC-KR"));
            // 3. CSVReader 클래스 이용한 file 읽어오기
            CSVReader csvReader = new CSVReader(fileReader);
            // 4. .readAll() : List<String[]> 반환
            List<String[]> inData = csvReader.readAll();
                // List 인터페이스 타입 : ArrayList의 구현체
                // ArrayList는 클래스. List는 implements.
                // System.out.println( inData );
            // 5. 반복문 이용한 순회
            for ( int i = 0; i < inData.size(); i++){
                String[] row = inData.get(i);
                System.out.printf("업소명 : %-10s , 지정메뉴 : %s \n" , row[1] , row[3]);
            }

        } catch (Exception e){
            System.out.println("CSV 파일을 읽을 수 없습니다.");
        }

    } // main end
} // class end
