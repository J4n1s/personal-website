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
 * Represents a job item entity with details about a job position,
 * including the starting and ending year, logo URL, and a list of
 * translations for different languages.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "job_item")
public class JobItem {

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
  private List<JobItemTranslation> translations;

  /**
   * Constructs a new JobItem instance with specified starting year, ending year and logo URL.
   *
   * @param startingYear the year when the job started
   * @param endingYear the year when the job ended; can be null if the job is ongoing
   * @param logoUrl the URL of the company's logo
   */
  public JobItem(Integer startingYear, Integer endingYear, String logoUrl) {
    this.startingYear = startingYear;
    this.endingYear = endingYear;
    this.logoUrl = logoUrl;
  }
}
