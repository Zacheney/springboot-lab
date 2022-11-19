package cn.zach.springsecurity.config;

import cn.zach.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author Zach
 * @date 2022/9/29 15:26
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private CustAccessDecisionManager custAccessDecisionManager;
    @Autowired
    private CustFilterInvocationSecurityMetadataSource custFilterInvocationSecurityMetadataSource;

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/hello").hasRole("admin")
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login") // POST登录请求路径
//                .successHandler((req,resp,authentication)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    resp.getWriter().write("success");
//                })
//                .failureHandler((req,resp,exception)->{
//                    resp.setContentType("application/json;charset=utf-8");
//                    resp.getWriter().write("fail");
//                })
//                .and()
//                .csrf().disable();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(custAccessDecisionManager);
                        object.setSecurityMetadataSource(custFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .loginProcessingUrl("/login") // POST登录请求路径
                .permitAll()
                .and()
                .csrf().disable();
    }
}
