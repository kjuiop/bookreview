package com.bookreview.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.bookreview.core.model")
@ComponentScan({"com.bookreview.core.service","com.bookreview.core.components", "com.bookreview.core.security"})
@EnableJpaRepositories("com.bookreview.core.repository")
public class CoreConfiguration {
}
