package davidrodriguez.com.uniquora.features.brand.create_brand.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import davidrodriguez.com.uniquora.features.brand.create_brand.service.CreateBrandService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateBrandControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CreateBrandService createBrandService;

    @InjectMocks
    private CreateBrandController createBrandController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(createBrandController).build();
    }

    @Test
    void shouldCreateBrand() throws Exception {
        final DefaultBrandDTO inputBrand = MockBrandDTO.createNewMockDefaultBrandDTO();
        final DefaultBrandDTO mockBrand = MockBrandDTO.getMockDefaultBrandDTO();

        when(createBrandService.createBrand(any(DefaultBrandDTO.class))).thenReturn(mockBrand);

        mockMvc.perform(post("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBrand)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(mockBrand.getId()))
                .andExpect(jsonPath("$.name").value(mockBrand.getName()))
                .andExpect(jsonPath("$.logo").value(mockBrand.getLogo()))
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists())
                .andExpect(jsonPath("$.active").exists());

        verify(createBrandService, times(1)).createBrand(any(DefaultBrandDTO.class));
    }

    @Test
    void shouldNotReturnBrandWhenInternalServerError() throws Exception {
        final DefaultBrandDTO inputBrand = MockBrandDTO.createNewMockDefaultBrandDTO();
        when(createBrandService.createBrand(any(DefaultBrandDTO.class))).thenThrow(new RuntimeException("Could not create brand due to an internal error."));
        mockMvc.perform(post("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputBrand)))
                .andExpect(status().isInternalServerError());
    }
}
