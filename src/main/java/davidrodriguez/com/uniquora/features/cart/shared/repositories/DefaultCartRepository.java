package davidrodriguez.com.uniquora.features.cart.shared.repositories;

import davidrodriguez.com.uniquora.features.cart.shared.entities.DefaultCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultCartRepository extends JpaRepository<DefaultCartEntity, Long> {
}
