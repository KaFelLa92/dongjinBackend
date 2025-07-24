package 종합.과제9.model.dto;

public class InquiryDto {

    // 1. 멤버변수
    private int pno;
    private int ino;
    private String icontent;
    private String idate;
    private String iaka;
    private String ipwd;

    // 2. 생성자
    // 2-1) 전체 생성자
    public InquiryDto(int pno, int ino, String icontent, String idate, String iaka, String ipwd) {
        this.pno = pno;
        this.ino = ino;
        this.icontent = icontent;
        this.idate = idate;
        this.iaka = iaka;
        this.ipwd = ipwd;
    }

    // 2-2) 익명 문의 남기기 생성자
    public InquiryDto(int pno, String icontent, String ipwd, String iaka) {
        this.pno = pno;
        this.icontent = icontent;
        this.ipwd = ipwd;
        this.iaka = iaka;
    }

    // 3. 메소드 (getter and setter , toString)
    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public String getIcontent() {
        return icontent;
    }

    public void setIcontent(String icontent) {
        this.icontent = icontent;
    }

    public String getIdate() {
        return idate;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }

    public String getIaka() {
        return iaka;
    }

    public void setIaka(String iaka) {
        this.iaka = iaka;
    }

    public String getIpwd() {
        return ipwd;
    }

    public void setIpwd(String ipwd) {
        this.ipwd = ipwd;
    }

    @Override
    public String toString() {
        return "InquiryDto{" +
                "pno=" + pno +
                ", ino=" + ino +
                ", icontent='" + icontent + '\'' +
                ", idate='" + idate + '\'' +
                ", iaka='" + iaka + '\'' +
                ", ipwd='" + ipwd + '\'' +
                '}';
    }
} // class end
