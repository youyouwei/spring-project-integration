package spring.project.integration.springdemoapp.context;

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

}
