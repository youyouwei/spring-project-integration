package spring.project.integration.springdemoscenario;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:04 2020/11/16
 */

public class Demo {

    private String demo;

    public void demo() {
        demo = "this is a demo";
        System.out.println("this is a demo");
    }

    public void add(int i) {
        System.out.println("add " + i);
    }
}
