package davidrodriguez.com.uniquora.features.user.get_all_users.repositories;

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
public class GetAllUsersRepositoryTest {

    @Autowired
    private DefaultUserRepository defaultUserRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Test
    void shouldFindAllUsers() {
        Password mockPassword = new Password("test");
        passwordRepository.save(mockPassword);

        DefaultUserEntity mockDefaultUserEntity = new DefaultUserEntity("John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);
        defaultUserRepository.save(mockDefaultUserEntity);

        assertThat(defaultUserRepository.findAll()).hasSize(1);
        assertThat(defaultUserRepository.findAll().get(0).getId()).isEqualTo(mockDefaultUserEntity.getId());
        assertThat(defaultUserRepository.findAll().get(0).getName()).isEqualTo(mockDefaultUserEntity.getName());
        assertThat(defaultUserRepository.findAll().get(0).getLastName()).isEqualTo(mockDefaultUserEntity.getLastName());
        assertThat(defaultUserRepository.findAll().get(0).getEmail()).isEqualTo(mockDefaultUserEntity.getEmail());
        assertThat(defaultUserRepository.findAll().get(0).getPhoneNumber()).isEqualTo(mockDefaultUserEntity.getPhoneNumber());
        assertThat(defaultUserRepository.findAll().get(0).getLocation()).isEqualTo(mockDefaultUserEntity.getLocation());
        assertThat(defaultUserRepository.findAll().get(0).getRole()).isEqualTo(mockDefaultUserEntity.getRole());
        assertThat(defaultUserRepository.findAll().get(0).getPasswordHash().getClass()).isEqualTo(mockDefaultUserEntity.getPasswordHash().getClass());
    }
}
