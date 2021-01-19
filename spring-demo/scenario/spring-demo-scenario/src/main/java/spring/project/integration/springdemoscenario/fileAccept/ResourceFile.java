package spring.project.integration.springdemoscenario.fileAccept;

import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 7:53 2021/1/8
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(List<Visitor> visitors);
}
