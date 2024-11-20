package davidrodriguez.com.uniquora.core.domain;

public class PasswordHash {
    private Long passwordHashId;
    private String password;
    private String salt;

    public PasswordHash(Long passwordHashId, String password, String salt) {
        this.passwordHashId = passwordHashId;
        this.password = password;
        this.salt = salt;
    }

    public Long getPasswordHashId() {
        return passwordHashId;
    }

    public void setPasswordHashId(Long passwordHashId) {
        this.passwordHashId = passwordHashId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
