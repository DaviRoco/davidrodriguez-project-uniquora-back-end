package davidrodriguez.com.uniquora.features.product_image.shared.repositories;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultProductImageRepository extends JpaRepository<DefaultProductImageEntity, Long> {
}
