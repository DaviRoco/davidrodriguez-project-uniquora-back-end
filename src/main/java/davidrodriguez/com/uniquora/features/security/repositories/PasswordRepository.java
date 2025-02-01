package davidrodriguez.com.uniquora.features.security.repositories;

import davidrodriguez.com.uniquora.features.security.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
