package davidrodriguez.com.uniquora.features.security.shared.dtos;

public class DefaultPasswordDTO {
    private Long id;
    private String password;

    public DefaultPasswordDTO() {
    }

    public DefaultPasswordDTO(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public DefaultPasswordDTO(String password) {
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

    public void setPassword(String password) {
        this.password = password;
    }
}
