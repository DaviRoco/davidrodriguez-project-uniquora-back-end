package davidrodriguez.com.uniquora.features.user.shared.dtos;

import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.enumeration.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserDTOTest {
    private DefaultUserDTO mockDefaultUserDTO;
    private Password mockPassword;
    private Date createdAt;
    private Date updatedAt;

    @BeforeEach
    public void setUp() {
        mockPassword = new Password("test");
        createdAt = new Date();
        updatedAt = new Date();
        mockDefaultUserDTO = new DefaultUserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, createdAt, updatedAt, mockPassword);
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockDefaultUserDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultUserDTO.getName()).isEqualTo("John");
        assertThat(mockDefaultUserDTO.getLastName()).isEqualTo("Doe");
        assertThat(mockDefaultUserDTO.getEmail()).isEqualTo("test@email.com");
        assertThat(mockDefaultUserDTO.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(mockDefaultUserDTO.getLocation()).isEqualTo("Costa Rica");
        assertThat(mockDefaultUserDTO.getRole()).isEqualTo(Role.ADMIN);
        assertThat(mockDefaultUserDTO.getCreatedAt()).isEqualTo(createdAt);
        assertThat(mockDefaultUserDTO.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(mockDefaultUserDTO.getPassword()).isEqualTo(mockPassword);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultUserDTO newDefaultUserDTO = getDefaultUserDTO();

        assertThat(newDefaultUserDTO.getId()).isEqualTo(2L);
        assertThat(newDefaultUserDTO.getName()).isEqualTo("Jane");
        assertThat(newDefaultUserDTO.getLastName()).isEqualTo("Smith");
        assertThat(newDefaultUserDTO.getEmail()).isEqualTo("jane@email.com");
        assertThat(newDefaultUserDTO.getPhoneNumber()).isEqualTo("+123456789");
        assertThat(newDefaultUserDTO.getLocation()).isEqualTo("USA");
        assertThat(newDefaultUserDTO.getRole()).isEqualTo(Role.USER);
        assertThat(newDefaultUserDTO.getCreatedAt()).isEqualTo(createdAt);
        assertThat(newDefaultUserDTO.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(newDefaultUserDTO.getPassword()).isEqualTo(mockPassword);
    }

    private DefaultUserDTO getDefaultUserDTO() {
        DefaultUserDTO newDefaultUserDTO = new DefaultUserDTO();
        newDefaultUserDTO.setId(2L);
        newDefaultUserDTO.setName("Jane");
        newDefaultUserDTO.setLastName("Smith");
        newDefaultUserDTO.setEmail("jane@email.com");
        newDefaultUserDTO.setPhoneNumber("+123456789");
        newDefaultUserDTO.setLocation("USA");
        newDefaultUserDTO.setRole(Role.USER);
        newDefaultUserDTO.setCreatedAt(createdAt);
        newDefaultUserDTO.setUpdatedAt(updatedAt);
        newDefaultUserDTO.setPassword(mockPassword);
        return newDefaultUserDTO;
    }
}
