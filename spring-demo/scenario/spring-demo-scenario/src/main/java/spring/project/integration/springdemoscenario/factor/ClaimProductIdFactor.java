package spring.project.integration.springdemoscenario.factor;

import org.springframework.stereotype.Component;
import spring.project.integration.springdemoscenario.annotation.FactorCode;
import spring.project.integration.springdemoscenario.context.ClaimDict;
import spring.project.integration.springdemoscenario.context.ClaimFactorContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 20:11 2020/12/17
 */
@Component
@FactorCode("product id")
public class ClaimProductIdFactor implements ClaimFactor {

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public ClaimDict resolve(ClaimFactorContext request) {
        return null;
    }
}
