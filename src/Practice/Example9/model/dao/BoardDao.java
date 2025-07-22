package Practice.Example9.model.dao;

public class BoardDao {
    // (*) 싱글톤 생성
    private BoardDao (){}
    public static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    
    // (*) DB 대신할 리스트 선언
    
    // (1) 등록
    
    // (2) 전체조회
}
