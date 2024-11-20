package davidrodriguez.com.uniquora.core.domain;

import java.util.Date;

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
