package spring.project.integration.springdemoapp.factor;


import spring.project.integration.springdemoapp.context.ClaimDict;
import spring.project.integration.springdemoapp.context.ClaimFactorContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2020/12/17
 */
public interface ClaimFactor<T> {

    /**
     * get factor dictionary
     * @return
     */
    default ClaimDict getFactorDict(){
        return ClaimDict.builder()
                .code(this.getClass().getSimpleName())
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
    T resolve(ClaimFactorContext request);

}
