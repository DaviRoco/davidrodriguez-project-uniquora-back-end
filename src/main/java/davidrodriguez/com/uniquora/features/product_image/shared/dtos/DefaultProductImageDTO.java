package davidrodriguez.com.uniquora.features.product_image.shared.dtos;

public class DefaultProductImageDTO {
    private Long id;
    private String imageUrl;

    public DefaultProductImageDTO() {
    }

    public DefaultProductImageDTO(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
