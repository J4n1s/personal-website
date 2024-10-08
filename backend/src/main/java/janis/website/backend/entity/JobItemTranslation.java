package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "job_item_translation")
public class JobItemTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String language;  // ISO codes (e.g. "en", "de")

    @Column(nullable = false)
    private String employerName;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String jobDescription;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "job_item_id", nullable = false)
    private JobItem jobItem;

    public JobItemTranslation(String language, String employerName, String jobTitle, String jobDescription) {
        this.language = language;
        this.employerName = employerName;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }
}
