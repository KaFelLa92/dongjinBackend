package 종합.과제9.model.dto;

public class ProductDto {

    // 1. 멤버변수
    private int pno;
    private String pname;
    private String pcontent;
    private int pprice;
    private boolean pboolean;
    private String pdate;
    private String paka;
    private String ppwd;

    // 2. 생성자
    // 2-1) 전체 생성자
    public ProductDto(int pno, String pname, String pcontent, int pprice, boolean pboolean, String pdate, String paka, String ppwd) {
        this.pno = pno;
        this.pname = pname;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.pboolean = pboolean;
        this.pdate = pdate;
        this.paka = paka;
        this.ppwd = ppwd;
    }

    // 2-2) 중고물품등록용 생성자
    public ProductDto(String pname, String pcontent, int pprice, String paka, String ppwd) {
        this.pname = pname;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.paka = paka;
        this.ppwd = ppwd;
    }

    // 2-3) 물품정보수정용 생성자
    public ProductDto(int pno, String paka, String ppwd, String pcontent, String pname) {
        this.pno = pno;
        this.paka = paka;
        this.ppwd = ppwd;
        this.pcontent = pcontent;
        this.pname = pname;
    }

    // 2-4) 물품삭제용 생성자
    public ProductDto(int pno, String ppwd) {
        this.pno = pno;
        this.ppwd = ppwd;
    }

    // 2-5) 전체조회용 생성자
    public ProductDto(int pno, String pname, String pcontent, int pprice, boolean pboolean, String pdate, String paka) {
        this.pno = pno;
        this.pname = pname;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.pboolean = pboolean;
        this.pdate = pdate;
        this.paka = paka;
    }

    // 3. 메소드 (getter and setter , toString)
    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public boolean isPboolean() {
        return pboolean;
    }

    public void setPboolean(boolean pboolean) {
        this.pboolean = pboolean;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPaka() {
        return paka;
    }

    public void setPaka(String paka) {
        this.paka = paka;
    }

    public String getPpwd() {
        return ppwd;
    }

    public void setPpwd(String ppwd) {
        this.ppwd = ppwd;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", pprice=" + pprice +
                ", pboolean=" + pboolean +
                ", pdate='" + pdate + '\'' +
                ", paka='" + paka + '\'' +
                ", ppwd='" + ppwd + '\'' +
                '}';
    }
} // class end
