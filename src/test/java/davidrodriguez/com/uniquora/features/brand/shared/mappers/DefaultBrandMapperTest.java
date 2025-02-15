package davidrodriguez.com.uniquora.features.brand.shared.mappers;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandMapperTest {
    private DefaultBrandMapper mockDefaultBrandMapper;

    @BeforeEach
    void setUp() {
        mockDefaultBrandMapper = new DefaultBrandMapper();
    }

    @Test
    void shouldNotMapBrandDTOToBrandWhenBrandIsNull() {
        DefaultBrandEntity mockDefaultBrandEntityMapped = mockDefaultBrandMapper.toBrandEntity(null);

        assertThat(mockDefaultBrandEntityMapped).isNull();
    }

    @Test
    void shouldMapBrandToBrandDTO() {
        DefaultBrandEntity mockDefaultBrandEntity = MockBrandEntity.getMockDefaultBrandEntity();

        DefaultBrandDTO mockDefaultBrandDTOMapped = mockDefaultBrandMapper.toBrandDTO(mockDefaultBrandEntity);

        assertThat(mockDefaultBrandDTOMapped).isNotNull()
                .extracting(DefaultBrandDTO::getId)
                .isEqualTo(mockDefaultBrandEntity.getId());
        assertThat(mockDefaultBrandDTOMapped.getName()).isEqualTo(mockDefaultBrandEntity.getName());
        assertThat(mockDefaultBrandDTOMapped.getLogo()).isEqualTo(mockDefaultBrandEntity.getLogo());
        assertThat(mockDefaultBrandDTOMapped.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultBrandDTOMapped.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(mockDefaultBrandDTOMapped.isActive()).isEqualTo(mockDefaultBrandEntity.isActive());
    }

    @Test
    void shouldNotMapBrandToBrandDTOWhenBrandDTOIsNull() {
        DefaultBrandDTO mockDefaultBrandDTOMapped = mockDefaultBrandMapper.toBrandDTO(null);

        assertThat(mockDefaultBrandDTOMapped).isNull();
    }

    @Test
    void shouldMapBrandDTOToBrand() {
        DefaultBrandDTO mockDefaultBrandDTO = MockBrandDTO.getMockDefaultBrandDTO();

        DefaultBrandEntity mockDefaultBrandEntityMapped = mockDefaultBrandMapper.toBrandEntity(mockDefaultBrandDTO);

        assertThat(mockDefaultBrandEntityMapped).isNotNull()
                .extracting(DefaultBrandEntity::getId)
                .isEqualTo(mockDefaultBrandDTO.getId());
        assertThat(mockDefaultBrandEntityMapped.getName()).isEqualTo(mockDefaultBrandDTO.getName());
        assertThat(mockDefaultBrandEntityMapped.getLogo()).isEqualTo(mockDefaultBrandDTO.getLogo());
        assertThat(mockDefaultBrandEntityMapped.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultBrandEntityMapped.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(mockDefaultBrandEntityMapped.isActive()).isEqualTo(mockDefaultBrandDTO.isActive());
    }
}
