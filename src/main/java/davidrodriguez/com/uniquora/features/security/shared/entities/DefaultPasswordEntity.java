package davidrodriguez.com.uniquora.features.security.shared.entities;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public DefaultPasswordEntity(long id, String password) {
        this.id = id;
        this.password = hashPassword(password);
    }

    public DefaultPasswordEntity(String password) {
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

    public void setPassword(String plainPassword) {
        this.password = hashPassword(plainPassword);
    }

    private String hashPassword(String plainPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(plainPassword);
    }

    public boolean matches(String plainPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(plainPassword, this.password);
    }
}
