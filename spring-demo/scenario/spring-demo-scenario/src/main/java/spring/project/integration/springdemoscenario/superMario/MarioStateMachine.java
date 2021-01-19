package spring.project.integration.springdemoscenario.superMario;

import lombok.Getter;

/**
 * @Description: 马里奥状态机
 * @Author: jiahuiyang
 * @Date: Created in 18:11 2021/1/7
 */
@Getter
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.currentState = State.SMALL;
    }

    public void obtainMushroom() {

        // 获取蘑菇
        //todo 这些事件触发动作 只是简单的实现，实际项目级别还要考虑值的极限情况和边界情况处理，还有并发处理、异常处理等。
        this.score += 100;
        this.currentState = State.SUPER;
    }

    public void obtainCape() {

        //获取斗篷
        this.currentState = State.CAPE;
        this.score += 200;

    }

    public void obtainFirePower() {

        //获取火焰
        this.currentState = State.FIRE;
        this.score += 300;
    }

    public void meetMonster() {

        //遇到怪物
        if (this.currentState.equals(State.SUPER)) {
            this.score -= 100;
        }
        if (this.currentState.equals(State.CAPE)) {
            this.score -= 200;
        }
        if (this.currentState.equals(State.FIRE)) {
            this.score -= 300;
        }
        this.currentState = State.SMALL;
    }


}

