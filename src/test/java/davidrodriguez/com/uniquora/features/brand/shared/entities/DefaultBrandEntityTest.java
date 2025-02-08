package davidrodriguez.com.uniquora.features.brand.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandEntityTest {
    private DefaultBrandEntity mockDefaultBrandEntity;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    public void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
        mockDefaultBrandEntity = new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );
    }

    @Test
    void shouldGetAllAttributes() {
        DefaultBrandEntity mockDefaultBrandEntity = createMockDefaultBrandEntity();

        assertThat(mockDefaultBrandEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandEntity.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandEntity.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandEntity.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultBrandEntity.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultBrandEntity> newDefaultBrandEntity = new MockBrandEntity().createMockDefaultBrandEntityList(1);

        DefaultBrandEntity mockDefaultBrandEntitySet = new DefaultBrandEntity();
        mockDefaultBrandEntitySet.setId(1L);
        mockDefaultBrandEntitySet.setName("Test Brand 1");
        mockDefaultBrandEntitySet.setLogo("testLogoURL.com");
        mockDefaultBrandEntitySet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultBrandEntitySet.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(newDefaultBrandEntity.get(0).getId()).isEqualTo(mockDefaultBrandEntitySet.getId());
        assertThat(newDefaultBrandEntity.get(0).getName()).isEqualTo(mockDefaultBrandEntitySet.getName());
        assertThat(newDefaultBrandEntity.get(0).getLogo()).isEqualTo(mockDefaultBrandEntitySet.getLogo());
        assertThat(newDefaultBrandEntity.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultBrandEntity.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

}
