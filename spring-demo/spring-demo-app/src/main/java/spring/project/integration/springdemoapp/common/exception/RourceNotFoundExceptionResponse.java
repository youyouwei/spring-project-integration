package spring.project.integration.springdemoapp.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:39 2020/11/25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RourceNotFoundExceptionResponse {

    public static final int STATUS_CODE = 404;

    public static final String MESSAGE = "Resource not found";

    private String message;
    private String resourceType;
    private String resourceId;


}
