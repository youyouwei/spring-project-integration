package spring.project.integration.springdemoapp.util;

import org.springframework.core.annotation.AnnotationUtils;
import spring.project.integration.springdemoapp.annotation.FactorCode;

import java.util.Optional;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:13 2020/12/17
 */
@SuppressWarnings("unchecked")
public final class ReflectUtil {

    /**
     *
     * @param type
     * @param annotation
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T,V extends FactorCode> String getAnnotaionValue(Class<T> type, Class<V> annotation) {

        AnnotationUtils.getValue(type.getAnnotation(annotation), "value1");

        return Optional.ofNullable(type)
                .map(u -> Optional.ofNullable(u.getAnnotation(annotation))
                        .map(v -> v.value())
                        .orElse(null)
                )
                .orElse(null);
    }



}
