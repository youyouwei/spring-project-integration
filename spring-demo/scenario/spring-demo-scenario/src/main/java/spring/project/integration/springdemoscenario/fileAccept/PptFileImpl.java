package spring.project.integration.springdemoscenario.fileAccept;

import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 7:59 2021/1/8
 */
public class PptFileImpl extends ResourceFile {
    public PptFileImpl(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(List<Visitor> visitors) {
        for (Visitor visitor : visitors) {
            visitor.visit(this);
        }
    }
}
