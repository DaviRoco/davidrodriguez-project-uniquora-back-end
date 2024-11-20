package davidrodriguez.com.uniquora.core.domain;

public class ProfilePhoto {
    private Long profilePhotoId;
    private String profilePhotoUrl;
    private User user;

    public ProfilePhoto(Long profilePhotoId, String profilePhotoUrl, User user) {
        this.profilePhotoId = profilePhotoId;
        this.profilePhotoUrl = profilePhotoUrl;
        this.user = user;
    }

    public Long getProfilePhotoId() {
        return profilePhotoId;
    }

    public void setProfilePhotoId(Long profilePhotoId) {
        this.profilePhotoId = profilePhotoId;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
