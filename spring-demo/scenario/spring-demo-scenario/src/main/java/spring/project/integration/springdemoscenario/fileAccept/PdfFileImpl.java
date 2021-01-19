package spring.project.integration.springdemoscenario.fileAccept;

import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 7:57 2021/1/8
 */
public class PdfFileImpl extends ResourceFile {
    public PdfFileImpl(String filePath) {
        super(filePath);
    }

    /**
     *  这个很巧妙 在被执行实现类中 加入accept方法 引入executor可以化静态编译为动态编译
     */
    @Override
    public void accept(List<Visitor> visitors) {
        for (Visitor visitor : visitors) {
            visitor.visit(this);
        }
    }
}
