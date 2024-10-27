package janis.website.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing contact information submitted via a form or service.
 */
@Data
@NoArgsConstructor
@Entity
public class ContactInformation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String mail;

  @Column
  private String phone;

  @Column(nullable = false, length = 5000)
  private String message;

  /**
   * Constructs a new ContactInformation instance with the specified details.
   *
   * @param name the name of the contact person
   * @param mail the email address of the contact person
   * @param phone the phone number of the contact person
   * @param message the message submitted by the contact person
   */
  public ContactInformation(String name, String mail, String phone, String message) {
    this.name = name;
    this.mail = mail;
    this.phone = phone;
    this.message = message;
  }
}
