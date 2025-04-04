package davidrodriguez.com.uniquora.features.product.shared.repositories;

import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultProductRepository extends JpaRepository<DefaultProductEntity, Long> {
}
