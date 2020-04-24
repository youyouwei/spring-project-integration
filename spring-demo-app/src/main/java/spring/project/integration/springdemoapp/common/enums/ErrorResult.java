package spring.project.integration.springdemoapp.common.enums;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:57 2020/4/24
 */
public enum ErrorResult {
    ERROR(1, "ERROR");

    private Integer code;
    private String message;

    ErrorResult(Integer code, String message) {
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
