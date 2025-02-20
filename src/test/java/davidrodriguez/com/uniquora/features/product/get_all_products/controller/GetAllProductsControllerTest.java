package davidrodriguez.com.uniquora.features.product.get_all_products.controller;

import davidrodriguez.com.uniquora.features.product.get_all_products.service.GetAllProductsService;
import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.mockEntities.product.dtos.MockProductDTOList;
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

public class GetAllProductsControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GetAllProductsService getAllProductsService;

    @InjectMocks
    private GetAllProductsController getAllProductsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllProductsController).build();
    }

    @Test
    void shouldReturnAllProducts() throws Exception {
        List<DefaultProductDTO> mockProducts = new MockProductDTOList().createMockDefaultProductDTOList(1);

        when(getAllProductsService.getAllProducts()).thenReturn(mockProducts);

        mockMvc.perform(get("/api/product")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockProducts.size()))
                .andExpect(jsonPath("$[0].id").value(mockProducts.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(mockProducts.get(0).getName()))
                .andExpect(jsonPath("$[0].description").value(mockProducts.get(0).getDescription()))
                .andExpect(jsonPath("$[0].price").value(mockProducts.get(0).getPrice()))
                .andExpect(jsonPath("$[0].stockQuantity").value(mockProducts.get(0).getStockQuantity()))
                .andExpect(jsonPath("$[0].brand.id").value(mockProducts.get(0).getBrand().getId()))
                .andExpect(jsonPath("$[0].productImages.size()").value(mockProducts.get(0).getProductImages().size()))
                .andExpect(jsonPath("$[0].createdAt").value(mockProducts.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockProducts.get(0).getUpdatedAt()));

        verify(getAllProductsService, times(1)).getAllProducts();
    }

    @Test
    void shouldNotReturnProductsWhenInternalServerError() throws Exception {
        when(getAllProductsService.getAllProducts()).thenThrow(new RuntimeException("Could not get all products due to an internal error."));
        mockMvc.perform(get("/api/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
