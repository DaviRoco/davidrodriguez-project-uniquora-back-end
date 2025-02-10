package davidrodriguez.com.uniquora.features.brand.shared.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class DefaultBrandDTO {
    private Long id;

    @NotBlank(message = "Brand name is required")
    @Size(min = 2, max = 50, message = "Brand name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Logo URL is required")
    @Size(min = 2, max = 50, message = "Logo URL must be between 2 and 50 characters")
    private String logo;

    private Date createdAt;
    private Date updatedAt;

    public DefaultBrandDTO() {
    }

    public DefaultBrandDTO(Long id, String name, String logo, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.logo = logo;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
