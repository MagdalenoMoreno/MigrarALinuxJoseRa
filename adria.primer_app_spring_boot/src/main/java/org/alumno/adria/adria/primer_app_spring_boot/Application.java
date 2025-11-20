package org.alumno.adria.adria.primer_app_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="org.alumno.adria")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
