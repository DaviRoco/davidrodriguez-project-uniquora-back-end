package davidrodriguez.com.uniquora.features.user.shared.dtos;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.enumerations.Role;
import lombok.Data;

import java.util.Date;
@SuppressWarnings("unused")
@Data
public class DefaultUserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location;
    private Role role;
    private DefaultPasswordDTO password;
    private Date createdAt;
    private Date updatedAt;

    public DefaultUserDTO() {
    }

    public DefaultUserDTO(Long id, String name, String lastName, String email, String phoneNumber, String location, Role role, DefaultPasswordDTO password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public DefaultPasswordDTO getPassword() {
        return password;
    }

    public void setPassword(DefaultPasswordDTO password) {
        this.password = password;
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
}
