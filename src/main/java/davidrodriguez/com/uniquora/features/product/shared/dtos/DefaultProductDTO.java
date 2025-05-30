package davidrodriguez.com.uniquora.features.product.shared.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;

import java.util.Date;
import java.util.List;

public class DefaultProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private DefaultBrandDTO brand;
    private List<DefaultProductImageDTO> productImages;
    private List<DefaultCategoryDTO> categories;
    private Date createdAt;
    private Date updatedAt;

    public DefaultProductDTO() {
    }

    public DefaultProductDTO(Long id, String name, String description, Double price, Integer stockQuantity, DefaultBrandDTO brand, List<DefaultProductImageDTO> productImages, List<DefaultCategoryDTO> categories, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
        this.productImages = productImages;
        this.categories = categories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public DefaultBrandDTO getBrand() {
        return brand;
    }

    public void setBrand(DefaultBrandDTO brand) {
        this.brand = brand;
    }

    public List<DefaultProductImageDTO> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<DefaultProductImageDTO> productImages) {
        this.productImages = productImages;
    }

    public List<DefaultCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<DefaultCategoryDTO> categories) {
        this.categories = categories;
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
