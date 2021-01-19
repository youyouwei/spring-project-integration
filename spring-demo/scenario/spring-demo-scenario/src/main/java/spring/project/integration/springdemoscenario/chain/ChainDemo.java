package spring.project.integration.springdemoscenario.chain;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:43 2021/1/7
 */
public class ChainDemo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();

    }
}
