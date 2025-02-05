package davidrodriguez.com.uniquora.features.brand.shared.mappers;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandMapperTest {
    private DefaultBrandMapper mockDefaultBrandMapper;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
        mockDefaultBrandMapper = new DefaultBrandMapper();
    }

    @Test
    void shouldMapBrandToBrandDTO() {
        DefaultBrandEntity mockDefaultBrandEntity = new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );

        DefaultBrandDTO mockDefaultBrandDTOMapped = mockDefaultBrandMapper.toBrandDTO(mockDefaultBrandEntity);

        assertThat(mockDefaultBrandDTOMapped).isNotNull()
                .extracting(DefaultBrandDTO::getId)
                .isEqualTo(mockDefaultBrandEntity.getId());
        assertThat(mockDefaultBrandDTOMapped.getName()).isEqualTo(mockDefaultBrandEntity.getName());
        assertThat(mockDefaultBrandDTOMapped.getLogo()).isEqualTo(mockDefaultBrandEntity.getLogo());
        assertThat(mockDefaultBrandDTOMapped.getCreatedAt()).isEqualTo(mockDefaultBrandEntity.getCreatedAt());
        assertThat(mockDefaultBrandDTOMapped.getUpdatedAt()).isEqualTo(mockDefaultBrandEntity.getUpdatedAt());
    }

    @Test
    void shouldNotMapBrandToBrandDTOWhenBrandIsNull() {
        DefaultBrandDTO mockDefaultBrandDTOMapped = mockDefaultBrandMapper.toBrandDTO(null);

        assertThat(mockDefaultBrandDTOMapped).isNull();
    }

    @Test
    void shouldMapBrandDTOToBrand() {
        DefaultBrandDTO mockDefaultBrandDTO = new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );

        DefaultBrandEntity mockDefaultBrandEntityMapped = mockDefaultBrandMapper.toBrandEntity(mockDefaultBrandDTO);

        assertThat(mockDefaultBrandEntityMapped).isNotNull()
                .extracting(DefaultBrandEntity::getId)
                .isEqualTo(mockDefaultBrandDTO.getId());
        assertThat(mockDefaultBrandEntityMapped.getName()).isEqualTo(mockDefaultBrandDTO.getName());
        assertThat(mockDefaultBrandEntityMapped.getLogo()).isEqualTo(mockDefaultBrandDTO.getLogo());
        assertThat(mockDefaultBrandEntityMapped.getCreatedAt()).isEqualTo(mockDefaultBrandDTO.getCreatedAt());
        assertThat(mockDefaultBrandEntityMapped.getUpdatedAt()).isEqualTo(mockDefaultBrandDTO.getUpdatedAt());
    }
}
