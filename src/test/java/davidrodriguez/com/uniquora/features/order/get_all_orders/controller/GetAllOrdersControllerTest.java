package davidrodriguez.com.uniquora.features.order.get_all_orders.controller;

import davidrodriguez.com.uniquora.features.order.get_all_orders.service.GetAllOrdersService;
import davidrodriguez.com.uniquora.features.order.shared.dtos.DefaultOrderDTO;
import davidrodriguez.com.uniquora.mockEntities.order.dtos.MockOrderDTOList;
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

public class GetAllOrdersControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetAllOrdersService getAllOrdersService;

    @InjectMocks
    private GetAllOrdersController getAllOrdersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllOrdersController).build();
    }

    @Test
    void shouldReturnAllOrders() throws Exception {
        final List<DefaultOrderDTO> mockOrders = new MockOrderDTOList().createMockDefaultOrderDTOList(1);

        when(getAllOrdersService.getAllOrders()).thenReturn(mockOrders);

        mockMvc.perform(get("/api/order")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockOrders.size()))
                .andExpect(jsonPath("$[0].id").value(mockOrders.get(0).getId()))
                .andExpect(jsonPath("$[0].userId").value(mockOrders.get(0).getUserId()))
                .andExpect(jsonPath("$[0].status").value(mockOrders.get(0).getStatus()))
                .andExpect(jsonPath("$[0].totalPrice").value(mockOrders.get(0).getTotalPrice()))
                .andExpect(jsonPath("$[0].createdAt").value(mockOrders.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockOrders.get(0).getUpdatedAt()));

        verify(getAllOrdersService, times(1)).getAllOrders();
    }

    @Test
    void shouldNotReturnOrdersWhenInternalServerError() throws Exception {
        when(getAllOrdersService.getAllOrders()).thenThrow(new RuntimeException("Could not get all orders due to an internal error."));

        mockMvc.perform(get("/api/order")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
