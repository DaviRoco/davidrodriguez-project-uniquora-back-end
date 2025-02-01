package davidrodriguez.com.uniquora.features.user.get_user_by_email.controllers;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.features.user.get_user_by_email.services.GetUserByEmailService;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetUserByEmailControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetUserByEmailService getUserByEmailService;

    @InjectMocks
    private GetUserByEmailController getUserByEmailController;

    private DefaultUserDTO mockDefaultUserDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getUserByEmailController).build();
        Password mockPassword = new Password(1L, "test");
        mockDefaultUserDTO = new DefaultUserDTO(1L, "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);
    }

    @Test
    void shouldReturnUserByEmail() throws Exception {
        when(getUserByEmailService.getUserByEmail("test@email.com")).thenReturn(mockDefaultUserDTO);

        mockMvc.perform(get("/api/user/{email}", mockDefaultUserDTO.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.email").value("test@email.com"));

        verify(getUserByEmailService, times(1)).getUserByEmail("test@email.com");
    }

    @Test
    void shouldNotReturnUserByEmailWhenUserNotFound() throws Exception {
        when(getUserByEmailService.getUserByEmail("test@email.com")).thenReturn(null);
        mockMvc.perform(get("/api/user/{email}", mockDefaultUserDTO.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}
