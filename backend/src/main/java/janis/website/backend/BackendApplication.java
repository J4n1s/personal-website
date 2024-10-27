package janis.website.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The BackendApplication class serves as the entry point for the Spring Boot application.
 * It leverages the @SpringBootApplication annotation to enable component scanning,
 * autoconfiguration, and property support.
 *
 * <p>The @EnableAsync annotation is used to enable asynchronous method execution in the
 * application.
 */
@SpringBootApplication
@EnableAsync
public class BackendApplication {

  /**
   * The entry point of the Spring Boot application.
   *
   * @param args an array of command-line arguments passed to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

}
