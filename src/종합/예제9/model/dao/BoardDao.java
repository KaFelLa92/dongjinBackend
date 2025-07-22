package 종합.예제9.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.예제9.model.dto.BoardDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    // (*) 싱글톤 : 지정한 클래스내 하나의 객체를 미리 만들고 프로그램내 하나의 객체만 존재
    private BoardDao() {
        // --싱글톤 생성시 csv 코드 넣어야 파일 연동되고, loadCSV로 넘어가서 파일 저장 가능.
        openCSV();
    }

    private static final BoardDao instance = new BoardDao();

    public static BoardDao getInstance() {
        return instance;
    }

    // (*) DB 대신할 리스트 선언 < DB 넣으면 필요 없습니다 >
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // (1) 등록
    public boolean boardWrite(BoardDto boardDto) {
        // boolean : 반환타입으로 성공시 true, 실패시 false
        // boardWrite : 임의의 함수명
        // BoardDto boardDto : 매개변수
        boardDB.add(boardDto);  // 1. 리스트(db)에 DTO를 저장한다.
        saveCSV();              // * CSV 저장해야 csv에 텍스트(파일) 쌓임
        return true;            // 2. 성공시 true 반환한다.
    } // func end

    // (2) 전체조회
    public ArrayList<BoardDto> boardPrint() {
        // ArrayList<BoardDto> : 반환타입으로 모든 dto를 반환한다.
        return boardDB; // boardDB 변수의 타입은 ArrayList<BoardDto> 이다.
    } // func end

    // (*) CSV 파일 경로 지정한다.
    private String path = "src/종합/예제9/data.csv";

    // ----------------------- 1. CSV 파일 연동 함수 -----------------------
    public void openCSV() {
        File file = new File(path); // (1) 파일 객체 생성한다.
        if (file.exists()) {       // (2-1) 만약 파일이 존재하면 정보 불러오기 .exist() 지정한 경로에 파일 존재여부 반환 함수
            loadCSV();
        } else {                    // (2-2) 아니면 파일 생성 .createNewFile() 지정 경로에 파일 생성 함수
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    // ----------------------- 2. CSV 입력 함수 -----------------------
    public void loadCSV() {
        try {
            FileReader fileReader = new FileReader(path);       // (1) FileReader 이용한 읽기모드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader);    // (2) CSVReader에 FileReader 대입하여 CSV객체 생성
            List<String[]> inData = csvReader.readAll();      // (3) .readAll() 함수로 모든 정보를 읽어온다.
            for (String[] row : inData) {   // 향상된 for문          (4) 반복문 이용한 행 순회
                String content = row[0];    // 첫번째 열
                String writer = row[1];     // 두번째 열
                BoardDto boardDto = new BoardDto(content, writer); // (5) 각 열을 하나의 dto로 생성
                boardDB.add(boardDto);                              // (6) 생성된 dto를 리스트에 저장
            } // for end
            csvReader.close();// (7) csvReader 안전하게 닫기 ( 메모리 누수 방지 ) : 파일(용량크다)객체는 자동 초기화 보단 직접 초기화 안전
        } catch (Exception e) {
            System.out.println(e);
        }
    } // func end

    // ----------------------- 3. CSV 출력(저장) 함수 -----------------------
    public void saveCSV() {
        try {
            FileWriter fileWriter = new FileWriter(path);       // (1) FileWriter 파일 쓰기모드 객체 생성
            CSVWriter csvWriter = new CSVWriter(fileWriter);    // (2) CSVWriter에 fileWriter 객체 대입하여 생성
            List<String[]> outData = new ArrayList<>();         // (3) 빈 리스트 생성
            // ArrayList(구현체) , List(인터페이스)
            // (4) 현재 모든 정보(boardDB)를 outData에 담아준다.
            for (BoardDto boardDto : boardDB) {
                // (5) dto 하나씩 내용과 작성자를 배열로 구성
                String[] row = {boardDto.getContent(),
                        boardDto.getWriter()};
                // (6) outData에 저장한다.
                outData.add(row);
            } // for end
            // (7) 최종적으로 outData를 CSV 내보내기 한다.
            csvWriter.writeAll(outData);
            csvWriter.close(); // (8) 안전하게 객체 닫기
        } catch (Exception e){
            System.out.println(e);
        }
    } // func end

} // class end
