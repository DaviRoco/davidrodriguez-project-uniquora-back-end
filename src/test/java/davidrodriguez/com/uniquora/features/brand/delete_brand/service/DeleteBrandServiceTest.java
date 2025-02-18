package davidrodriguez.com.uniquora.features.brand.delete_brand.service;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntityList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class DeleteBrandServiceTest {
    @Mock
    private DefaultBrandRepository defaultBrandRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DeleteBrandService deleteBrandService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteBrandByIDWhenBrandExists() {
        List<DefaultBrandEntity>  mockDefaultBrandEntity = new MockBrandEntityList().createMockDefaultBrandEntityList(1);

        when(modelMapper.map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class))).thenAnswer(invocation -> MockBrandDTO.getMockDefaultBrandDTO());
        when(defaultBrandRepository.findById(mockDefaultBrandEntity.get(0).getId())).thenReturn(Optional.of(mockDefaultBrandEntity.get(0)));
        when(defaultBrandRepository.save(mockDefaultBrandEntity.get(0))).thenReturn(mockDefaultBrandEntity.get(0));

        DefaultBrandDTO defaultBrandDTO = deleteBrandService.deleteBrand(mockDefaultBrandEntity.get(0).getId());

        assertEquals(mockDefaultBrandEntity.get(0).getId(), defaultBrandDTO.getId());
        assertEquals(mockDefaultBrandEntity.get(0).getName(), defaultBrandDTO.getName());
        assertEquals(mockDefaultBrandEntity.get(0).getLogo(), defaultBrandDTO.getLogo());
    }

    @Test
    void shouldNotDeleteBrandByIDWhenBrandIsInactive() {
        List<DefaultBrandEntity>  mockDefaultBrandEntity = new MockBrandEntityList().createMockDefaultBrandEntityList(1);
        mockDefaultBrandEntity.get(0).setActive(false);

        when(modelMapper.map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class))).thenAnswer(invocation -> MockBrandDTO.getMockDefaultBrandDTO());
        when(defaultBrandRepository.findById(mockDefaultBrandEntity.get(0).getId())).thenReturn(Optional.of(mockDefaultBrandEntity.get(0)));

        DefaultBrandDTO defaultBrandDTO = deleteBrandService.deleteBrand(mockDefaultBrandEntity.get(0).getId());

        assertEquals(mockDefaultBrandEntity.get(0).getId(), defaultBrandDTO.getId());
        assertEquals(mockDefaultBrandEntity.get(0).getName(), defaultBrandDTO.getName());
        assertEquals(mockDefaultBrandEntity.get(0).getLogo(), defaultBrandDTO.getLogo());
    }

    @Test
    void shouldNotDeleteBrandWhenIdDoesNotExist() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> deleteBrandService.deleteBrand(null));
        assertEquals("Brand ID cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowGeneralExceptionBrand() {
        Exception exception = assertThrows(RuntimeException.class, () -> deleteBrandService.deleteBrand(1L));
        assertEquals("Could not delete brand due to an internal error.", exception.getMessage());
    }
}
