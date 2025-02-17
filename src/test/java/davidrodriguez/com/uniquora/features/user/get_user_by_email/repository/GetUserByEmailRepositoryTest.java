package davidrodriguez.com.uniquora.features.user.get_user_by_email.repository;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.features.security.shared.repositories.DefaultPasswordRepository;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.repositories.DefaultUserRepository;
import davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity;
import davidrodriguez.com.uniquora.mockEntities.user.entities.MockUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@org.junit.jupiter.api.Disabled("Fails with JaCoCo, investigate persistence issues")
public class GetUserByEmailRepositoryTest {
    @Autowired
    private DefaultUserRepository defaultUserRepository;

    @Autowired
    private DefaultPasswordRepository defaultPasswordRepository;

    @Test
    void shouldFindUserByEmail() {
        String mockEmail = "test@email.com";

        DefaultPasswordEntity mockDefaultPasswordEntity = MockPasswordEntity.getMockDefaultPasswordEntity();
        defaultPasswordRepository.saveAndFlush(mockDefaultPasswordEntity);

        DefaultUserEntity mockDefaultUserEntity = MockUserEntity.getMockDefaultUserEntity();
        mockDefaultUserEntity.setPassword(mockDefaultPasswordEntity);

        defaultUserRepository.saveAndFlush(mockDefaultUserEntity);

        DefaultUserEntity foundUser = defaultUserRepository.findByEmail(mockEmail)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + mockEmail));

        assertThat(foundUser.getId()).isEqualTo(mockDefaultUserEntity.getId());
        assertThat(foundUser.getName()).isEqualTo(mockDefaultUserEntity.getName());
        assertThat(foundUser.getLastName()).isEqualTo(mockDefaultUserEntity.getLastName());
        assertThat(foundUser.getEmail()).isEqualTo(mockDefaultUserEntity.getEmail());
        assertThat(foundUser.getPhoneNumber()).isEqualTo(mockDefaultUserEntity.getPhoneNumber());
        assertThat(foundUser.getLocation()).isEqualTo(mockDefaultUserEntity.getLocation());
        assertThat(foundUser.getRole()).isEqualTo(mockDefaultUserEntity.getRole());
        assertThat(foundUser.getPassword().getPassword()).isEqualTo(mockDefaultUserEntity.getPassword().getPassword());
    }
}
