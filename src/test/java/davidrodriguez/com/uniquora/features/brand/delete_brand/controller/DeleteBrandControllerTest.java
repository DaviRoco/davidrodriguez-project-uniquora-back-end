package davidrodriguez.com.uniquora.features.brand.delete_brand.controller;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.delete_brand.service.DeleteBrandService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeleteBrandControllerTest {
    private MockMvc mockMvc;

    @Mock
    private DeleteBrandService deleteBrandService;

    @InjectMocks
    private DeleteBrandController deleteBrandController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(deleteBrandController).build();
    }

    @Test
    void shouldDeleteBrand() throws Exception {
        DefaultBrandDTO mockBrand = MockBrandDTO.getMockDefaultBrandDTO();

        when(deleteBrandService.deleteBrand(mockBrand.getId())).thenReturn(mockBrand);

        mockMvc.perform(delete("/api/brand/{id}", mockBrand.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockBrand.getId()))
                .andExpect(jsonPath("$.name").value(mockBrand.getName()))
                .andExpect(jsonPath("$.logo").value(mockBrand.getLogo()))
                .andExpect(jsonPath("$.createdAt").value(mockBrand.getCreatedAt()))
                .andExpect(jsonPath("$.updatedAt").value(mockBrand.getUpdatedAt()))
                .andExpect(jsonPath("$.active").value(mockBrand.isActive()));

        verify(deleteBrandService, times(1)).deleteBrand(mockBrand.getId());
    }

    @Test
    void shouldThrowResourceNotFoundExceptionBrand() throws Exception {
        DefaultBrandDTO mockBrand = MockBrandDTO.getMockDefaultBrandDTO();
        when(deleteBrandService.deleteBrand(mockBrand.getId())).thenThrow(new ResourceNotFoundException("Brand with ID 1 not found"));
        mockMvc.perform(delete("/api/brand/{id}", mockBrand.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldThrowGeneralExceptionBrand() throws Exception {
        DefaultBrandDTO mockBrand = MockBrandDTO.getMockDefaultBrandDTO();
        when(deleteBrandService.deleteBrand(mockBrand.getId())).thenThrow(new RuntimeException("Could not delete brand due to an internal error."));
        mockMvc.perform(delete("/api/brand/{id}", mockBrand.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
