package davidrodriguez.com.uniquora.features.user.dtos;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.user.domain.Role;
import lombok.Data;

import java.util.Date;
@SuppressWarnings("unused")
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location;
    private Role role;
    private Date createdAt;
    private Date updatedAt;
    private Password password;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastName, String email, String phoneNumber, String location) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
