package spring.project.integration.springdemoscenario.chain;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:34 2021/1/7
 */
public class HandlerB extends Handler{


    @Override
    protected boolean doHandle() {
        boolean handled = false;

        // ...
        System.out.println(this.getClass().getSimpleName() + " handled and next ... ");

        return handled;
    }
}
