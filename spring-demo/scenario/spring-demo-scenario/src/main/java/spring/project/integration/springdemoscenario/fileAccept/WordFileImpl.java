package spring.project.integration.springdemoscenario.fileAccept;

import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 7:58 2021/1/8
 */
public class WordFileImpl extends ResourceFile {
    public WordFileImpl(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(List<Visitor> visitors) {
        for (Visitor visitor : visitors) {
            visitor.visit(this);
        }
    }
}
