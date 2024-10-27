package janis.website.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Represents a translation of an educational item, including details about the
 * language, school, study, and description in a particular language.
 * Each instance of this class is associated with a specific EducationItem.
 */
@Data
@NoArgsConstructor
@Entity
public class EducationItemTranslation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String language;

  @Column(nullable = false)
  private String schoolName;

  @Column(nullable = false)
  private String schoolNameAbbreviation;

  @Column(nullable = false)
  private String studyTitle;

  @Column(nullable = false, length = 500)
  private String description;

  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "education_item_id", nullable = false)
  private EducationItem educationItem;

  /**
   * Constructs a new EducationItemTranslation.
   *
   * @param language the language of the translation
   * @param schoolName the name of the school in the target language
   * @param schoolNameAbbreviation the abbreviated name of the school in the target language
   * @param studyTitle the title of the study in the target language
   * @param description the description of the education item in the target language
   */
  public EducationItemTranslation(String language, String schoolName, String schoolNameAbbreviation, String studyTitle, String description) {
    this.language = language;
    this.schoolName = schoolName;
    this.schoolNameAbbreviation = schoolNameAbbreviation;
    this.studyTitle = studyTitle;
    this.description = description;
  }
}
