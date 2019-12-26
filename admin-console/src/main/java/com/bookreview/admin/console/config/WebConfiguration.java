package com.bookreview.admin.console.config;

import com.bookreview.core.components.CommonInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfiguration implements ApplicationContextAware, WebMvcConfigurer {

    private ApplicationContext applicationContext;


    @Bean
    public CommonInterceptor commonInterceptor() {
        CommonInterceptor commonInterceptor = new CommonInterceptor();

        return commonInterceptor;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
