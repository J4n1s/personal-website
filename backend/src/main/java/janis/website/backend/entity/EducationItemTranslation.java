package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


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

    public EducationItemTranslation(String language, String schoolName, String schoolNameAbbreviation, String studyTitle, String description) {
        this.language = language;
        this.schoolName = schoolName;
        this.schoolNameAbbreviation = schoolNameAbbreviation;
        this.studyTitle = studyTitle;
        this.description = description;
    }
}
