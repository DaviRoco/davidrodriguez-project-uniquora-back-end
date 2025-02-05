package davidrodriguez.com.uniquora.features.brand.shared.entities;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
        assertThat(mockDefaultBrandEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandEntity.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandEntity.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandEntity.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultBrandEntity.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultBrandEntity newDefaultBrandEntity = getNewDefaultBrandEntity();

        assertThat(newDefaultBrandEntity.getId()).isEqualTo(2L);
        assertThat(newDefaultBrandEntity.getName()).isEqualTo("Test Brand 2");
        assertThat(newDefaultBrandEntity.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(newDefaultBrandEntity.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(newDefaultBrandEntity.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    private DefaultBrandEntity getNewDefaultBrandEntity() {
        DefaultBrandEntity newDefaultBrandEntity = new DefaultBrandEntity();
        newDefaultBrandEntity.setId(2L);
        newDefaultBrandEntity.setName("Test Brand 2");
        newDefaultBrandEntity.setLogo("testLogoURL.com");
        newDefaultBrandEntity.setCreatedAt(mockCreatedAt);
        newDefaultBrandEntity.setUpdatedAt(mockUpdatedAt);

        return newDefaultBrandEntity;
    }
}
