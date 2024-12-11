/**
 * The NorthwindTraderApiApplication class serves as the entry point for the Spring Boot application.
 * It initializes and runs the application by invoking the static `run` method of the SpringApplication class.
 * This class is annotated with `@SpringBootApplication`, which combines the functionalities of:
 * - `@Configuration`: Indicates that this class contains Spring configuration.
 * - `@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration mechanism.
 * - `@ComponentScan`: Scans the package and its subpackages for Spring components.
 */
package com.pluralsight.NorthwindTraderAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindTraderApiApplication {


	/**
	 * The main method is the entry point of the application.
	 * It uses SpringApplication.run to bootstrap the application and start the embedded server.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(NorthwindTraderApiApplication.class, args);
	}

}
