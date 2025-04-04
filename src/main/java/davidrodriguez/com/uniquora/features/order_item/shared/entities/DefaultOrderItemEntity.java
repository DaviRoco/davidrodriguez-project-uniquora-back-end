package davidrodriguez.com.uniquora.features.order_item.shared.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order_items", schema = "public")
public class DefaultOrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orders_id")
    private Long orderId;

    @Column(name = "products_id")
    private Long productId;

    @Column(name = "quantity")
    private Integer quantity;

    public DefaultOrderItemEntity() {
    }

    public DefaultOrderItemEntity(Long id, Long orderId, Long productId, Integer quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
