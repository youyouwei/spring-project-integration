package spring.project.integration.springdemoapp.common.enums;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:06 2020/4/24
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "SUCCESS"),
    /* 参数错误：1001-1999 */
    PARAM_IS_INVALID(1001, "PARAM IS INVALID"),
    PARAM_IS_BLANK(1002, "PARAM IS BLANK"),
    PARAM_TYPE_BIND_ERROR(1003, "PARAM TYPE BIND ERROR"),
    PARAM_NOT_COMPLETE(1004, "PARAM NOT COMPLETE"),
    /* 用户错误：2001-2999 */
    USER_NOT_LOGGED_IN(2001, "USER NOT LOGGED IN"),
    USER_LOGIN_ERROR(2002, "USER LOGIN ERROR"),
    USER_ACCOUNT_FORBIDDEN(2003, "USER ACCOUNT FORBIDDEN"),
    USER_NOT_EXIST(2004, "USER NOT EXIST"),
    USER_HAS_EXISTED(2005, "USER HAS EXISTED")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }



}
