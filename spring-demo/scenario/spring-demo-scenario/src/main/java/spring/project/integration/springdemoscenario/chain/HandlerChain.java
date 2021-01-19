package spring.project.integration.springdemoscenario.chain;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:37 2021/1/7
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        //如果 head tail 不为null  设置tail的下一个handler 并且把当前tail设置为handler,作为一个链式处理
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }

}
