package davidrodriguez.com.uniquora.features.user.get_user_by_email.repositories;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.features.security.repositories.PasswordRepository;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.repositories.DefaultUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class GetUserByEmailRepositoryTest {
    @Autowired
    private DefaultUserRepository defaultUserRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Test
    void shouldFindUserByEmail() {
        String mockEmail = "test@email.com";

        Password mockPassword = new Password("test");
        passwordRepository.save(mockPassword);
        passwordRepository.flush();

        DefaultUserEntity mockDefaultUserEntity = new DefaultUserEntity("John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);
        defaultUserRepository.save(mockDefaultUserEntity);
        defaultUserRepository.flush();

        DefaultUserEntity foundUser = defaultUserRepository.findByEmail(mockEmail)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + mockEmail));

        assertThat(foundUser.getId()).isEqualTo(mockDefaultUserEntity.getId());
        assertThat(foundUser.getName()).isEqualTo(mockDefaultUserEntity.getName());
        assertThat(foundUser.getLastName()).isEqualTo(mockDefaultUserEntity.getLastName());
        assertThat(foundUser.getEmail()).isEqualTo(mockDefaultUserEntity.getEmail());
        assertThat(foundUser.getPhoneNumber()).isEqualTo(mockDefaultUserEntity.getPhoneNumber());
        assertThat(foundUser.getLocation()).isEqualTo(mockDefaultUserEntity.getLocation());
        assertThat(foundUser.getRole()).isEqualTo(mockDefaultUserEntity.getRole());
        assertThat(foundUser.getPasswordHash().getClass()).isEqualTo(mockDefaultUserEntity.getPasswordHash().getClass());
    }
}
