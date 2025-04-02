package davidrodriguez.com.uniquora.features.cart_item.shared.dtos;

import java.util.Date;

public class DefaultCartItemDTO {
    private Long id;
    private Long cartsId;
    private Long productsId;
    private Integer quantity;
    private Date createdAt;
    private Date updatedAt;

    public DefaultCartItemDTO() {}

    public DefaultCartItemDTO(Long id, Long cartsId, Long productsId, Integer quantity, Date createdAt, Date updatedAt) {
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
