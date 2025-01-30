package davidrodriguez.com.uniquora.features.users.domain;

import java.util.Date;

import davidrodriguez.com.uniquora.features.profilePhoto.domain.ProfilePhoto;
import davidrodriguez.com.uniquora.features.security.domain.PasswordHash;

public class User {
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

    public User() {}
    
}
