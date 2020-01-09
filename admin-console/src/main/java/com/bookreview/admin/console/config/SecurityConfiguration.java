package com.bookreview.admin.console.config;

import com.bookreview.core.security.AbstractSecurityConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/modules/**", "/js/**", "/css/**", "img/**", "/fonts/**", "/healthcheck.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        log.info("SecurityConfiguration Admin HttpSecurity !");
//        http
//                .csrf().ignoringAntMatchers("/h2-console/**")
//                .and()
//                .headers().frameOptions().sameOrigin();
//
//        http.authorizeRequests()
//                .anyRequest().authenticated();


    }


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        log.info("SecurityConfiguration Admin HttpSecurity !");
//        http
//                .csrf().ignoringAntMatchers("/h2-console/**")
//                .and()
//                .headers().frameOptions().sameOrigin();
//
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }
}
