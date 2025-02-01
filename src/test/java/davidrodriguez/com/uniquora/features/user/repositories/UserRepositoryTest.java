package davidrodriguez.com.uniquora.features.user.repositories;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.security.repositories.PasswordRepository;
import davidrodriguez.com.uniquora.features.user.domain.Role;
import davidrodriguez.com.uniquora.features.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Test
    void shouldFindAllUsers() {
        Password mockPassword = new Password(1L, "test");
        passwordRepository.save(mockPassword);
        User mockUser = new User(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);
        userRepository.save(mockUser);

        assertThat(userRepository.findAll()).hasSize(1);
        assertThat(userRepository.findAll().get(0).getId()).isEqualTo(1L);
        assertThat(userRepository.findAll().get(0).getName()).isEqualTo(mockUser.getName());
        assertThat(userRepository.findAll().get(0).getLastName()).isEqualTo(mockUser.getLastName());
        assertThat(userRepository.findAll().get(0).getEmail()).isEqualTo(mockUser.getEmail());
        assertThat(userRepository.findAll().get(0).getPhoneNumber()).isEqualTo(mockUser.getPhoneNumber());
        assertThat(userRepository.findAll().get(0).getLocation()).isEqualTo(mockUser.getLocation());
        assertThat(userRepository.findAll().get(0).getRole()).isEqualTo(mockUser.getRole());
        assertThat(userRepository.findAll().get(0).getPasswordHash().getClass()).isEqualTo(mockUser.getPasswordHash().getClass());
    }
}
