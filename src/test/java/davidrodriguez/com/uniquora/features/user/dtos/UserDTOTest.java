package davidrodriguez.com.uniquora.features.user.dtos;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.user.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDTOTest {
    private UserDTO mockUserDTO;
    private Password mockPassword;
    private Date createdAt;
    private Date updatedAt;

    @BeforeEach
    public void setUp() {
        mockPassword = new Password(1L, "test");
        createdAt = new Date();
        updatedAt = new Date();
        mockUserDTO = new UserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, createdAt, updatedAt, mockPassword);
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockUserDTO.getId()).isEqualTo(1L);
        assertThat(mockUserDTO.getName()).isEqualTo("John");
        assertThat(mockUserDTO.getLastName()).isEqualTo("Doe");
        assertThat(mockUserDTO.getEmail()).isEqualTo("test@email.com");
        assertThat(mockUserDTO.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(mockUserDTO.getLocation()).isEqualTo("Costa Rica");
        assertThat(mockUserDTO.getRole()).isEqualTo(Role.ADMIN);
        assertThat(mockUserDTO.getCreatedAt()).isEqualTo(createdAt);
        assertThat(mockUserDTO.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(mockUserDTO.getPassword()).isEqualTo(mockPassword);
    }

    @Test
    void shouldSetAllAttributes() {
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setId(2L);
        newUserDTO.setName("Jane");
        newUserDTO.setLastName("Smith");
        newUserDTO.setEmail("jane@email.com");
        newUserDTO.setPhoneNumber("+123456789");
        newUserDTO.setLocation("USA");
        newUserDTO.setRole(Role.USER);
        newUserDTO.setCreatedAt(createdAt);
        newUserDTO.setUpdatedAt(updatedAt);
        newUserDTO.setPassword(mockPassword);

        assertThat(newUserDTO.getId()).isEqualTo(2L);
        assertThat(newUserDTO.getName()).isEqualTo("Jane");
        assertThat(newUserDTO.getLastName()).isEqualTo("Smith");
        assertThat(newUserDTO.getEmail()).isEqualTo("jane@email.com");
        assertThat(newUserDTO.getPhoneNumber()).isEqualTo("+123456789");
        assertThat(newUserDTO.getLocation()).isEqualTo("USA");
        assertThat(newUserDTO.getRole()).isEqualTo(Role.USER);
        assertThat(newUserDTO.getCreatedAt()).isEqualTo(createdAt);
        assertThat(newUserDTO.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(newUserDTO.getPassword()).isEqualTo(mockPassword);
    }
}
