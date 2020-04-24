package spring.project.integration.springdemoapp.common.enums;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:20 2020/4/24
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result() {

    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    /**
     * 返回成功 无返回值
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 返回成功 有返回值
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 返回失败 无返回值
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 返回成功 有返回值
     * @param resultCode
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(ResultCode resultCode, T data) {
        Result<T> result = new Result<>();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    /**
     * todo 全局异常处理
     * @param errorResult
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(ErrorResult errorResult) {

        return null;
    }





}
