package spring.project.integration.springdemoscenario.superMario;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 马里奥状态
 * @Author: jiahuiyang
 * @Date: Created in 18:06 2021/1/7
 */
@Getter
@AllArgsConstructor
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;
}
