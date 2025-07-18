package day12.view;

import day12.controller.UserController;

public class UserView {
    private UserView(){}
    private static final UserView instance = new UserView();
    public static UserView getInstance(){
        return instance;
    }
    private UserController userController = UserController.getInstance();

    public void index(){
        System.out.println("----------- 메인 화면 ------------- ");
    }

}