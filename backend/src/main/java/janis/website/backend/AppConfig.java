package janis.website.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
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

    mailSender.setUsername(System.getenv("MAIL_USERNAME")); // Username from environment variable
    mailSender.setPassword(System.getenv("MAIL_PASSWORD")); // Password from environment variable

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "false");  // Disable for production, enable for debugging

    return mailSender;
  }

  /**
   * Configures and returns a SimpleMailMessage template for sending emails.
   * The method initializes the mail message with a default text and sender email address.
   *
   * @return a configured SimpleMailMessage instance.
   */
  @Bean
  public SimpleMailMessage templateSimpleMessage() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setText("This is the test email template for your email:\n%s\n");
    message.setFrom(System.getenv("MAIL_USERNAME"));
    return message;
  }
}
