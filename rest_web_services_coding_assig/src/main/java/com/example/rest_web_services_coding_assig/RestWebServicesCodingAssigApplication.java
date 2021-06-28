package com.example.rest_web_services_coding_assig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class RestWebServicesCodingAssigApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesCodingAssigApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.rest_web_services_coding_assig")).build();
	}
}

//http://127.0.0.1:8080/swagger-ui.html
