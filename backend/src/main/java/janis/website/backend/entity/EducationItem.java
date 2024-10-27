package janis.website.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


/**
 * Represents an educational item associated with a timeline, logo, and translations.
 * An instance of this class contains information about the start and end years of an
 * educational experience, as well as the URL to a logo representing the institution.
 * Additionally, each EducationItem can have multiple translations stored in the
 * associated EducationItemTranslation class.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "education_item")
public class EducationItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private Integer startingYear;

  @Column
  private Integer endingYear;

  @Column(nullable = false)
  private String logoUrl;

  @ToString.Exclude
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<EducationItemTranslation> translations;

  /**
   * Constructs a new instance of the EducationItem.
   *
   * @param startingYear the starting year of the educational experience
   * @param endingYear the ending year of the educational experience, or null if ongoing
   * @param logoUrl the URL to the logo representing the educational institution
   */
  public EducationItem(Integer startingYear, Integer endingYear, String logoUrl) {
    this.startingYear = startingYear;
    this.endingYear = endingYear;
    this.logoUrl = logoUrl;
  }
}
