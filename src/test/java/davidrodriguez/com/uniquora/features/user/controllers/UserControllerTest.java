package davidrodriguez.com.uniquora.features.user.controllers;

import davidrodriguez.com.uniquora.features.security.domain.Password;
import davidrodriguez.com.uniquora.features.user.domain.Role;
import davidrodriguez.com.uniquora.features.user.dtos.UserDTO;
import davidrodriguez.com.uniquora.features.user.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private Password mockPassword;

    private UserDTO mockUserDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockPassword = new Password(1L, "test");
        mockUserDTO = new UserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);
    }

    @Test
    void shouldReturnAllUsers() throws Exception {

        List<UserDTO> mockUsers = new ArrayList<>();
        mockUsers.add(mockUserDTO);

        when(userService.getAllUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/api/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockUsers.size()))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].email").value("test@email.com"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void shouldReturnUserByEmail() throws Exception {
        when(userService.getUserByEmail("test@email.com")).thenReturn(mockUserDTO);

        mockMvc.perform(get("/api/user/{email}", mockUserDTO.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.email").value("test@email.com"));

        verify(userService, times(1)).getUserByEmail("test@email.com");
    }

    @Test
    void shouldNotReturnUserByEmailWhenUserNotFound() throws Exception {
        when(userService.getUserByEmail("test@email.com")).thenReturn(null);
        mockMvc.perform(get("/api/user/{email}", mockUserDTO.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}
