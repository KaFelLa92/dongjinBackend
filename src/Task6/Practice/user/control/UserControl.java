package Task6.Practice.user.control;

import Task6.Practice.user.model.dao.UserDao;
import Task6.Practice.user.model.dto.UserDto;

import java.util.ArrayList;

public class UserControl {
    // 1) 싱글톤
    private UserControl(){}
    private static final UserControl instance = new UserControl();
    public static UserControl getInstance(){
        return instance;
    }

    // 2) UserDao 싱글톤 가져오기
    // view는 control을 부르고, control은 dao를 부른다.
    private UserDao userDao = UserDao.getInstance();

    // 3) 유저 등록 기능 구현
    public boolean insertUser(int uno, String uname,int uage, int ugen, int uheart){
        boolean result = false;
        result = userDao.insertUser(uno , uname, uage, ugen , uheart);
        return result;
    }
    
    // 4) 유저 조회 기능 구현
    public ArrayList<UserDto> getUserList(){
        return userDao.getUserList();
    }


}
