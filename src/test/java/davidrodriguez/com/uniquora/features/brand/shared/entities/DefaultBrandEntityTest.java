package davidrodriguez.com.uniquora.features.brand.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity.getMockDefaultBrandEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultBrandEntity mockDefaultBrandEntity = getMockDefaultBrandEntity();

        assertThat(mockDefaultBrandEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandEntity.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandEntity.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandEntity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultBrandEntity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(mockDefaultBrandEntity.isActive()).isEqualTo(true);
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultBrandEntity> newDefaultBrandEntity = new MockBrandEntityList().createMockDefaultBrandEntityList(1);

        final DefaultBrandEntity mockDefaultBrandEntitySet = new DefaultBrandEntity();
        mockDefaultBrandEntitySet.setId(1L);
        mockDefaultBrandEntitySet.setName("Test Brand");
        mockDefaultBrandEntitySet.setLogo("testLogoURL.com");
        mockDefaultBrandEntitySet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultBrandEntitySet.setUpdatedAt(MockDates.getUpdatedAt());
        mockDefaultBrandEntitySet.setActive(true);

        assertThat(newDefaultBrandEntity.get(0).getId()).isEqualTo(mockDefaultBrandEntitySet.getId());
        assertThat(newDefaultBrandEntity.get(0).getName()).isEqualTo(mockDefaultBrandEntitySet.getName());
        assertThat(newDefaultBrandEntity.get(0).getLogo()).isEqualTo(mockDefaultBrandEntitySet.getLogo());
        assertThat(newDefaultBrandEntity.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultBrandEntity.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(newDefaultBrandEntity.get(0).isActive()).isEqualTo(mockDefaultBrandEntitySet.isActive());
    }

}
