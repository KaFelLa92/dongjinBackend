package Practice.Example9.model.dao;

import Practice.Example9.model.dto.BoardDto;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    // (*) 싱글톤 생성
    private BoardDao() {
    }

    public static final BoardDao instance = new BoardDao();

    public static BoardDao getInstance() {
        return instance;
    }

    // (*) DB 대신할 리스트 선언
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // (1) 등록
    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto);
        // CSV 저장해야 csv 파일(예제에서는 텍스트형식) 저장됨
        return true;
    } // func end

    // (2) 전체조회
    public ArrayList<BoardDto> boardPrint() {
        return boardDB;
    } // func end

    // (*) CSV 파일 경로 지정
    private String path = "src/Practice/Example9/data.csv";

    // 1. CSV 파일 연동 함수
    public void openCSV() {
        File file = new File(path); // 파일 객체 생성
        if (file.exists()) {       // 파일 존재하면 정보 불러오기.
            // loadCSV(); 호출
        } else {                    // 파일 없으면 파일 생성.
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // 2. CSV 입력 함수
    public void loadCsv() {
        try {
            FileReader fileReader = new FileReader(path);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> inData = csvReader.readAll();
            for (String[] row : inData) {
                String content = row[0];
                String writer = row[1];
                BoardDto boardDto = new BoardDto(content, writer);
                boardDB.add(boardDto);
            } // for end

        } catch (Exception e) {
            System.out.println(e);
        } // catch end
    } // func end

    // 3. CSV 출력 함수
    public void saveCSV() {
        try {
            FileWriter fileWriter = new FileWriter(path);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            List<String[]> outData = new ArrayList<>();
            for (BoardDto boardDto : boardDB) {
                String[] row = {boardDto.getContent(), boardDto.getWriter()};
                outData.add(row);
            } // for end
            csvWriter.writeAll(outData);
            csvWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        } // catch end
    } // func end
}
