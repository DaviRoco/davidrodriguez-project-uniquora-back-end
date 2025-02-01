package davidrodriguez.com.uniquora.features.user.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import davidrodriguez.com.uniquora.features.user.domain.User;
import davidrodriguez.com.uniquora.features.user.dtos.UserDTO;
import davidrodriguez.com.uniquora.features.user.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private void arrangeResolvedMapper() {
        when(modelMapper.map(any(User.class), eq(UserDTO.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            return new UserDTO(user.getId(), user.getName(), user.getEmail());
        });
    }

    @Test
    void shouldReturnAllUsers() {
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(1L, "John Doe", "john@example.com"));
        mockUsers.add(new User(2L, "Jane Doe", "jane@example.com"));
        mockUsers.add(new User(3L, "Jack Doe", "jack@example.com"));

        arrangeResolvedMapper();
        when(userRepository.findAll()).thenReturn(mockUsers);
        List<UserDTO> userDTOList = userService.getAllUsers();

        assertEquals(mockUsers.size(), userDTOList.size());
        assertThat(userDTOList).isNotEmpty();
        assertThat(userDTOList).isNotNull()
                .extracting(UserDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldReturnUserByEmailWhenUserExists() {
        User mockUser = new User(1L, "John Doe", "john@example.com");

        arrangeResolvedMapper();
        when(userRepository.findByEmail(mockUser.getEmail())).thenReturn(Optional.of(mockUser));
        UserDTO userDTO = userService.getUserByEmail(mockUser.getEmail());

        assertEquals(mockUser.getId(), userDTO.getId());
        assertEquals(mockUser.getName(), userDTO.getName());
        assertEquals(mockUser.getEmail(), userDTO.getEmail());
    }

    @Test
    void shouldNotReturnUserByEmailWhenUserDoesNotExist() {
        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> userService.getUserByEmail("john@example.com"));

        assertEquals("User not found", exception.getMessage());
    }
}
