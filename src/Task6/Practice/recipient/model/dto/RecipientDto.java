package Task6.Practice.recipient.model.dto;

public class RecipientDto {
    // 1-2. 멤버변수(선물받는대상)
    private int rno;
    private int rrelative;
    private int rage;
    private int rhobby;
    private int rgen;
    private int rlike;
    private int rplace;

    public RecipientDto(int rno, int rrelative, int rage, int rhobby, int rgen, int rlike, int rplace) {
        this.rno = rno;
        this.rrelative = rrelative;
        this.rage = rage;
        this.rhobby = rhobby;
        this.rgen = rgen;
        this.rlike = rlike;
        this.rplace = rplace;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getRrelative() {
        return rrelative;
    }

    public void setRrelative(int rrelative) {
        this.rrelative = rrelative;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getRhobby() {
        return rhobby;
    }

    public void setRhobby(int rhobby) {
        this.rhobby = rhobby;
    }

    public int getRgen() {
        return rgen;
    }

    public void setRgen(int rgen) {
        this.rgen = rgen;
    }

    public int getRlike() {
        return rlike;
    }

    public void setRlike(int rlike) {
        this.rlike = rlike;
    }

    public int getRplace() {
        return rplace;
    }

    public void setRplace(int rplace) {
        this.rplace = rplace;
    }

    @Override
    public String toString() {
        return "RecipientDto{" +
                "rno=" + rno +
                ", rrelative=" + rrelative +
                ", rage=" + rage +
                ", rhobby=" + rhobby +
                ", rgen=" + rgen +
                ", rlike=" + rlike +
                ", rplace=" + rplace +
                '}';
    }
}
