package davidrodriguez.com.uniquora.features.security.shared.repositories;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultPasswordRepository extends JpaRepository<DefaultPasswordEntity, Long> {
}
