package davidrodriguez.com.uniquora.features.order_item.get_all_order_items.service;

import davidrodriguez.com.uniquora.features.order_item.shared.dtos.DefaultOrderItemDTO;
import davidrodriguez.com.uniquora.features.order_item.shared.entities.DefaultOrderItemEntity;
import davidrodriguez.com.uniquora.features.order_item.shared.repositories.DefaultOrderItemRepository;
import davidrodriguez.com.uniquora.mockEntities.order_item.entities.MockOrderItemEntityList;
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

public class GetAllOrderItemsServiceTest {

    @Mock
    private DefaultOrderItemRepository defaultOrderItemRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllOrderItemsService getAllOrderItemsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllOrderItems() {
        List<DefaultOrderItemEntity> mockEntities = new MockOrderItemEntityList().createMockDefaultOrderItemEntityList(3);

        when(defaultOrderItemRepository.findAll()).thenReturn(mockEntities);
        when(modelMapper.map(any(DefaultOrderItemEntity.class), eq(DefaultOrderItemDTO.class)))
                .thenAnswer(invocation -> {
                    DefaultOrderItemEntity entity = invocation.getArgument(0);
                    return new DefaultOrderItemDTO(
                            entity.getId(),
                            entity.getOrderId(),
                            entity.getProductId(),
                            entity.getQuantity()
                    );
                });

        List<DefaultOrderItemDTO> result = getAllOrderItemsService.getAllOrderItems();

        assertEquals(mockEntities.size(), result.size());
        assertThat(result)
                .isNotEmpty()
                .extracting(DefaultOrderItemDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultOrderItemRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getAllOrderItemsService.getAllOrderItems());

        assertEquals("Could not get all order items due to an internal error.", exception.getMessage());
    }
}
