package davidrodriguez.com.uniquora.features.user.get_user_by_email.repositories;

import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GetUserByEmailRepository extends JpaRepository<DefaultUserEntity, Long> {
    Optional<DefaultUserEntity> findByEmail(String email);
}
