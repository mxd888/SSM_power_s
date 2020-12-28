package com.hdu.mxd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDatailsService;

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDatailsService).passwordEncoder(password());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.logout()
                // 触发注销操作
                .logoutUrl("/loginOut")
                // 注销成功跳转页面
                .logoutSuccessUrl("/")
                .deleteCookies("remember-me")
                // 指定是否在注销之后让Session失效
                .invalidateHttpSession(true);
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.headers().frameOptions().disable();
        http.formLogin()

//                .loginPage("/login.html")
//                .loginProcessingUrl("/userLogin") //请求路径
                .defaultSuccessUrl("/mxd/index").permitAll()  //登陆成功跳转页面
                .and().authorizeRequests()
//                      .antMatchers("/hello","/mxd/hello","/mxd/index").hasAnyAuthority("admin,user,admins")  //不拦截的请求
//                      .antMatchers("/hello","/mxd/hello","/mxd/index").hasAuthority("admin")  //不拦截的请求
//                    .antMatchers("/hello","/mxd/hello").permitAll()  //不拦截的请求
                .antMatchers("/hello","/mxd/index").hasAnyRole("admin,user")  //拦截的请求
                .antMatchers("/hello","/mxd/hello").hasAnyRole("user,admin")
                .antMatchers("/hello","/mxd/update").hasAnyRole("user,admin")
                .antMatchers("/admin","/mxd/update").hasAnyRole("admin")
                .anyRequest().authenticated()
                // 开启记住我
                .and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600)
                .userDetailsService(userDatailsService)

                .and().csrf().disable();  //关闭scrf
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 建表语句   开启一次即可
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }


}
