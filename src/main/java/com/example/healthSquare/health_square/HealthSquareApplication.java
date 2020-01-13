package com.example.healthSquare.health_square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/*created by Hector Developers
06-08-2019
*/

@SpringBootApplication
@ContextConfiguration
@EnableJpaAuditing
public class HealthSquareApplication extends SpringBootServletInitializer {

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(HealthSquareApplication.class);
		}

public static void main(String[] args) {
		SpringApplication.run(HealthSquareApplication.class, args);
		}

}
