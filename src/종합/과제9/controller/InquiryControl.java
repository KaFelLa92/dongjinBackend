package 종합.과제9.controller;

public class InquiryControl {
    // (*) 싱글톤
    private InquiryControl (){}
    public static final InquiryControl instance = new InquiryControl();
    public static InquiryControl getInstance(){
        return instance;
    }
}
