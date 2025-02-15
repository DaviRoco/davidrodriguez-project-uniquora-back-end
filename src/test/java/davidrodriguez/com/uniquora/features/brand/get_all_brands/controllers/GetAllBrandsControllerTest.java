package davidrodriguez.com.uniquora.features.brand.get_all_brands.controllers;

import davidrodriguez.com.uniquora.features.brand.get_all_brands.services.GetAllBrandsService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTOList;
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

public class GetAllBrandsControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetAllBrandsService getAllBrandsService;

    @InjectMocks
    private GetAllBrandsController getAllBrandsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllBrandsController).build();
    }

    @Test
    void shouldReturnAllBrands() throws Exception {
        List<DefaultBrandDTO> mockBrands = new MockBrandDTOList().createMockDefaultBrandDTOList(1);

        when(getAllBrandsService.getAllBrands()).thenReturn(mockBrands);

        mockMvc.perform(get("/api/brand")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockBrands.size()))
                .andExpect(jsonPath("$[0].id").value(mockBrands.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(mockBrands.get(0).getName()))
                .andExpect(jsonPath("$[0].logo").value(mockBrands.get(0).getLogo()))
                .andExpect(jsonPath("$[0].createdAt").value(mockBrands.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockBrands.get(0).getUpdatedAt()))
                .andExpect(jsonPath("$[0].active").value(mockBrands.get(0).isActive()));

        verify(getAllBrandsService, times(1)).getAllBrands();
    }
}
