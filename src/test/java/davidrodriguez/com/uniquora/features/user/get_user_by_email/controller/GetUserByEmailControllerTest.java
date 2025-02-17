package davidrodriguez.com.uniquora.features.user.get_user_by_email.controller;

import davidrodriguez.com.uniquora.features.user.get_user_by_email.service.GetUserByEmailService;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
        mockDefaultUserDTO = MockUserDTO.getMockDefaultUserDTO();
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
