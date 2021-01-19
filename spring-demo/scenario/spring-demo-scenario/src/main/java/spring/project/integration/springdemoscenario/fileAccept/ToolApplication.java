package spring.project.integration.springdemoscenario.fileAccept;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 观察者模式   这种如果在加入文件类型或则处理器的时候 不需要修改代码直接实现对应的接口或则抽象类即可，基本上实现了开闭原则
 * @Author: jiahuiyang
 * @Date: Created in 8:38 2021/1/8
 */
public class ToolApplication {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        List<Visitor> visitors = listVisitors();
        for (ResourceFile resourceFile : resourceFiles) {
            //消除了代码样式上的嵌套循环 这种无需返回值 的循环处理可以通过多线程进行消除嵌套循环
            resourceFile.accept(visitors);
        }
    }

    private static List<Visitor> listVisitors() {
        List<Visitor> list = new ArrayList<>();
        list.add(new Extractor());
        list.add(new Compressor());
        return list;
    }

    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> list = new ArrayList<>();

        // ...

        list.add(new PdfFileImpl("a.pdf"));
        list.add(new WordFileImpl("a.doc"));
        list.add(new PptFileImpl("a.ppt"));
        return list;
    }


}
