package 종합.과제7.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import day09.package1.A;
import 종합.과제7.model.dto.WaitingDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    // (*) 싱글톤
    private WaitingDao() {
        // 싱글톤 생성시 csv 코드 넣어 연동
        openCSV();
    }

    public static final WaitingDao instance = new WaitingDao();

    public static WaitingDao getInstance() {
        return instance;
    }

    // (*) DB 대신할 리스트 선언
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // (1) 등록
    public boolean waitingAdd(WaitingDto waitingDto) {
        waitingDB.add(waitingDto);  // 1. DB에 dto 저장
        // *CSV 저장해야 csv에 텍스트(파일) 쌓인다.
        saveCSV();
        return true;               // 2. 성공시 true 반환
    }

    // (2) 전체조회
    public ArrayList<WaitingDto> waitingListPrint() {
        return waitingDB;
    } // func end

    private String path = "src/종합/과제7/waitingList.csv";

    // 1. CSV 파일 연동 함수
    public void openCSV() {
        File file = new File(path); // 파일 객체 생성
        if (file.exists()) {         // 파일 있으면 정보 불러오기. 그리고 로드CSV써서 정보 입력
            loadCSV();
        } else {                    // 파일 없으면 파일 생성
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // (*) DB 연동 정보

    // (*) DB 연동 함수
    public void connectDB() {
        // mysql 드라이버 클래스 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC 드라이버 로드 성공");
            String db_url = "jdbc:mysql://localhost:3306/waitingList";
            String db_user = "root";
            String db_password = "1234";
            Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("DB 연동 성공");

            String sql = "insert into list(number , count) values('010-1234-5678' , '3')";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.execute();

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 연동 실패");
        }
    }


    // 2. CSV 입력 함수
    public void loadCSV() {
        try {
            FileReader fileReader = new FileReader(path);       // 읽기모드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader);    // CSV 읽기 객체 대입 생성
            List<String[]> inData = csvReader.readAll();        // .readAll로 모든 정보 읽어오기
            for (String[] row : inData) {                        // 반복문으로 행 순회
                String number = row[0];
                int count = Integer.parseInt(row[1]);
                WaitingDto waitingDto = new WaitingDto(number, count); // 각 열을 하나의 dto로 생성
                waitingDB.add(waitingDto);                              // 생성된 dto를 DB 저장
            }
            csvReader.close(); // 안전하게 닫기
        } catch (Exception e) {
            System.out.println(e);
        }
    } // func end

    // 3. CSV 출력(저장) 함수
    public void saveCSV() {
        try {
            FileWriter fileWriter = new FileWriter(path);   // 쓰기모드 객체 생성
            CSVWriter csvWriter = new CSVWriter(fileWriter); // CSV 쓰기 객체 대입 생성
            List<String[]> outData = new ArrayList<>();     // 빈 리스트 생성
            // waitingDB를 outData에 담기
            for (WaitingDto waitingDto : waitingDB) {
                // dto 번호와 인원 수를 배열 구성 (카운트는 스트링 타입으로 변환)
                String[] row = {waitingDto.getNumber(), String.valueOf(waitingDto.getCount())};
                // outData에 저장
                outData.add(row);
            } // for end
            // outData를 CSV 내보내기
            csvWriter.writeAll(outData);
            csvWriter.close(); // 객체 닫기
        } catch (Exception e) {
            System.out.println(e);
        }
    } // func end


} // class end
