package davidrodriguez.com.uniquora.features.security.shared.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "passwords", schema = "public")
public class DefaultPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    public DefaultPasswordEntity() {

    }

    public DefaultPasswordEntity(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String hashedPassword) {
        this.password = hashedPassword;
    }
}
