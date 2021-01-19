package spring.project.integration.springdemoscenario.factor.dict;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.Asserts;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import spring.project.integration.springdemoscenario.annotation.FactorCode;
import spring.project.integration.springdemoscenario.context.ClaimDict;
import spring.project.integration.springdemoscenario.context.ClaimFactorContext;
import spring.project.integration.springdemoscenario.factor.ClaimFactor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:45 2020/12/17
 */
@Component
@Slf4j
public class ClaimDictServiceImpl implements ClaimDictService {

    private final Map<String, ClaimFactor> factorMap;

    private final List<ClaimDict> dictList;

    /**
     * check factor repeat
     * init factor map
     * init dict list
     */
    public ClaimDictServiceImpl(List<ClaimFactor> list) {
        list = list.stream()
                .filter(v -> StringUtils.isNotBlank((String) AnnotationUtils.getValue(v.getClass().getAnnotation(FactorCode.class))))
                .collect(Collectors.toList());
        this.factorMap = list.stream()
                .collect(Collectors.toMap(k -> AnnotationUtils.getValue(k.getClass().getAnnotation(FactorCode.class)).toString()
                        , Function.identity()
                        , (x, y) -> {
                            throw new RuntimeException("Error caught factor code value is repeat");
                        }));
        this.dictList = list.stream().map(u -> u.getFactorDict()).collect(Collectors.toList());
        log.info("Factor Dictionary list {} ", dictList);
        log.info("Factor Code map {}", factorMap);
    }


    @Override
    public List<ClaimDict> getClaimFactorDictionaries() {
        return dictList;
    }

    @Override
    public ClaimDict getValue(String code, ClaimFactorContext context) {
        Asserts.notNull(code, "code");
        Asserts.notNull(context, "context");
        return Optional.ofNullable(factorMap.get(code))
                .map(u -> u.resolve(context))
                .orElseGet(ClaimDict.builder()::build);
    }

    @Override
    public ClaimDict getValueOrException(String code, ClaimFactorContext context) {
        return Optional.ofNullable(getValue(code, context))
                .filter(u -> Objects.nonNull(u.getValue()))
                .orElseThrow(() -> new RuntimeException("Error caught factor value is null"));
    }

    @Override
    public <T> ClaimDict getValue(String code, ClaimFactorContext context, T defaultValue) {
        ClaimDict dict = getValue(code, context);
        if (Objects.isNull(dict.getValue())) {
            dict.fillValue(defaultValue);
        }
        return dict;
    }


}
