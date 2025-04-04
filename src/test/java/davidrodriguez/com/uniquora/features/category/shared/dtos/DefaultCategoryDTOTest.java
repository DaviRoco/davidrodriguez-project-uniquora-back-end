package davidrodriguez.com.uniquora.features.category.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.category.dtos.MockCategoryDTOList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.category.dtos.MockCategoryDTO.getMockDefaultCategoryDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCategoryDTOTest {

    @Test
    void shouldGetAllAttributes() {
        DefaultCategoryDTO mockDefaultCategoryDTO = getMockDefaultCategoryDTO();

        assertThat(mockDefaultCategoryDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultCategoryDTO.getName()).isEqualTo("Test Name");
        assertThat(mockDefaultCategoryDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultCategoryDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultCategoryDTO> newDefaultCategoryDTO = new MockCategoryDTOList().createMockDefaultCategoryDTOList(1);

        DefaultCategoryDTO mockDefaultCategoryDTOSet = new DefaultCategoryDTO();
        mockDefaultCategoryDTOSet.setId(1L);
        mockDefaultCategoryDTOSet.setName("Test Name 1");
        mockDefaultCategoryDTOSet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultCategoryDTOSet.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(newDefaultCategoryDTO.get(0).getId()).isEqualTo(mockDefaultCategoryDTOSet.getId());
        assertThat(newDefaultCategoryDTO.get(0).getName()).isEqualTo(mockDefaultCategoryDTOSet.getName());
        assertThat(newDefaultCategoryDTO.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultCategoryDTO.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }
}
