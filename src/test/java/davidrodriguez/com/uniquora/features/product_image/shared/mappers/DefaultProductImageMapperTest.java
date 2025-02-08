package davidrodriguez.com.uniquora.features.product_image.shared.mappers;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTO.getMockDefaultProductImageDTO;
import static davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity.getMockDefaultProductImageEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductImageMapperTest {
    private DefaultProductImageMapper mockDefaultProductImageMapper;

    @BeforeEach
    public void setUp() {
        mockDefaultProductImageMapper = new DefaultProductImageMapper();
    }

    @Test
    void shouldNotMapProductImageDTOToProductImageWhenProductImageIsNull() {
        DefaultProductImageEntity mockDefaultProductImageEntity = mockDefaultProductImageMapper.toProductImageEntity(null);

        assertThat(mockDefaultProductImageEntity).isNull();
    }

    @Test
    void shouldMapProductImageToProductImageDTO() {
        DefaultProductImageEntity mockDefaultProductImageEntity = getMockDefaultProductImageEntity();

        DefaultProductImageDTO mockDefaultProductImageDTO = mockDefaultProductImageMapper.toProductImageDTO(mockDefaultProductImageEntity);

        assertThat(mockDefaultProductImageDTO).isNotNull()
                .extracting(DefaultProductImageDTO::getId)
                .isEqualTo(mockDefaultProductImageEntity.getId());
        assertThat(mockDefaultProductImageDTO.getImageUrl()).isEqualTo(mockDefaultProductImageEntity.getImageUrl());
    }

    @Test
    void shouldNotMapProductImageToProductImageDTOWhenProductImageDTOIsNull() {
        DefaultProductImageDTO mockDefaultProductImageDTO = mockDefaultProductImageMapper.toProductImageDTO(null);

        assertThat(mockDefaultProductImageDTO).isNull();
    }

    @Test
    void shouldMapProductImageDTOToProductImage() {
        DefaultProductImageDTO mockDefaultProductImageDTO = getMockDefaultProductImageDTO();

        DefaultProductImageEntity mockDefaultProductImageEntity = mockDefaultProductImageMapper.toProductImageEntity(mockDefaultProductImageDTO);

        assertThat(mockDefaultProductImageEntity).isNotNull()
                .extracting(DefaultProductImageEntity::getId)
                .isEqualTo(mockDefaultProductImageDTO.getId());
        assertThat(mockDefaultProductImageDTO.getImageUrl()).isEqualTo(mockDefaultProductImageEntity.getImageUrl());
    }

    @Test
    void shouldNotMapProductImageListToProductImageDTOListWhenProductImageListIsNull() {
        ArrayList<DefaultProductImageDTO> mockDefaultProductImageDTOList = mockDefaultProductImageMapper.toProductImageDTOArrayList(null);

        assertThat(mockDefaultProductImageDTOList).isNull();
    }

    @Test
    void shouldNotMapProductImageDTOListToProductImageListWhenProductImageDTOListIsNull() {
        ArrayList<DefaultProductImageEntity> mockDefaultProductImageEntityList = mockDefaultProductImageMapper.toProductImageEntityArrayList(null);

        assertThat(mockDefaultProductImageEntityList).isNull();
    }
}
