package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.service;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.repositories.DefaultProductImageRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;
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

public class GetAllProductImagesServiceTest {
    @Mock
    private DefaultProductImageRepository defaultProductImageRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllProductImagesService getAllProductImagesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllProductImages() {
        List<DefaultProductImageEntity> mockDefaultProductImageEntities = new MockProductImageEntityList().createMockDefaultProductImageEntityList(3);

        when(defaultProductImageRepository.findAll()).thenReturn(mockDefaultProductImageEntities);
        when(modelMapper.map(any(DefaultProductImageEntity.class), eq(DefaultProductImageDTO.class)))
                .thenAnswer(invocation -> {
                    DefaultProductImageEntity entity = invocation.getArgument(0);
                    return new DefaultProductImageDTO(
                            entity.getId(),
                            entity.getImageUrl()
                    );
                });

        List<DefaultProductImageDTO> defaultProductImageDTOList = getAllProductImagesService.getAllProductImages();

        assertThat(mockDefaultProductImageEntities.size()).isEqualTo(defaultProductImageDTOList.size());
        assertThat(defaultProductImageDTOList.size()).isEqualTo(3);
        assertThat(defaultProductImageDTOList)
                .isNotEmpty()
                .extracting(DefaultProductImageDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultProductImageRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getAllProductImagesService.getAllProductImages());

        assertEquals("Could not get all product images due to an internal error.", exception.getMessage());
    }
}
