package davidrodriguez.com.uniquora.features.brand.create_brand.service;

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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class CreateBandServiceTest {
    @Mock
    private DefaultBrandRepository defaultBrandRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CreateBrandService createBrandService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateBrand() {
        DefaultBrandDTO defaultBrandDTO = MockBrandDTO.createNewMockDefaultBrandDTO();
        DefaultBrandEntity defaultBrandEntity = MockBrandEntity.createNewMockDefaultBrandEntity();

        when(modelMapper.map(defaultBrandDTO, DefaultBrandEntity.class)).thenReturn(defaultBrandEntity);
        when(defaultBrandRepository.save(defaultBrandEntity)).thenReturn(defaultBrandEntity);
        when(modelMapper.map(defaultBrandEntity, DefaultBrandDTO.class)).thenReturn(defaultBrandDTO);

        DefaultBrandDTO result = createBrandService.createBrand(defaultBrandDTO);

        assertNotNull(result);
        assertEquals(defaultBrandDTO.getName(), result.getName());
        verify(defaultBrandRepository, times(1)).save(defaultBrandEntity);
    }

    @Test
    void  shouldCreateBrandWhenCreatedAndUpdatedDateAreNull() {
        DefaultBrandDTO defaultBrandDTO = new DefaultBrandDTO();
        defaultBrandDTO.setId(1L);
        defaultBrandDTO.setName("name");
        defaultBrandDTO.setLogo("logo");
        defaultBrandDTO.setCreatedAt(null);
        defaultBrandDTO.setUpdatedAt(null);
        defaultBrandDTO.setActive(true);

        DefaultBrandEntity defaultBrandEntity = MockBrandEntity.createNewMockDefaultBrandEntity();

        when(modelMapper.map(defaultBrandDTO, DefaultBrandEntity.class)).thenReturn(defaultBrandEntity);
        when(defaultBrandRepository.save(defaultBrandEntity)).thenReturn(defaultBrandEntity);
        when(modelMapper.map(defaultBrandEntity, DefaultBrandDTO.class)).thenReturn(defaultBrandDTO);

        DefaultBrandDTO result = createBrandService.createBrand(defaultBrandDTO);

        assertNotNull(result);
        assertEquals(defaultBrandDTO.getName(), result.getName());
        verify(defaultBrandRepository, times(1)).save(defaultBrandEntity);
    }
}
