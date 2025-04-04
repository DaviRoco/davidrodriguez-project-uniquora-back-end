package davidrodriguez.com.uniquora.features.order.shared.repositories;

import davidrodriguez.com.uniquora.features.order.shared.entities.DefaultOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultOrderRepository extends JpaRepository<DefaultOrderEntity, Long> {
}
