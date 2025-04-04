package davidrodriguez.com.uniquora.features.brand.get_brand_by_id.service;

import davidrodriguez.com.uniquora.features.brand.get_brand_by_id.repository.GetBrandByIdRepository;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GetBrandByIdServiceTest {
    @Mock
    private GetBrandByIdRepository getBrandByIdRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetBrandByIdService getBrandByIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnBrandByIDWhenBrandExists() {
        final DefaultBrandEntity mockDefaultBrandEntity = MockBrandEntity.getMockDefaultBrandEntity();

        when(modelMapper.map(any(DefaultBrandEntity.class), eq(DefaultBrandDTO.class))).thenAnswer(invocation -> MockBrandDTO.getMockDefaultBrandDTO());
        when(getBrandByIdRepository.findBrandById(mockDefaultBrandEntity.getId())).thenReturn(Optional.of(mockDefaultBrandEntity));
        final DefaultBrandDTO result = getBrandByIdService.getBrandById(mockDefaultBrandEntity.getId());

        assertEquals(mockDefaultBrandEntity.getId(), result.getId());
        assertEquals(mockDefaultBrandEntity.getName(), result.getName());
        assertEquals(mockDefaultBrandEntity.getLogo(), result.getLogo());
    }

    @Test
    void shouldNotReturnBrandByIDWhenBrandDoesNotExist() {
        when(getBrandByIdRepository.findBrandById(any(Long.class))).thenReturn(Optional.empty());

        final Exception exception = assertThrows(RuntimeException.class, () -> getBrandByIdService.getBrandById(1L));

        assertEquals("Could not find brand by ID due to an internal error.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBrandIsNull() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> getBrandByIdService.getBrandById(null));

        assertEquals("Brand ID cannot be null.", exception.getMessage());
    }
}
