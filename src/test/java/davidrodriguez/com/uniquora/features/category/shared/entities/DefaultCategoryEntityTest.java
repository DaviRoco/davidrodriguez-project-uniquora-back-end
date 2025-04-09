package davidrodriguez.com.uniquora.features.category.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.category.entities.MockCategoryEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.category.entities.MockCategoryEntity.getMockDefaultCategoryEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCategoryEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultCategoryEntity mockDefaultCategoryEntity = getMockDefaultCategoryEntity();

        assertThat(mockDefaultCategoryEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultCategoryEntity.getName()).isEqualTo("Test Name");
        assertThat(mockDefaultCategoryEntity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultCategoryEntity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultCategoryEntity> newDefaultCategoryEntity = new MockCategoryEntityList().createMockDefaultCategoryEntityList(1);

        final DefaultCategoryEntity mockDefaultCategoryEntitySet = new DefaultCategoryEntity();
        mockDefaultCategoryEntitySet.setId(1L);
        mockDefaultCategoryEntitySet.setName("Test Name");
        mockDefaultCategoryEntitySet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultCategoryEntitySet.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(newDefaultCategoryEntity.get(0).getId()).isEqualTo(mockDefaultCategoryEntitySet.getId());
        assertThat(newDefaultCategoryEntity.get(0).getName()).isEqualTo(mockDefaultCategoryEntitySet.getName());
        assertThat(newDefaultCategoryEntity.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultCategoryEntity.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }
}
