package Task6.Practice.user.model.dto;

public class UserDto {
    // 1-1. 멤버변수(유저)
    private int uno;
    private String uname;
    private int uage;
    private int ugen;
    private int uheart;

    // 2. 생성자

    public UserDto() {
    }

    public UserDto(int uno, String uname, int uage, int ugen, int uheart) {
        this.uno = uno;
        this.uname = uname;
        this.uage = uage;
        this.ugen = ugen;
        this.uheart = uheart;
    }


    // 3. 메소드(getter and setter, toString)

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public int getUgen() {
        return ugen;
    }

    public void setUgen(int ugen) {
        this.ugen = ugen;
    }

    public int getUheart() {
        return uheart;
    }

    public void setUheart(int uheart) {
        this.uheart = uheart;
    }

    @Override
    public String toString() {
        return "MindtestDto{" +
                "uno=" + uno +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", ugen=" + ugen +
                ", uheart=" + uheart +
                '}';
    }
}
