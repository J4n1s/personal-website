package janis.website.backend.controller.dto;

import lombok.Data;

@Data
public class EmailDto {
    private String recipient;
    private String subject;
    private String content;
    private String[] cc;   // Optional, can be multiple CC recipients
    private String[] bcc;  // Optional, can be multiple BCC recipients
    private boolean isHtml; // Indicates if the content should be sent as HTML

    public EmailDto(String recipient, String subject, String content) {
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
        this.isHtml = false; // Default to plain text
    }

}
