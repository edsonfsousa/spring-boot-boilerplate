package com.springboot.boilerplate.springbootboilerplate.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.springboot.boilerplate.springbootboilerplate.utils.ProjectConstants.PROJECT_BASE_PACKAGE;

@Configuration
@PropertySource(value = "classpath:swagger-info-config.properties")
public class SwaggerConfig {

    @Value("${swagger.app-info.name}")
    private String appName;

    @Value("${swagger.app-info.description}")
    private String appDescription;

    @Value("${swagger.app-info.version}")
    private String appVersion;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactEmail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage(PROJECT_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .build();
    }
}
