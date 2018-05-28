package demo.models;

/**
 * TestBean
 *
 * @author jt_hu
 * @date 2018/5/21
 */
public class TestBean implements TestBeanInterface {

    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    @Override
    public void test() {
        System.out.println("test");
    }

}
