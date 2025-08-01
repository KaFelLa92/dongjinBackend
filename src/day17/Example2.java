package day17; // package name

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example2 {
    public static void main(String[] args) {

        /*
            [ JDBC ] : JAVA DATABASE CONNECT 자바 데이터베이스 연동
                1. 준비
                    1) JDBC MySQL 라이브러리 다운로드
                    2) Connector/J https://dev.mysql.com/downloads/connector/j/
                    3) Platform Independent 5.1M 다운로드
                    4) 압축풀기 -> mysql-connector-j-9.3.0.jar 파일을 day17에 넣기
                    5) 프로젝트내 .jar 넣어주고 오른쪽클릭 -> 가장 하단 [라이브러리로 추가]

                2. 연동코드

                3. 핵심 인터페이스
                    * 인터페이스를 사용하는 이유 : 각기 다른 데이터베이스 회사들(mysql , oracle)의 클래스(구현체)를 조작하기 위해
                    1) Connection : 데이터베이스 연동
                            (1) DB서버와 연동 코드
                                Connection conn = DriverManager.getConnection("서버주소" , "계정" , "비밀번호");
                            (2) 연동된 DB에 SQL 기재 함수 , 기재된 PreparedStatement 타입 변환
                                PreparedStatement ps = conn.prepareStatement( SQL문법 );

                    2) PreparedStatement : SQL 실행 조작
                            (1) 기재된 SQL 실행 함수
                                ResultSet rs = ps.executeQuery();       SELECT 문법 실행결과를 ResultSet 타입 변환
                                int count = ps.executeUpdate();         INSERT , UPDATE , DELETE 문법 실행

                    3) ResultSet : SQL 실행 결과 조작
                            (1) SQL 결과 조작 함수
                                rs.next();                              조회된 레코드들 중에서 다음 레코드 이동 함수
                                rs.getXXX( 속성명 );                     현재 레코드에서 지정한 속성명의 값 반환 함수
                                    XXX : 적절한 자바 타입 , getInt( ) , getString( ) , getDouble( ) 등등



        */

        // [1] 자바와 데이터베이스 연동
            // 1) mysql 회사 지원하는 연동 Driver 클래스 로드/가져오기 *DB회사별로 다르다. *예외처리
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[JDBC 드라이버 가져오기 성공]");
            // 2) DB 연동후 연동결과를 갖는 인터페이스 (java.sql.Connection 으로 가져오기)
                // .preparedStatement( SQL ) : 연동된 DB에 SQL 기재준비, preparedStatement 타입 변환
            // 3) DB 연동 클래스(구현체) : DriverManager
            // 4) DB 연동 함수 : .getConnection( DB 주소, 계정명, 비밀번호 );
            // - 데이터베이스 서버 주소 : jdbc:mysql://ip주소:port번호/DB명
            String db_url = "jdbc:mysql://localhost:3306/mydb0722";         // 데이터베이스 서버 주소
            String db_user = "root";                                        // 데이터베이스 계정명
            String db_password = "1234";                                    // 데이터베이스 비밀번호
            Connection conn = DriverManager.getConnection( db_url , db_user , db_password);
            System.out.println("[데이터베이스 연동 성공]");
            // 자바에서 DML insert 문법 사용해보기 -------------------------------- //
            // 5) SQL 작성
            String sql = "insert into test(content) values('리액트를 다루는 자')";
            // 6) 지정한 SQL을 연동된 인터페이스에 대입
            PreparedStatement ps = conn.prepareStatement( sql ); // .prepareStatement ( sql )
            // 7) 기재된 SQL 실행 , PreparedStatement
            ps.execute(); 

        } catch (ClassNotFoundException e) {
            System.out.println("[JDBC 드라이버 가져오기 실패]");
        } catch (SQLException e){
            System.out.println("[데이터베이스 연동 실패]");
        }
    } // main end
}   // class end
