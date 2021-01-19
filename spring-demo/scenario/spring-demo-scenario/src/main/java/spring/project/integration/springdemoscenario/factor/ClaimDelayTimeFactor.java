package spring.project.integration.springdemoscenario.factor;

import org.springframework.stereotype.Component;
import spring.project.integration.springdemoscenario.annotation.FactorCode;
import spring.project.integration.springdemoscenario.context.ClaimDict;
import spring.project.integration.springdemoscenario.context.ClaimFactorContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:56 2020/12/17
 */
@Component
@FactorCode("delay time")
public class ClaimDelayTimeFactor implements ClaimFactor {
    @Override
    public String getDesc() {
        return null;
    }

    /**
     * get delay time by minute
     * @param request
     * @return
     */
    @Override
    public ClaimDict resolve(ClaimFactorContext request) {

        //todo 获取延误时间

        Long delayTime = null;

        return getFactorDict().fillValue(delayTime);
    }
}
