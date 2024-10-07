package janis.website.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ContactInformation(String name, String mail, String phone, String message) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.message = message;
    }
}
