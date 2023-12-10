package com.chtrembl.petstore.product.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Yevhen_Voroniuk
 */
@Configuration
@EntityScan("com.chtrembl.petstore.product.model")
@EnableJpaRepositories(basePackages = "com.chtrembl.petstore.product.repo")
public class JpaConfig {
}
