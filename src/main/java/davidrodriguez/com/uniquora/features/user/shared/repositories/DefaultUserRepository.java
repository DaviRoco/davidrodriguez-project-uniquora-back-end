package davidrodriguez.com.uniquora.features.user.shared.repositories;

import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DefaultUserRepository extends JpaRepository<DefaultUserEntity, Long> {
    Optional<DefaultUserEntity> findByEmail(String email);
}
