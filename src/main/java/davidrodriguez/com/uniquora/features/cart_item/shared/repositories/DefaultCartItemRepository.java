package davidrodriguez.com.uniquora.features.cart_item.shared.repositories;

import davidrodriguez.com.uniquora.features.cart_item.shared.entities.DefaultCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultCartItemRepository extends JpaRepository<DefaultCartItemEntity, Long> {
}
