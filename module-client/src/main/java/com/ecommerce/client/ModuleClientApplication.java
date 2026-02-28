package com.ecommerce.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EntityScan(basePackages = {
    "com.ecommerce.common.entity",
    "com.ecommerce.member.entity",
    "com.ecommerce.product.entity"
})
@SpringBootApplication(scanBasePackages = "com.ecommerce")
public class ModuleClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleClientApplication.class, args);
    }

}
