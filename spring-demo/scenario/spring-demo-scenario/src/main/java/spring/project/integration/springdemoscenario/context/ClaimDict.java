/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package spring.project.integration.springdemoscenario.context;

import lombok.Builder;
import lombok.Getter;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2020/12/17
 */
@Getter
@Builder
public class ClaimDict<T> {

    /**
     * dict code
     */
    private String code;

    /**
     * dict value
     */
    private T value;

    /**
     * dict i18n
     */
    private String desc;


    /**
     * fill value
     * @param value
     * @return
     */
    public ClaimDict fillValue(T value) {
        this.value = value;
        return this;
    }

}
