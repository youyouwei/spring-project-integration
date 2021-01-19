package spring.project.integration.springdemoscenario.chain;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:33 2021/1/7
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    /**
     * 做成一个模板方法 供子类使用
     */
    public final void handle() {
        boolean handled = doHandle();

        if (successor != null && !handled) {
            successor.handle();
        }

    }

    /**
     * 子类只需要实现当前handler 的处理逻辑即可
     * @return
     */
    protected abstract boolean doHandle();

}
