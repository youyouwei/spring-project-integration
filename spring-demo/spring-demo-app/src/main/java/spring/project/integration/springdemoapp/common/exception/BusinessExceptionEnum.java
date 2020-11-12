package spring.project.integration.springdemoapp.common.exception;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:56 2020/11/12
 */
public enum  BusinessExceptionEnum {
    PARAM_IS_NULL("A00001", "param is null");

    private String code;

    private String desc;

    BusinessExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public BusinessExceptionEnum getByCode(String code) {
        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if ( exceptionEnum.getCode().equals(code)) {
                return exceptionEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
