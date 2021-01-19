package spring.project.integration.springdemoscenario.genericType;

/**
 * @Description:  Demo 仅允许他的子类 去显化他的泛型 这样可以控制一些自身使用泛型类型的一些操作
 *
 * @Author: jiahuiyang
 * @Date: Created in 21:16 2021/1/8
 */
public abstract class Demo<E extends Demo<E>> {

    public void handle(E e) {
        if (e.check()) {
            System.out.println("handle demo");
            return;
        }
    }


    abstract boolean check();

}
