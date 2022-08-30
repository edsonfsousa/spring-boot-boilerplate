package com.springboot.boilerplate.springbootboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootBoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBoilerplateApplication.class, args);
    }

}
