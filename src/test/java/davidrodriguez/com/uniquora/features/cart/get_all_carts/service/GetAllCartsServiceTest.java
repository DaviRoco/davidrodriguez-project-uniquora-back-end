package davidrodriguez.com.uniquora.features.cart.get_all_carts.service;

import davidrodriguez.com.uniquora.features.cart.shared.dtos.DefaultCartDTO;
import davidrodriguez.com.uniquora.features.cart.shared.entities.DefaultCartEntity;
import davidrodriguez.com.uniquora.features.cart.shared.repositories.DefaultCartRepository;
import davidrodriguez.com.uniquora.mockEntities.cart.entities.MockCartEntityList;
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

public class GetAllCartsServiceTest {

    @Mock
    private DefaultCartRepository defaultCartRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllCartsService getAllCartsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllCarts() {
        final List<DefaultCartEntity> mockEntities = new MockCartEntityList().createMockDefaultCartEntityList(3);

        when(defaultCartRepository.findAll()).thenReturn(mockEntities);
        when(modelMapper.map(any(DefaultCartEntity.class), eq(DefaultCartDTO.class)))
                .thenAnswer(invocation -> {
                    final DefaultCartEntity entity = invocation.getArgument(0);
                    return new DefaultCartDTO(
                            entity.getId(),
                            entity.getUserId(),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt()
                    );
                });

        final List<DefaultCartDTO> result = getAllCartsService.getAllCarts();

        assertEquals(mockEntities.size(), result.size());
        assertThat(result)
                .extracting(DefaultCartDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultCartRepository.findAll()).thenThrow(new RuntimeException("DB failure"));

        final RuntimeException exception = assertThrows(RuntimeException.class, () ->
                getAllCartsService.getAllCarts());

        assertEquals("Could not get all carts due to an internal error.", exception.getMessage());
    }
}
