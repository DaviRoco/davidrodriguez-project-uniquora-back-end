package davidrodriguez.com.uniquora.features.cart_item.shared.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cart_items", schema = "public")
public class DefaultCartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carts_id", nullable = false)
    private Long cartsId;

    @Column(name = "products_id", nullable = false)
    private Long productsId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public DefaultCartItemEntity() {}

    public DefaultCartItemEntity(Long id, Long cartsId, Long productsId, Integer quantity, Date createdAt, Date updatedAt) {
        this.id = id;
        this.cartsId = cartsId;
        this.productsId = productsId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartsId() {
        return cartsId;
    }

    public void setCartsId(Long cartsId) {
        this.cartsId = cartsId;
    }

    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
