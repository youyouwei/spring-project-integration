package spring.project.integration.springdemoapp.common.exception;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:46 2020/11/12
 */
public class BusinessException extends RuntimeException {

    private String code;

    private String message;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getDesc());
        this.code = businessExceptionEnum.getCode();
        this.message = businessExceptionEnum.getDesc();
    }

}
