package 종합.과제9.controller;

public class ProductControl {
    // (*) 싱글톤
    private ProductControl (){}
    public static final ProductControl instance = new ProductControl();
    public static ProductControl getInstance(){
        return instance;
    }
}
