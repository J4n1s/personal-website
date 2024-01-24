package janis.website.backend.entity;

import jakarta.persistence.*;

import java.util.Objects;

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

    public ContactInformation() {
    }

    public ContactInformation(String name, String mail, String phone, String message) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContactInformation other)) {
            return false;
        }
        return Objects.equals(other.id, this.id) && Objects.equals(other.name, this.name)
                && Objects.equals(other.mail, this.mail) && Objects.equals(other.phone, this.phone)
                && Objects.equals(other.message, this.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.mail, this.phone, this.message);
    }

    @Override
    public String toString() {
        return "ContactInformation{" + "id=" + this.id + ", name='" + this.name + '\'' + ", mail='" + this.mail + '\''
                + '\'' + ", phone='" + this.phone + '\''+ '\'' + ", message='" + this.message + '\''+ '}';
    }
}
