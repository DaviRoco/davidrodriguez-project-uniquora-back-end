package davidrodriguez.com.uniquora.features.order_item.shared.repositories;

import davidrodriguez.com.uniquora.features.order_item.shared.entities.DefaultOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultOrderItemRepository extends JpaRepository<DefaultOrderItemEntity, Long> {
}
