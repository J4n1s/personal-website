package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;


@ToString
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

    public EducationItem(Integer startingYear, Integer endingYear, String logoUrl) {
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.logoUrl = logoUrl;
    }

    public EducationItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Integer startingYear) {
        this.startingYear = startingYear;
    }

    public Integer getEndingYear() {
        return endingYear;
    }

    public void setEndingYear(Integer endingYear) {
        this.endingYear = endingYear;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String url) {
        this.logoUrl = url;
    }

    public List<EducationItemTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<EducationItemTranslation> translations) {
        this.translations = translations;
    }
}
