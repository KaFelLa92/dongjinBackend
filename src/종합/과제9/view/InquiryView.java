package 종합.과제9.view;

public class InquiryView {
    // (*) 싱글톤
    private InquiryView (){}
    public static final InquiryView instance = new InquiryView();
    public static InquiryView getInstance(){
        return instance;
    }
}
