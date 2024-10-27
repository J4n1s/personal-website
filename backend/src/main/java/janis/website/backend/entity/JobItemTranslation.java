package janis.website.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a translation of a job item into a specific language.
 * This entity contains details about the job in a particular language.
 * It includes fields for the language, employer name, job title,
 * and a job description. Each translation is associated with a specific
 * job item.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "job_item_translation")
public class JobItemTranslation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String language;

  @Column(nullable = false)
  private String employerName;

  @Column(nullable = false)
  private String jobTitle;

  @Column(nullable = false, length = 500)
  private String jobDescription;

  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "job_item_id", nullable = false)
  private JobItem jobItem;

  /**
   * Constructs a new JobItemTranslation with the specified details.
   *
   * @param language the language of the translation.
   * @param employerName the name of the employer in this translation.
   * @param jobTitle the job title in this translation.
   * @param jobDescription the job description in this translation.
   */
  public JobItemTranslation(String language, String employerName, String jobTitle,
                            String jobDescription) {
    this.language = language;
    this.employerName = employerName;
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
  }
}
