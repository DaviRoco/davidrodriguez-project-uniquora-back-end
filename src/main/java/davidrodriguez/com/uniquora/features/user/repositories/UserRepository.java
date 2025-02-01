package davidrodriguez.com.uniquora.features.user.repositories;

import davidrodriguez.com.uniquora.features.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
