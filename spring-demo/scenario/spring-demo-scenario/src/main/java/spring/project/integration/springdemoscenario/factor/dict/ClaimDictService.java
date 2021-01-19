package spring.project.integration.springdemoscenario.factor.dict;

import spring.project.integration.springdemoscenario.context.ClaimDict;
import spring.project.integration.springdemoscenario.context.ClaimFactorContext;

import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:35 2020/12/17
 */
public interface ClaimDictService {

    /**
     * get factor dictionaries
     *
     * @return
     */
    List<ClaimDict> getClaimFactorDictionaries();

    /**
     * get dict and fill value
     *
     * @param code
     * @param context
     * @return
     */
    ClaimDict getValue(String code, ClaimFactorContext context);

    /**
     * get value default
     *
     * @param code
     * @param context
     * @param defaultValue
     * @return
     */
    <T> ClaimDict getValue(String code, ClaimFactorContext context, T defaultValue);

    /**
     * get value or throw exception
     *
     * @param code
     * @param context
     * @return
     */
    ClaimDict getValueOrException(String code, ClaimFactorContext context);


}
