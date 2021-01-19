package spring.project.integration.springdemoscenario.snapshot;

import java.util.Scanner;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:40 2021/1/10
 */
public class ApplicationMain {

    public static void main(String[] args) {
        // text原对象 用于当前展示 每次变更都会使用text 如果调用undo 命名就恢复快照信息
        InputText text = new InputText();
        // text历次变更的快照
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String input = scanner.next();

            if (input.equals(":list")) {
                System.out.println(text.getText());
            } else if (input.equals(":undo")) {

                InputText snapshot = snapshotHolder.popSnapshot();
            } else {

            }


        }
    }

}
