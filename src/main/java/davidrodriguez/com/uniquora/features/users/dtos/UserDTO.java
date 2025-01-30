package davidrodriguez.com.uniquora.features.users.dtos;

import davidrodriguez.com.uniquora.features.profilePhoto.domain.ProfilePhoto;
import davidrodriguez.com.uniquora.features.security.domain.PasswordHash;
import davidrodriguez.com.uniquora.features.users.domain.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location;
    private Role role;
    private Date createdAt;
    private Date updatedAt;
    private ProfilePhoto profilePhoto;
    private PasswordHash passwordHash;
}
