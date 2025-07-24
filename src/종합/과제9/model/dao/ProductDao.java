package 종합.과제9.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDao {
    // (*) 싱글톤
    private ProductDao (){
        connect(); // 이거 생성자에 꼭 넣어줘야 호출할 때 연동되니까 기억
    }
    public static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){
        return instance;
    }
    
    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/usedMarket";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 드라이버매니저 연동 함수
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password);
        }catch (Exception e){
            System.out.println(e);
        }
    } // func end
} // class end


