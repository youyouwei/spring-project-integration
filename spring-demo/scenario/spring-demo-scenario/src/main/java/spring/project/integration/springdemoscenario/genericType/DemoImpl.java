package spring.project.integration.springdemoscenario.genericType;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:44 2021/1/8
 */
public class DemoImpl extends Demo<DemoImpl> {
    @Override
    boolean check() {
        return true;
    }

    public static void main(String[] args) {
        // Demo<> 加上泛型类型 就相当于上了泛型约束 传入的时候必须要传递对应的泛型类型
        Demo<DemoImpl> demo = new DemoImpl();
        demo.handle((DemoImpl) demo);

        Demo demo2Demo = new Demo2Impl();
        demo2Demo.handle((Demo) new Object());


        // 如果没有指定泛型类型 默认就是顶层父类 如果没有extends子类约束 父类就是Object
        List list = new ArrayList();
        list.add(1);
        list.add("");
        list.add(new Object());

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(Integer.valueOf("1"));

        List<? super Integer> list2 = new ArrayList<>();


    }
}
