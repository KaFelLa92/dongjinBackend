package Task6.Practice.user.model.dao;

import Task6.Practice.user.model.dto.UserDto;

import java.util.ArrayList;

public class UserDao {

    // 1) 싱글톤 세팅
    private UserDao(){}
    public static final UserDao instance = new UserDao();
    public static UserDao getInstance(){
        return instance;
    }

    // 2) dto 저장할 리스트 선언
    private ArrayList<UserDto> userDB = new ArrayList<>();

    // 3) 사용자 등록 기능 구현
    public boolean insertUser(int uno, String uname, int uage, int ugen, int uheart){
        boolean result = false;
        UserDto userDto = new UserDto(uno, uname, uage, ugen, uheart);
        userDB.add(userDto);
        result = true;
        return result;
    }

    // 4) 등록 사용자 확인 기능 구현
    public ArrayList<UserDto> getUserList(){
        return userDB;
    }

}
