package day12.model.dto;

public class UserDto {
    private int uno;
    private String uid;
    private String upwd;
    private String uname;
    private String uphone;

    public UserDto() {
    }

    public UserDto(int uno, String uid, String upwd, String uname, String uphone) {
        this.uno = uno;
        this.uid = uid;
        this.upwd = upwd;
        this.uname = uname;
        this.uphone = uphone;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uno=" + uno +
                ", uid='" + uid + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uname='" + uname + '\'' +
                ", uphone='" + uphone + '\'' +
                '}';
    }
}