package day12.model.dao;

import day12.model.dto.UserDto;

import java.util.ArrayList;

public class UserDao {
    private UserDao(){}
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance(){
        return instance;
    }
    // [*]
    private ArrayList<UserDto> userDB = new ArrayList<>();
    private int uno = 0; // 회원번호( add 할때마다 1씩 증가 )

    // [1] 회원가입
    public  int 회원가입( String uid , String upwd , String uname , String uphone  ){
        System.out.println("UserDao.회원가입");
        System.out.println("uid = " + uid + ", upwd = " + upwd + ", uname = " + uname + ", uphone = " + uphone);

        // (0) 회원번호
        uno++;
        System.out.println("uid = " + uid);

        // (1) 입력받은 값들을 객체화
        UserDto userDto = new UserDto( uno , uid , upwd , uname , uphone );
        System.out.println("userDto = " + userDto);

        // (2) db에 저장
        userDB.add( userDto );
        System.out.println("userDB = " + userDB);

        // (3) 성공시 0 반환
        return 0;
    }

    // [2] 로그인
    public int 로그인( String uid , String upwd ){
        System.out.println("UserDao.로그인");
        System.out.println("uid = " + uid + ", upwd = " + upwd);
        // (1) DB 조회(순회)
        for( int i = 0 ; i < userDB.size() ; i++ ){
            UserDto userDto = userDB.get(i);
            // (2) 비교
            if( userDto.getUid().equals( uid ) && userDto.getUpwd().equals( upwd ) ){
                return 0;
            }
        }
        return 1;
    }

    // [3] 아이디로 회원번호 조회
    public int 회원번호조회( String uid ){
        for( int i = 0 ; i < userDB.size() ; i++ ){
            UserDto userDto = userDB.get(i);
            if( userDto.getUid().equals( uid ) ) {
                return userDto.getUno();
            }
        }
        return 0;
    }

}