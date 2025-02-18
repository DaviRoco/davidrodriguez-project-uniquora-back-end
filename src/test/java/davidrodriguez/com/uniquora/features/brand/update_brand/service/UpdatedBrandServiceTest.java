package davidrodriguez.com.uniquora.features.brand.update_brand.service;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

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

        when(defaultBrandRepository.findById(inputDTO.getId()))
                .thenReturn(Optional.of(mappedEntity));
        when(defaultBrandRepository.save(any(DefaultBrandEntity.class)))
                .thenReturn(updatedEntity);
        when(modelMapper.map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class)))
                .thenReturn(expectedDTO);

        DefaultBrandDTO result = updateBrandService.updateBrand(inputDTO);

        verify(defaultBrandRepository, times(1)).save(any(DefaultBrandEntity.class));
        verify(modelMapper, times(1)).map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class));

        assertThat(result).isNotNull();
        assertEquals(expectedDTO.getId(), result.getId());
        assertEquals(expectedDTO.getName(), result.getName());
        assertEquals(expectedDTO.getLogo(), result.getLogo());
        assertThat(result.getCreatedAt()).isNotNull();
        assertThat(result.getUpdatedAt()).isNotNull();
        assertThat(result.isActive()).isNotNull();
    }
}
