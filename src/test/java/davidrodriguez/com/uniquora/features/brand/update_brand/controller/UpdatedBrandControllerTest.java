package davidrodriguez.com.uniquora.features.brand.update_brand.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.update_brand.service.UpdateBrandService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdatedBrandControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UpdateBrandService updateBrandService;

    @InjectMocks
    private UpdateBrandController updateBrandController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(updateBrandController).build();
    }

    @Test
    void shouldUpdateBrand() throws Exception {
        DefaultBrandDTO inputBrand = MockBrandDTO.createNewMockDefaultBrandDTO();
        DefaultBrandDTO mockBrand = MockBrandDTO.getMockDefaultBrandDTO();

        when(updateBrandService.updateBrand(any(DefaultBrandDTO.class))).thenReturn(mockBrand);

        mockMvc.perform(put("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBrand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockBrand.getId()))
                .andExpect(jsonPath("$.name").value(mockBrand.getName()))
                .andExpect(jsonPath("$.logo").value(mockBrand.getLogo()))
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists())
                .andExpect(jsonPath("$.active").exists());

        verify(updateBrandService, times(1)).updateBrand(any(DefaultBrandDTO.class));
    }

    @Test
    void shouldNotReturnBrandWhenBrandNotFound() throws Exception {
        DefaultBrandDTO inputBrand = MockBrandDTO.createNewMockDefaultBrandDTO();
        when(updateBrandService.updateBrand(any(DefaultBrandDTO.class))).thenThrow(new ResourceNotFoundException("Brand with ID" + inputBrand.getId() + " not found"));
        mockMvc.perform(put("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBrand)))
                        .andExpect(status().isNotFound());
    }

    @Test
    void shouldNotReturnBrandWhenInternalServerError() throws Exception {
        DefaultBrandDTO inputBrand = MockBrandDTO.createNewMockDefaultBrandDTO();
        when(updateBrandService.updateBrand(any(DefaultBrandDTO.class))).thenThrow(new RuntimeException("Could not update brand due to an internal error."));
        mockMvc.perform(put("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBrand)))
                .andExpect(status().isInternalServerError());
    }
}
