package davidrodriguez.com.uniquora.features.cart.get_all_carts.controller;

import davidrodriguez.com.uniquora.features.cart.get_all_carts.service.GetAllCartsService;
import davidrodriguez.com.uniquora.features.cart.shared.dtos.DefaultCartDTO;
import davidrodriguez.com.uniquora.mockEntities.cart.dtos.MockCartDTOList;
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

public class GetAllCartsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetAllCartsService getAllCartsService;

    @InjectMocks
    private GetAllCartsController getAllCartsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllCartsController).build();
    }

    @Test
    void shouldReturnAllCarts() throws Exception {
        List<DefaultCartDTO> mockCarts = new MockCartDTOList().createMockDefaultCartDTOList(1);

        when(getAllCartsService.getAllCarts()).thenReturn(mockCarts);

        mockMvc.perform(get("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockCarts.size()))
                .andExpect(jsonPath("$[0].id").value(mockCarts.get(0).getId()))
                .andExpect(jsonPath("$[0].userId").value(mockCarts.get(0).getUserId()))
                .andExpect(jsonPath("$[0].createdAt").value(mockCarts.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockCarts.get(0).getUpdatedAt()));

        verify(getAllCartsService, times(1)).getAllCarts();
    }

    @Test
    void shouldNotReturnCartsWhenInternalServerError() throws Exception {
        when(getAllCartsService.getAllCarts()).thenThrow(new RuntimeException("Could not get all carts due to an internal error."));

        mockMvc.perform(get("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
