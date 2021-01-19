package spring.project.integration.springdemoscenario.factor;

import org.springframework.core.annotation.AnnotationUtils;
import spring.project.integration.springdemoscenario.annotation.FactorCode;
import spring.project.integration.springdemoscenario.context.ClaimDict;
import spring.project.integration.springdemoscenario.context.ClaimFactorContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2020/12/17
 */
public interface ClaimFactor {

    /**
     * get factor dictionary
     * @return
     */
    default ClaimDict getFactorDict(){
        return ClaimDict.builder()
                .code(AnnotationUtils.getValue(this.getClass().getAnnotation(FactorCode.class)).toString())
                .desc(getDesc())
                .build();
    }

    /**
     * get dict desc
     *
     * @return
     */
    String getDesc();

    /**
     * resolve factor and return the result
     * @param request
     * @return
     */
    ClaimDict resolve(ClaimFactorContext request);

}
