package davidrodriguez.com.uniquora.features.user.shared.entities;

import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.enumeration.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserEntityTest {
    private DefaultUserEntity mockDefaultUserEntity;
    private Password mockPassword;
    private Date createdAt;
    private Date updatedAt;

    @BeforeEach
    public void setUp() {
        mockPassword = new Password("test");
        createdAt = new Date();
        updatedAt = new Date();
        mockDefaultUserEntity = new DefaultUserEntity(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, createdAt, updatedAt, mockPassword);
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockDefaultUserEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultUserEntity.getName()).isEqualTo("John");
        assertThat(mockDefaultUserEntity.getLastName()).isEqualTo("Doe");
        assertThat(mockDefaultUserEntity.getEmail()).isEqualTo("test@email.com");
        assertThat(mockDefaultUserEntity.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(mockDefaultUserEntity.getLocation()).isEqualTo("Costa Rica");
        assertThat(mockDefaultUserEntity.getRole()).isEqualTo(Role.ADMIN);
        assertThat(mockDefaultUserEntity.getCreatedAt()).isEqualTo(createdAt);
        assertThat(mockDefaultUserEntity.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(mockDefaultUserEntity.getPasswordHash()).isEqualTo(mockPassword);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultUserEntity newDefaultUserEntity = getDefaultUserEntity();

        assertThat(newDefaultUserEntity.getId()).isEqualTo(2L);
        assertThat(newDefaultUserEntity.getName()).isEqualTo("Jane");
        assertThat(newDefaultUserEntity.getLastName()).isEqualTo("Smith");
        assertThat(newDefaultUserEntity.getEmail()).isEqualTo("jane@email.com");
        assertThat(newDefaultUserEntity.getPhoneNumber()).isEqualTo("+123456789");
        assertThat(newDefaultUserEntity.getLocation()).isEqualTo("USA");
        assertThat(newDefaultUserEntity.getRole()).isEqualTo(Role.USER);
        assertThat(newDefaultUserEntity.getCreatedAt()).isEqualTo(createdAt);
        assertThat(newDefaultUserEntity.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(newDefaultUserEntity.getPasswordHash()).isEqualTo(mockPassword);
    }

    private DefaultUserEntity getDefaultUserEntity() {
        DefaultUserEntity newDefaultUserEntity = new DefaultUserEntity();
        newDefaultUserEntity.setId(2L);
        newDefaultUserEntity.setName("Jane");
        newDefaultUserEntity.setLastName("Smith");
        newDefaultUserEntity.setEmail("jane@email.com");
        newDefaultUserEntity.setPhoneNumber("+123456789");
        newDefaultUserEntity.setLocation("USA");
        newDefaultUserEntity.setRole(Role.USER);
        newDefaultUserEntity.setCreatedAt(createdAt);
        newDefaultUserEntity.setUpdatedAt(updatedAt);
        newDefaultUserEntity.setPasswordHash(mockPassword);
        return newDefaultUserEntity;
    }
}
