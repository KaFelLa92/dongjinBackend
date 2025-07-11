public class testify {
    // 싱글톤 생성
    private testify() {}
    private static final testify test = new testify();
    public static testify getInstance() {
        return test;
    } // func end



}
