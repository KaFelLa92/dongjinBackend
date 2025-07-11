public class testify {
    private testify() {}
    private static final testify test = new testify();
    public static testify getInstance() {
        return test;
    }

}
