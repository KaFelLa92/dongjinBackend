package day12.controller;

import day12.model.dao.UserDao;

public class UserController {
    private UserController(){}
    private static final UserController instance = new UserController();
    public static UserController getInstance(){
        return instance;
    }

    private UserDao userDao = UserDao.getInstance();
    // **************************************
    private int loginUno = 0; // 0이면 로그인안됨상태 , 1: 1번회원 , 2:2번회원 로그 인 했다는 증거.

    // [1] 회원가입
    public int 회원가입( String uid , String upwd , String uname , String uphone  ){
        System.out.println("UserController.회원가입");
        System.out.println("uid = " + uid + ", upwd = " + upwd + ", uname = " + uname + ", uphone = " + uphone);

        int result = userDao.회원가입( uid , upwd , uname , uphone );
        System.out.println("result = " + result);

        return result;
    }

    // [2] 로그인
    public int 로그인( String uid , String upwd ){
        System.out.println("UserController.로그인");
        System.out.println("uid = " + uid + ", upwd = " + upwd);

        int result = userDao.로그인( uid , upwd  );
        System.out.println("result = " + result);

        // ---------- 만약에 로그인 성공시 로그인 했다는 증거!!! ----------------- //
        if( result == 0 ){
            int result2 = userDao.회원번호조회( uid );
            if( result2 != 0 ){
                loginUno = result2; // 로그인
            }
        }
        return result;
    }

    // [3] 로그아웃
    public void 로그아웃(){
        loginUno = 0; // 로그아웃
        return;
    }

}