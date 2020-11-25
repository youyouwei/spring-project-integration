package spring.project.integration.springdemoapp.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: Spring security config
 * @Author: jiahuiyang
 * @Date: Created in 14:44 2020/11/23
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_BASIC_AUTH = "BASIC_AUTH";

    @Value("${basicAuth-userName:root}")
    private String basicAuthUserName;

    @Value("${basicAuth-password:11111}")
    private String basicAuthPassword;

    @Value("${security.basic.enabled:true}")
    private boolean enableSecurity;

    @Value("#{'${security.basic.paths:/**}'.split(',')}")
    private List<String> basicAuthPaths;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 针对需要拦截的接口
        if (enableSecurity && !CollectionUtils.isEmpty(basicAuthPaths) && !"".equals(basicAuthPaths.get(0).trim())) {
            http
                    .authorizeRequests()
                    .antMatchers(basicAuthPaths.toArray(new String[0])).authenticated()
                    .and()
                    .httpBasic();
        }

        // 其它所有不拦截
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll();

        http.csrf().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        String encodedPassword = passwordEncoder().encode(basicAuthPassword);

        manager.createUser(User.withUsername(basicAuthUserName).password(encodedPassword).roles(ROLE_BASIC_AUTH).build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }






}
