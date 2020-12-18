package spring.project.integration.springdemoapp.common.listener;

import com.google.common.collect.Lists;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.project.integration.springdemoapp.annotation.FactorCode;
import spring.project.integration.springdemoapp.factor.ClaimFactor;
import spring.project.integration.springdemoapp.util.ReflectUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:24 2020/12/17
 */
@Component
public class ClaimApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Map<String, ClaimFactor> map = event.getApplicationContext().getBeansOfType(ClaimFactor.class);
        List<String> list = Optional.ofNullable(map)
                .map(u -> u.values().stream()
                        .collect(Collectors.toList()))
                .map(v -> v.stream()
                        .map(x -> ReflectUtil.getAnnotaionValue(x.getClass(), FactorCode.class))
                        .collect(Collectors.toList()))
                .orElse(Lists.newArrayList());

        if (list.size() != new HashSet<String>(list).size()) {
            event.getApplicationContext().close();
        } else {
            list.forEach(System.out::println);
        }

    }
}
