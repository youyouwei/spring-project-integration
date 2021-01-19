package spring.project.integration.springdemoscenario.fileAccept;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 9:19 2021/1/8
 */
public interface Visitor {

    void visit(PdfFileImpl pdfFile);

    void visit(WordFileImpl wordFile);

    void visit(PptFileImpl pptFile);

}
