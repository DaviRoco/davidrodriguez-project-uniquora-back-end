package davidrodriguez.com.uniquora.features.category.shared.repositories;

import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultCategoryRepository extends JpaRepository<DefaultCategoryEntity, Long> {
}
