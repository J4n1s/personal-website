package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


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

    public EducationItem(Integer startingYear, Integer endingYear, String logoUrl) {
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.logoUrl = logoUrl;
    }
}
