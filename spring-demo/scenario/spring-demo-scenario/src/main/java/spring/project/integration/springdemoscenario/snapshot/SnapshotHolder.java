package spring.project.integration.springdemoscenario.snapshot;

import java.util.Stack;

/**
 * @Description: 通过 stack 数据栈 存储快照信息 每次text变更都会进行生成一个新的text对象，然后深克隆老的对象数据
 * @Author: jiahuiyang
 * @Date: Created in 10:33 2021/1/10
 */
public class SnapshotHolder {
    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText text) {
        InputText deepClonedText = new InputText();
        deepClonedText.setText(text.getText());
        snapshots.push(deepClonedText);
    }


}
