package davidrodriguez.com.uniquora.features.brand.get_all_brands.service;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntityList;
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

public class GetAllBrandsServiceTest {
    @Mock
    private DefaultBrandRepository defaultBrandRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllBrandsService getAllBrandsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllBrands() {
        final List<DefaultBrandEntity> mockDefaultBrandEntities = new MockBrandEntityList().createMockDefaultBrandEntityList(3);


        when(defaultBrandRepository.findAll()).thenReturn(mockDefaultBrandEntities);
        when(modelMapper.map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class)))
                .thenAnswer(invocation -> {
                    final DefaultBrandEntity entity = invocation.getArgument(0);
                    return new DefaultBrandDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getLogo(),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt(),
                            entity.isActive()
                    );
                });
        final List<DefaultBrandDTO> defaultBrandDTOList = getAllBrandsService.getAllBrands();

        assertEquals(mockDefaultBrandEntities.size(), defaultBrandDTOList.size());
        assertThat(defaultBrandDTOList)
                .isNotEmpty()
                .extracting(DefaultBrandDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultBrandRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        final RuntimeException exception = assertThrows(RuntimeException.class, () ->  getAllBrandsService.getAllBrands());

        assertEquals("Could not get all brands due to an internal error.", exception.getMessage());
    }
}
