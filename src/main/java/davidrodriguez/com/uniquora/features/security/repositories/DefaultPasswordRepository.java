package davidrodriguez.com.uniquora.features.security.repositories;

import davidrodriguez.com.uniquora.features.security.entities.DefaultPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultPasswordRepository extends JpaRepository<DefaultPasswordEntity, Long> {
}
