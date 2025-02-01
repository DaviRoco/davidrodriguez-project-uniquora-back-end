package davidrodriguez.com.uniquora.features.user.domain;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.user.dtos.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private User mockUser;
    private Password mockPassword;
    private Date createdAt;
    private Date updatedAt;

    @BeforeEach
    public void setUp() {
        mockPassword = new Password(1L, "test");
        createdAt = new Date();
        updatedAt = new Date();
        mockUser = new User(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, createdAt, updatedAt, mockPassword);
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockUser.getId()).isEqualTo(1L);
        assertThat(mockUser.getName()).isEqualTo("John");
        assertThat(mockUser.getLastName()).isEqualTo("Doe");
        assertThat(mockUser.getEmail()).isEqualTo("test@email.com");
        assertThat(mockUser.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(mockUser.getLocation()).isEqualTo("Costa Rica");
        assertThat(mockUser.getRole()).isEqualTo(Role.ADMIN);
        assertThat(mockUser.getCreatedAt()).isEqualTo(createdAt);
        assertThat(mockUser.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(mockUser.getPasswordHash()).isEqualTo(mockPassword);
    }

    @Test
    void shouldSetAllAttributes() {
        User newUser = new User();
        newUser.setId(2L);
        newUser.setName("Jane");
        newUser.setLastName("Smith");
        newUser.setEmail("jane@email.com");
        newUser.setPhoneNumber("+123456789");
        newUser.setLocation("USA");
        newUser.setRole(Role.USER);
        newUser.setCreatedAt(createdAt);
        newUser.setUpdatedAt(updatedAt);
        newUser.setPasswordHash(mockPassword);

        assertThat(newUser.getId()).isEqualTo(2L);
        assertThat(newUser.getName()).isEqualTo("Jane");
        assertThat(newUser.getLastName()).isEqualTo("Smith");
        assertThat(newUser.getEmail()).isEqualTo("jane@email.com");
        assertThat(newUser.getPhoneNumber()).isEqualTo("+123456789");
        assertThat(newUser.getLocation()).isEqualTo("USA");
        assertThat(newUser.getRole()).isEqualTo(Role.USER);
        assertThat(newUser.getCreatedAt()).isEqualTo(createdAt);
        assertThat(newUser.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(newUser.getPasswordHash()).isEqualTo(mockPassword);
    }
}
