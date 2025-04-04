package davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.controller;

import davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.service.GetAllCartItemsService;
import davidrodriguez.com.uniquora.features.cart_item.shared.dtos.DefaultCartItemDTO;
import davidrodriguez.com.uniquora.mockEntities.cart_item.dtos.MockCartItemDTOList;
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

public class GetAllCartItemsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetAllCartItemsService getAllCartItemsService;

    @InjectMocks
    private GetAllCartItemsController getAllCartItemsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllCartItemsController).build();
    }

    @Test
    void shouldReturnAllCartItems() throws Exception {
        final List<DefaultCartItemDTO> mockCartItems = new MockCartItemDTOList().createMockDefaultCartItemDTOList(1);

        when(getAllCartItemsService.getAllCartItems()).thenReturn(mockCartItems);

        mockMvc.perform(get("/api/cart-item")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockCartItems.size()))
                .andExpect(jsonPath("$[0].id").value(mockCartItems.get(0).getId()))
                .andExpect(jsonPath("$[0].cartsId").value(mockCartItems.get(0).getCartsId()))
                .andExpect(jsonPath("$[0].productsId").value(mockCartItems.get(0).getProductsId()))
                .andExpect(jsonPath("$[0].quantity").value(mockCartItems.get(0).getQuantity()))
                .andExpect(jsonPath("$[0].createdAt").value(mockCartItems.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockCartItems.get(0).getUpdatedAt()));

        verify(getAllCartItemsService, times(1)).getAllCartItems();
    }

    @Test
    void shouldReturnInternalServerError() throws Exception {
        when(getAllCartItemsService.getAllCartItems()).thenThrow(new RuntimeException("Internal error"));

        mockMvc.perform(get("/api/cart-item")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
