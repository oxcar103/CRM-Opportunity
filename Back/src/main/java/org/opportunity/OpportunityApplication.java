package org.opportunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OpportunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpportunityApplication.class, args);
	}

}
