package davidrodriguez.com.uniquora.features.product.shared.mappers;

import davidrodriguez.com.uniquora.features.brand.shared.mappers.DefaultBrandMapper;
import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.mappers.DefaultProductImageMapper;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product.dtos.MockProductDTO;
import davidrodriguez.com.uniquora.mockEntities.product.entities.MockProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductMapperTest {
    private DefaultProductMapper mockDefaultProductMapper;

    @BeforeEach
    public void setUp() {
        mockDefaultProductMapper = new DefaultProductMapper(
                new DefaultBrandMapper(),
                new DefaultProductImageMapper()
        );
    }

    @Test
    void shouldNotMapProductDTOToProductWhenProductIsNull() {
        DefaultProductEntity mockDefaultProductEntity = mockDefaultProductMapper.toProductEntity(null);

        assertThat(mockDefaultProductEntity).isNull();
    }

    @Test
    void shouldMapProductToProductDTO() {
        DefaultProductEntity mockDefaultProductEntity = MockProductEntity.getMockDefaultProductEntity();

        DefaultProductDTO mockDefaultProductDTOMapped = mockDefaultProductMapper.toProductDTO(mockDefaultProductEntity);

        assertThat(mockDefaultProductDTOMapped).isNotNull()
                .extracting(DefaultProductDTO::getId)
                .isEqualTo(mockDefaultProductEntity.getId());
        assertThat(mockDefaultProductDTOMapped.getName()).isEqualTo(mockDefaultProductEntity.getName());
        assertThat(mockDefaultProductDTOMapped.getDescription()).isEqualTo(mockDefaultProductEntity.getDescription());
        assertThat(mockDefaultProductDTOMapped.getPrice()).isEqualTo(mockDefaultProductEntity.getPrice());
        assertThat(mockDefaultProductDTOMapped.getStockQuantity()).isEqualTo(mockDefaultProductEntity.getStockQuantity());
        assertThat(mockDefaultProductDTOMapped.getBrand().getId()).isEqualTo(mockDefaultProductEntity.getBrand().getId());
        assertThat(mockDefaultProductDTOMapped.getProductImages().get(0).getId()).isEqualTo(mockDefaultProductEntity.getProductImages().get(0).getId());
        assertThat(mockDefaultProductDTOMapped.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultProductDTOMapped.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldNotMapProductToProductDTOWhenProductDTOIsNull() {
        DefaultProductDTO mockDefaultProductDTO = mockDefaultProductMapper.toProductDTO(null);

        assertThat(mockDefaultProductDTO).isNull();
    }

    @Test
    void shouldMapProductDTOToProduct() {
        DefaultProductDTO mockDefaultProductDTO = MockProductDTO.getMockDefaultProductDTO();

        DefaultProductEntity mockDefaultProductEntity = mockDefaultProductMapper.toProductEntity(mockDefaultProductDTO);

        assertThat(mockDefaultProductEntity).isNotNull()
                .extracting(DefaultProductEntity::getId)
                .isEqualTo(mockDefaultProductDTO.getId());
        assertThat(mockDefaultProductEntity.getName()).isEqualTo(mockDefaultProductDTO.getName());
        assertThat(mockDefaultProductEntity.getDescription()).isEqualTo(mockDefaultProductDTO.getDescription());
        assertThat(mockDefaultProductEntity.getPrice()).isEqualTo(mockDefaultProductDTO.getPrice());
        assertThat(mockDefaultProductEntity.getStockQuantity()).isEqualTo(mockDefaultProductDTO.getStockQuantity());
        assertThat(mockDefaultProductEntity.getBrand().getId()).isEqualTo(mockDefaultProductDTO.getBrand().getId());
        assertThat(mockDefaultProductEntity.getProductImages().get(0).getId()).isEqualTo(mockDefaultProductDTO.getProductImages().get(0).getId());
        assertThat(mockDefaultProductEntity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultProductEntity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }
}
