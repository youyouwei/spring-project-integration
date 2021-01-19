package spring.project.integration.springdemoscenario.snapshot;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:29 2021/1/10
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}
