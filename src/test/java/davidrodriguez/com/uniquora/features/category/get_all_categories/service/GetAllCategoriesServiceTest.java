package davidrodriguez.com.uniquora.features.category.get_all_categories.service;

import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.features.category.shared.repositories.DefaultCategoryRepository;
import davidrodriguez.com.uniquora.mockEntities.category.entities.MockCategoryEntityList;
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

public class GetAllCategoriesServiceTest {

    @Mock
    private DefaultCategoryRepository defaultCategoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllCategoriesService getAllCategoriesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllCategories() {
        final List<DefaultCategoryEntity> mockDefaultCategoryEntities = new MockCategoryEntityList().createMockDefaultCategoryEntityList(3);

        when(defaultCategoryRepository.findAll()).thenReturn(mockDefaultCategoryEntities);
        when(modelMapper.map(any(DefaultCategoryEntity.class), eq(DefaultCategoryDTO.class)))
                .thenAnswer(invocation -> {
                    final DefaultCategoryEntity entity = invocation.getArgument(0);
                    return new DefaultCategoryDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getCreatedAt(),
                            entity.getUpdatedAt()
                    );
                });

        final List<DefaultCategoryDTO> defaultCategoryDTOList = getAllCategoriesService.getAllCategories();

        assertEquals(mockDefaultCategoryEntities.size(), defaultCategoryDTOList.size());
        assertThat(defaultCategoryDTOList)
                .isNotEmpty()
                .extracting(DefaultCategoryDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }

    @Test
    void shouldThrowException() {
        when(defaultCategoryRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        final RuntimeException exception = assertThrows(RuntimeException.class, () -> getAllCategoriesService.getAllCategories());

        assertEquals("Could not get all categories due to an internal error.", exception.getMessage());
    }
}
