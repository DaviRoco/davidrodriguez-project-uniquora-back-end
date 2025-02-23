package davidrodriguez.com.uniquora.features.brand.get_brand_by_id.repository;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GetBrandByIdRepository extends JpaRepository<DefaultBrandEntity, Long> {
    Optional<DefaultBrandEntity> findBrandById(Long id);
}
