package davidrodriguez.com.uniquora.features.order.get_all_orders.service;

import davidrodriguez.com.uniquora.features.order.shared.dtos.DefaultOrderDTO;
import davidrodriguez.com.uniquora.features.order.shared.entities.DefaultOrderEntity;
import davidrodriguez.com.uniquora.features.order.shared.repositories.DefaultOrderRepository;
import davidrodriguez.com.uniquora.mockEntities.order.entities.MockOrderEntityList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GetAllOrdersServiceTest {

    @Mock
    private DefaultOrderRepository defaultOrderRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllOrdersService getAllOrdersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllOrders() {
        List<DefaultOrderEntity> mockEntities = new MockOrderEntityList().createMockDefaultOrderEntityList(3);

        when(defaultOrderRepository.findAll()).thenReturn(mockEntities);
        when(modelMapper.map(any(DefaultOrderEntity.class), eq(DefaultOrderDTO.class)))
                .thenAnswer(invocation -> {
                    DefaultOrderEntity entity = invocation.getArgument(0);
                    return new DefaultOrderDTO(
                            entity.getId(),
                            entity.getUserId(),
                            entity.getStatus(),
                            entity.getTotalPrice(),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt()
                    );
                });

        List<DefaultOrderDTO> result = getAllOrdersService.getAllOrders();

        assertEquals(mockEntities.size(), result.size());
        assertThat(result)
                .isNotEmpty()
                .extracting(DefaultOrderDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultOrderRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getAllOrdersService.getAllOrders());

        assertEquals("Could not get all orders due to an internal error.", exception.getMessage());
    }
}
