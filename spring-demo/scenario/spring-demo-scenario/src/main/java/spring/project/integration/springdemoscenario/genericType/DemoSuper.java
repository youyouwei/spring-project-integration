package spring.project.integration.springdemoscenario.genericType;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 泛型就是要手动指定，否则就是在编译器进行动态类型擦除。
 * <p>
 * 只有手动执行 在编辑阶段，IDE 才会主动编译是否有错误代码
 * 如果泛型不指定 那就相当于用object 和 抽象类或则接口 无异了。
 * @Author: jiahuiyang
 * @Date: Created in 21:22 2021/1/8
 */
public class DemoSuper<T, V> {

    public static void main(String[] args) {
        //如果没有指定泛型类型 会进行泛型擦除 为Number

        // 如果泛型指定的是 extends 协变 ，需要使用高层父类来接收
        // 如果泛型指定的是 super 逆变 ，需要使用子类来接收
        // 这样就满足子类能赋值父类，父类不能赋值子类（需要强制转换），满足了多态属性

        //设置泛型参数
        DemoSuper<? super Food, ? extends Fruit> demoSuper = new DemoSuper<>();
        Food re = demoSuper.handle(new Fruit());


        List<Integer> b = new ArrayList<>();
        List<? extends Number> a = b;

    }


    public V handle(T t) {

        return null;

    }

    static class Food {
    }

    static class Fruit extends Food {
    }

    static class Apple extends Fruit {
    }

    static class RedApple extends Apple {
    }


}
