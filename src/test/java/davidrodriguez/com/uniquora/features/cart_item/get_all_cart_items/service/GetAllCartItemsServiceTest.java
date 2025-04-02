package davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.service;

import davidrodriguez.com.uniquora.features.cart_item.shared.dtos.DefaultCartItemDTO;
import davidrodriguez.com.uniquora.features.cart_item.shared.entities.DefaultCartItemEntity;
import davidrodriguez.com.uniquora.features.cart_item.shared.repositories.DefaultCartItemRepository;
import davidrodriguez.com.uniquora.mockEntities.cart_item.entities.MockCartItemEntityList;
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

public class GetAllCartItemsServiceTest {

    @Mock
    private DefaultCartItemRepository defaultCartItemRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllCartItemsService getAllCartItemsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllCartItems() {
        List<DefaultCartItemEntity> mockEntities = new MockCartItemEntityList().createMockDefaultCartItemEntityList(3);

        when(defaultCartItemRepository.findAll()).thenReturn(mockEntities);
        when(modelMapper.map(any(DefaultCartItemEntity.class), eq(DefaultCartItemDTO.class)))
                .thenAnswer(invocation -> {
                    DefaultCartItemEntity entity = invocation.getArgument(0);
                    return new DefaultCartItemDTO(
                            entity.getId(),
                            entity.getCartsId(),
                            entity.getProductsId(),
                            entity.getQuantity(),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt()
                    );
                });

        List<DefaultCartItemDTO> result = getAllCartItemsService.getAllCartItems();

        assertEquals(mockEntities.size(), result.size());
        assertThat(result)
                .isNotEmpty()
                .extracting(DefaultCartItemDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultCartItemRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getAllCartItemsService.getAllCartItems());

        assertEquals("Could not get all cart items due to an internal error.", exception.getMessage());
    }
}
