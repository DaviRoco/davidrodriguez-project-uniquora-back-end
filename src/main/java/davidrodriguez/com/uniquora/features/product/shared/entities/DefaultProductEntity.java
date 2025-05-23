package davidrodriguez.com.uniquora.features.product.shared.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "products", schema = "public")
public class DefaultProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @OneToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private DefaultBrandEntity brand;

    @ManyToMany
    @JoinTable(
            name = "product_images_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "product_images_id")
    )
    private List<DefaultProductImageEntity> productImages = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    private List<DefaultCategoryEntity> categories = new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public DefaultProductEntity() {
    }

    public DefaultProductEntity(Long id, String name, String description, Double price, Integer stockQuantity, DefaultBrandEntity brand, List<DefaultProductImageEntity> productImages, List<DefaultCategoryEntity> categories, Date createdAt, Date updatedAt) {
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

    public DefaultBrandEntity getBrand() {
        return brand;
    }

    public void setBrand(DefaultBrandEntity brand) {
        this.brand = brand;
    }

    public List<DefaultProductImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<DefaultProductImageEntity> productImages) {
        this.productImages = productImages;
    }

    public List<DefaultCategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<DefaultCategoryEntity> categories) {
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
