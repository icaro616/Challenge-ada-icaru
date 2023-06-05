package com.icarus.adaicarus;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SpringDoc {
	  @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("api")
	                .packagesToScan("com.icarus.adaicarus") // Substitua com o pacote onde estão seus controladores
	                .build();
	    }
}