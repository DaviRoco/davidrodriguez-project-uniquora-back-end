package davidrodriguez.com.uniquora.features.order_item.get_all_order_items.controller;

import davidrodriguez.com.uniquora.features.order_item.get_all_order_items.service.GetAllOrderItemsService;
import davidrodriguez.com.uniquora.features.order_item.shared.dtos.DefaultOrderItemDTO;
import davidrodriguez.com.uniquora.mockEntities.order_item.dtos.MockOrderItemDTOList;
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

public class GetAllOrderItemsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetAllOrderItemsService getAllOrderItemsService;

    @InjectMocks
    private GetAllOrderItemsController getAllOrderItemsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllOrderItemsController).build();
    }

    @Test
    void shouldReturnAllOrderItems() throws Exception {
        List<DefaultOrderItemDTO> mockItems = new MockOrderItemDTOList().createMockDefaultOrderItemDTOList(1);

        when(getAllOrderItemsService.getAllOrderItems()).thenReturn(mockItems);

        mockMvc.perform(get("/api/order-item")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockItems.size()))
                .andExpect(jsonPath("$[0].id").value(mockItems.get(0).getId()))
                .andExpect(jsonPath("$[0].orderId").value(mockItems.get(0).getOrderId()))
                .andExpect(jsonPath("$[0].productId").value(mockItems.get(0).getProductId()))
                .andExpect(jsonPath("$[0].quantity").value(mockItems.get(0).getQuantity()));

        verify(getAllOrderItemsService, times(1)).getAllOrderItems();
    }

    @Test
    void shouldNotReturnOrderItemsWhenInternalServerError() throws Exception {
        when(getAllOrderItemsService.getAllOrderItems()).thenThrow(new RuntimeException("Could not get all order items due to an internal error."));

        mockMvc.perform(get("/api/order-item")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
