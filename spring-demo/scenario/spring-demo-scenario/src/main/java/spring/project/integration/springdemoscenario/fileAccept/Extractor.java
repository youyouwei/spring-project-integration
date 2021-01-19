package spring.project.integration.springdemoscenario.fileAccept;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 7:56 2021/1/8
 */
public class Extractor implements Visitor{


    @Override
    public void visit(PdfFileImpl pdfFile) {
        // ...
        System.out.println("extractor pdf file");
    }

    @Override
    public void visit(WordFileImpl wordFile) {
        System.out.println("extractor word file");

    }

    @Override
    public void visit(PptFileImpl pptFile) {
        System.out.println("extractor ppt file");

    }
}
