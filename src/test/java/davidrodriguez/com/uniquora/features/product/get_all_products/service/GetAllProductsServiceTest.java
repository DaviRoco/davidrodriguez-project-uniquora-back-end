package davidrodriguez.com.uniquora.features.product.get_all_products.service;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.features.product.shared.repositories.DefaultProductRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.category.dtos.MockCategoryDTOList;
import davidrodriguez.com.uniquora.mockEntities.product.entities.MockProductEntityList;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTOList;
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

public class GetAllProductsServiceTest {
    @Mock
    private DefaultProductRepository defaultProductRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllProductsService getAllProductsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllProducts() {
        final List<DefaultProductEntity> mockDefaultProductEntities = new MockProductEntityList().createMockDefaultProductEntityList(3);

        when(defaultProductRepository.findAll()).thenReturn(mockDefaultProductEntities);
        when(modelMapper.map(any(DefaultProductEntity.class), eq(DefaultProductDTO.class)))
                .thenAnswer(invocation -> {
                    final DefaultProductEntity entity = invocation.getArgument(0);
                    return new DefaultProductDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getDescription(),
                            entity.getPrice(),
                            entity.getStockQuantity(),
                            MockBrandDTO.getMockDefaultBrandDTO(),
                            new MockProductImageDTOList().createMockDefaultProductImageDTOList(3),
                            new MockCategoryDTOList().createMockDefaultCategoryDTOList(3),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt()
                    );
                });
        final List<DefaultProductDTO> defaultProductDTOList = getAllProductsService.getAllProducts();

        assertEquals(mockDefaultProductEntities.size(), defaultProductDTOList.size());
        assertThat(defaultProductDTOList)
                .isNotEmpty()
                .extracting(DefaultProductDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultProductRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        final RuntimeException exception = assertThrows(RuntimeException.class, () ->  getAllProductsService.getAllProducts());

        assertEquals("Could not get all products due to an internal error.", exception.getMessage());
    }
}
