package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Objects;


@ToString
@Entity
public class EducationItemTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String language;  // ISO codes (e.g. "en", "de")

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = false)
    private String schoolNameAbbreviation;

    @Column(nullable = false)
    private String studyTitle;

    @Column(nullable = false, length = 500)
    private String description;

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

    public EducationItemTranslation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolNameAbbreviation() {
        return schoolNameAbbreviation;
    }

    public void setSchoolNameAbbreviation(String schoolNameAbbreviation) {
        this.schoolNameAbbreviation = schoolNameAbbreviation;
    }

    public String getStudyTitle() {
        return studyTitle;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EducationItem getEducationItem() {
        return educationItem;
    }

    public void setEducationItem(EducationItem educationItem) {
        this.educationItem = educationItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationItemTranslation that = (EducationItemTranslation) o;
        return id == that.id && Objects.equals(language, that.language) && Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(schoolNameAbbreviation, that.schoolNameAbbreviation) &&
                Objects.equals(studyTitle, that.studyTitle) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, schoolName, schoolNameAbbreviation, studyTitle, description);
    }
}
