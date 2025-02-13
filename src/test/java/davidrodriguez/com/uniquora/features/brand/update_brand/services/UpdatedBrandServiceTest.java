package davidrodriguez.com.uniquora.features.brand.update_brand.services;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.mappers.DefaultBrandMapper;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class UpdatedBrandServiceTest {
    @Mock
    private DefaultBrandRepository defaultBrandRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private DefaultBrandMapper defaultBrandMapper;

    @InjectMocks
    private UpdateBrandService updateBrandService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdateBrand() {
        DefaultBrandDTO inputDTO = MockBrandDTO.createNewMockDefaultBrandDTO();
        DefaultBrandEntity mappedEntity = MockBrandEntity.createNewMockDefaultBrandEntity();
        DefaultBrandEntity updatedEntity = MockBrandEntity.createNewMockDefaultBrandEntity();
        DefaultBrandDTO expectedDTO = MockBrandDTO.createNewMockDefaultBrandDTO();

        when(modelMapper.map(any(DefaultBrandDTO.class), eq(DefaultBrandEntity.class)))
                .thenReturn(mappedEntity);
        when(defaultBrandRepository.save(any(DefaultBrandEntity.class)))
                .thenReturn(updatedEntity);
        when(defaultBrandMapper.toBrandDTO(any(DefaultBrandEntity.class)))
                .thenReturn(expectedDTO);

        DefaultBrandDTO result = updateBrandService.updateBrand(inputDTO);

        verify(defaultBrandRepository, times(1)).save(any(DefaultBrandEntity.class));
        verify(modelMapper, times(1)).map(inputDTO, DefaultBrandEntity.class);
        verify(defaultBrandMapper, times(1)).toBrandDTO(updatedEntity);

        assertThat(result).isNotNull();
        assertEquals(expectedDTO.getId(), result.getId());
        assertEquals(expectedDTO.getName(), result.getName());
        assertEquals(expectedDTO.getLogo(), result.getLogo());
        assertThat(result.getCreatedAt()).isNotNull();
        assertThat(result.getUpdatedAt()).isNotNull();
    }
}
