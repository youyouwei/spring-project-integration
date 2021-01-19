package spring.project.integration.springdemoscenario.fileAccept;

/**
 * @Description: 压缩文件
 * @Author: jiahuiyang
 * @Date: Created in 9:22 2021/1/8
 */
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFileImpl pdfFile) {
        // ...
        System.out.println("compressor pdf file");
    }

    @Override
    public void visit(WordFileImpl wordFile) {
        System.out.println("compressor word file");

    }

    @Override
    public void visit(PptFileImpl pptFile) {
        System.out.println("compressor ppt file");

    }
}
