package com.unexus.invoice;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
              .group("springshop-public")
              .packagesToScan("com.unexus")
              .build();
    }
          

}
