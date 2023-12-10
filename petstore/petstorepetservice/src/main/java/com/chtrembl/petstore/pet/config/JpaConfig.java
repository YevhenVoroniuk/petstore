package com.chtrembl.petstore.pet.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Yevhen_Voroniuk
 */
@Configuration
@EntityScan("com.chtrembl.petstore.pet.model")
@EnableJpaRepositories(basePackages = "com.chtrembl.petstore.pet.repo")
public class JpaConfig {
}
