package day12;

import day12.controller.UserController;

public class AppStart {
    public static void main(String[] args) {
        // UserView.getInstance().index();

        // [ 동진 ] 회원가입 테스트
        UserController.getInstance().회원가입( "jone2000" , "1234" , "홍길동" , "010-1111-2222");

        // [ 동진 ] 로그인 테스트 : 관리자 로그인 실패 했을때 테스트
        UserController.getInstance().로그인( "admin" , "0000" );

        // [ 동진 ] 로그인 테스트 : 일반 로그인 성공 했을때 테스트
        UserController.getInstance().로그인( "jone2000" , "1234" );

        // [ 동진 ] 로그아웃 테스트
        UserController.getInstance().로그아웃();

    } // main end
} // class end