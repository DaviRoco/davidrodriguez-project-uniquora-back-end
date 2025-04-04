package davidrodriguez.com.uniquora.features.brand.get_brand_by_id.controller;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.get_brand_by_id.service.GetBrandByIdService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class GetBrandByIdControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetBrandByIdService getBrandByIdService;

    @InjectMocks
    private GetBrandByIdController getBrandByIdController;

    private DefaultBrandDTO mockDefaultBrandDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getBrandByIdController).build();
        mockDefaultBrandDTO = MockBrandDTO.getMockDefaultBrandDTO();
    }

    @Test
    void shouldReturnBrandById() throws Exception {
        when(getBrandByIdService.getBrandById(any(Long.class))).thenReturn(mockDefaultBrandDTO);

        mockMvc.perform(get("/api/brand/{id}", mockDefaultBrandDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Brand"))
                .andExpect(jsonPath("$.logo").value("testLogoURL.com"));

        verify(getBrandByIdService, times(1)).getBrandById(any(Long.class));
    }

    @Test
    void shouldNotReturnBrandByIdWhenBrandNotFound() throws Exception {
        when(getBrandByIdService.getBrandById(any(Long.class))).thenThrow(new ResourceNotFoundException("Brand with ID 1 not found"));
        mockMvc.perform(get("/api/brand/{id}", mockDefaultBrandDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldNotReturnBrandWhenInternalServerError() throws Exception {
        when(getBrandByIdService.getBrandById(any(Long.class))).thenThrow(new RuntimeException("Could not find brand by ID due to an internal error."));
        mockMvc.perform(get("/api/brand/{id}", mockDefaultBrandDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
