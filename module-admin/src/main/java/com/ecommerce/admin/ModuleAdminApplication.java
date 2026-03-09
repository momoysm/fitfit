package com.ecommerce.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.ecommerce")
@EnableJpaRepositories(basePackages = "com.ecommerce")
@SpringBootApplication(scanBasePackages = "com.ecommerce")
public class ModuleAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleAdminApplication.class, args);
    }

}
