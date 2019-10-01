package com.vendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.vendas.controller" })
public class WebMvcConfig extends WebMvcConfigurationSupport  {
	@Bean
	public Docket productApi() {
	  return new Docket(DocumentationType.SWAGGER_2)
		  .select()
		  .apis(RequestHandlerSelectors.basePackage("com.vendas.controller"))
		  .build()
		  .apiInfo(metaData());
  
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
  
	private ApiInfo metaData() {
	  return new ApiInfoBuilder()
		  .title("API VENDAS")
		  .description("\"Spring Boot REST API for greeting people\"")
		  .version("1.0.0")
		  .license("Apache License Version 2.0")
		  .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
		  .build();
	}
  
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html**")
			.addResourceLocations("classpath:/resources/swagger-ui.html");
			
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
  
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
}