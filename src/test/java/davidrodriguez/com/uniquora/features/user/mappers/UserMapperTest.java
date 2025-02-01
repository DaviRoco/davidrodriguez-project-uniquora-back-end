package davidrodriguez.com.uniquora.features.user.mappers;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.user.domain.Role;
import davidrodriguez.com.uniquora.features.user.domain.User;
import davidrodriguez.com.uniquora.features.user.dtos.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {
    private Password mockPassword;
    private UserMapper userMapper; // Use a real instance

    @BeforeEach
    void setUp() {
        mockPassword = new Password(1L, "test");
        userMapper = new UserMapper(); // Initialize the real UserMapper
    }

    @Test
    void shouldMapUserToUserDTO() {
        User mockUser = new User(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);

        UserDTO mockUserDTOMapped = userMapper.toUserDTO(mockUser);

        assertThat(mockUserDTOMapped).isNotNull()
                .extracting(UserDTO::getId)
                .isEqualTo(mockUser.getId());
        assertThat(mockUserDTOMapped.getName()).isEqualTo(mockUser.getName());
        assertThat(mockUserDTOMapped.getLastName()).isEqualTo(mockUser.getLastName());
        assertThat(mockUserDTOMapped.getEmail()).isEqualTo(mockUser.getEmail());
        assertThat(mockUserDTOMapped.getPhoneNumber()).isEqualTo(mockUser.getPhoneNumber());
        assertThat(mockUserDTOMapped.getLocation()).isEqualTo(mockUser.getLocation());
    }

    @Test
    void shouldNotMapUserToUserDTOWhenUserIsNull() {
        UserDTO mockUserDTOMapped = userMapper.toUserDTO(null);

        assertThat(mockUserDTOMapped).isNull();
    }

    @Test
    void shouldMapUserDTOToUser() {
        UserDTO mockUserDTO = new UserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);

        User mockUserMapped = userMapper.toUser(mockUserDTO);

        assertThat(mockUserMapped).isNotNull()
                .extracting(User::getId)
                .isEqualTo(mockUserDTO.getId());
        assertThat(mockUserMapped.getName()).isEqualTo(mockUserDTO.getName());
        assertThat(mockUserMapped.getLastName()).isEqualTo(mockUserDTO.getLastName());
        assertThat(mockUserMapped.getEmail()).isEqualTo(mockUserDTO.getEmail());
        assertThat(mockUserMapped.getPhoneNumber()).isEqualTo(mockUserDTO.getPhoneNumber());
        assertThat(mockUserMapped.getLocation()).isEqualTo(mockUserDTO.getLocation());
    }

    @Test
    void shouldNotMapUserDTOToUserWhenUserIsNull() {
        User mockUserMapped = userMapper.toUser(null);

        assertThat(mockUserMapped).isNull();
    }
}
