package janis.website.backend.controller.dto;

import lombok.Data;


/**
 * Data Transfer Object representing the structure of an email.
 * This includes the recipient, subject, content, optional CC and BCC recipients,
 * and an indicator of whether the email content is in HTML format.
 */
@Data
public class EmailDto {
  private String recipient;
  private String subject;
  private String content;
  private String[] cc;   // Optional, can be multiple CC recipients
  private String[] bcc;  // Optional, can be multiple BCC recipients
  private boolean isHtml; // Indicates if the content should be sent as HTML


  /**
   * Constructs an instance of EmailDto with the specified recipient, subject, and content.
   * The content type is set to plain text by default.
   *
   * @param recipient the email address of the recipient
   * @param subject   the subject of the email
   * @param content   the content/body of the email
   */
  public EmailDto(String recipient, String subject, String content) {
    this.recipient = recipient;
    this.subject = subject;
    this.content = content;
    this.isHtml = false; // Default to plain text
  }

}
