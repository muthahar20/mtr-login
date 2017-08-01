package com.bgip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
//				.apiInfo(apiInfo()).select().paths(postPaths()).build();
//	}
	
	@Bean
	public Docket postApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.bgip.controller"))
				.paths(regex("/bgip.*")).build();
	}

//	private Predicate<String> postPaths() {
//		return or(regex("/bgip/register"), regex("/bgip/hello"));
//	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("BGIP API")
				.description("Big Data In Pocket")
				.termsOfServiceUrl("http://javainuse.com")
				.contact("javainuse@gmail.com").license("Muthahar Shaik License")
				.licenseUrl("javainuse@gmail.com").version("1.0")
				.build();
	}

}
