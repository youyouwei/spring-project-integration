package spring.project.integration.springdemoscenario.chain2;

import spring.project.integration.springdemoscenario.chain.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:56 2021/1/7
 */
public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        handlers.add(handler);
    }

    /**
     * 通过返回值 可以判断最终职责链是否完全处理成功，如果处理成功才做某个操作，否则做另外一个操作
     * @return
     */
    public boolean handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                return false;
            }
        }

        return true;
    }

}
