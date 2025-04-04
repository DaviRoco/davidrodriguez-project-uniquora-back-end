package davidrodriguez.com.uniquora.features.brand.shared.repositories;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultBrandRepository extends JpaRepository<DefaultBrandEntity, Long> {
}
