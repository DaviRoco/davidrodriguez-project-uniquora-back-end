package davidrodriguez.com.uniquora.features.user.get_all_users.controllers;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.features.user.get_all_users.services.GetAllUsersService;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
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

public class GetAllUsersControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetAllUsersService getAllUsersService;

    @InjectMocks
    private GetAllUsersController getAllUsersController;

    private DefaultUserDTO mockDefaultUserDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllUsersController).build();
        Password mockPassword = new Password(1L, "test");
        mockDefaultUserDTO = new DefaultUserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, mockPassword, new Date(), new Date());
    }

    @Test
    void shouldReturnAllUsers() throws Exception {
        List<DefaultUserDTO> mockUsers = new ArrayList<>();
        mockUsers.add(mockDefaultUserDTO);

        when(getAllUsersService.getAllUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/api/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockUsers.size()))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].email").value("test@email.com"));

        verify(getAllUsersService, times(1)).getAllUsers();
    }

}
