package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.controller;

import davidrodriguez.com.uniquora.features.product_image.get_all_product_images.service.GetAllProductImagesService;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTOList;
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

public class GetAllProductImagesControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetAllProductImagesService getAllProductImagesService;

    @InjectMocks
    private GetAllProductImagesController getAllProductImagesController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllProductImagesController).build();
    }

    @Test
    void shouldReturnAllProductImages() throws Exception {
        List<DefaultProductImageDTO> mockProductImages = new MockProductImageDTOList().createMockDefaultProductImageDTOList(1);

        when(getAllProductImagesService.getAllProductImages()).thenReturn(mockProductImages);

        mockMvc.perform(get("/api/product-image")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockProductImages.size()))
                .andExpect(jsonPath("$[0].id").value(mockProductImages.get(0).getId()))
                .andExpect(jsonPath("$[0].imageUrl").value(mockProductImages.get(0).getImageUrl()));

        verify(getAllProductImagesService, times(1)).getAllProductImages();
    }

    @Test
    void shouldNotReturnProductImagesWhenInternalServerError() throws Exception {
        when(getAllProductImagesService.getAllProductImages()).thenThrow(new RuntimeException("Could not get all product images due to an internal error."));
        mockMvc.perform(get("/api/product-image")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
