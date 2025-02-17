package davidrodriguez.com.uniquora.features.user.get_all_users.controller;

import davidrodriguez.com.uniquora.features.user.get_all_users.service.GetAllUsersService;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTOList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllUsersController).build();
    }

    @Test
    void shouldReturnAllUsers() throws Exception {
        List<DefaultUserDTO> mockUsers = new MockUserDTOList().createMockDefaultUserDTOList(2);

        when(getAllUsersService.getAllUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/api/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockUsers.size()))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Jane"))
                .andExpect(jsonPath("$[0].email").value("jane1@email.com"));

        verify(getAllUsersService, times(1)).getAllUsers();
    }

}
