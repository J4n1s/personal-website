package janis.website.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Configuration class for setting up email-related beans.
 *
 * <p>This class contains the configuration for JavaMailSender and SimpleMailMessage
 * which are used for sending emails through the application. Environment variables
 * are used to configure email credentials and other properties.
 */
@Configuration
public class AppConfig {

  private static final String MAIL_USERNAME = System.getenv("MAIL_USERNAME");
  private static final String MAIL_PASSWORD = System.getenv("MAIL_PASSWORD");
  public static final String MAIL_FROM = System.getenv("MAIL_FROM");

  /**
   * Configures and returns a JavaMailSender bean that can be used to send emails.
   * The method initializes the mail sender with SMTP server settings, authentication,
   * and other mail properties using environment variables for the username and password.
   *
   * @return a configured JavaMailSender instance.
   */
  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername(MAIL_USERNAME); // Username from environment variable
    mailSender.setPassword(MAIL_PASSWORD); // Password from environment variable

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "false");  // Disable for production, enable for debugging

    return mailSender;
  }
}
