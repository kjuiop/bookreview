package com.bookreview.admin.console;

import com.bookreview.core.CoreConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(CoreConfiguration.class)
public class WebAdminConsoleApplication extends SpringBootServletInitializer {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebAdminConsoleApplication.class);
    }

    public static void main(String[] args) { SpringApplication.run(WebAdminConsoleApplication.class, args); }

    @PostConstruct
    public void setUp() { objectMapper.registerModule(new JavaTimeModule()); }
}
