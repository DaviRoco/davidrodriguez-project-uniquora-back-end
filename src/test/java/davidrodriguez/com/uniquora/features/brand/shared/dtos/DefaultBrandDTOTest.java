package davidrodriguez.com.uniquora.features.brand.shared.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandDTOTest {
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    public void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
    }

    @Test
    void shouldGetAllAttributes() {
        DefaultBrandDTO mockDefaultBrandDTO = new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );

        assertThat(mockDefaultBrandDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandDTO.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandDTO.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandDTO.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultBrandDTO.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultBrandDTO newDefaultBrandDTO = getNewDefaultBrandDTO();

        assertThat(newDefaultBrandDTO.getId()).isEqualTo(2L);
        assertThat(newDefaultBrandDTO.getName()).isEqualTo("Test Brand 2");
        assertThat(newDefaultBrandDTO.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(newDefaultBrandDTO.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(newDefaultBrandDTO.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    private DefaultBrandDTO getNewDefaultBrandDTO() {
        DefaultBrandDTO newDefaultBrandDTO = new DefaultBrandDTO();
        newDefaultBrandDTO.setId(2L);
        newDefaultBrandDTO.setName("Test Brand 2");
        newDefaultBrandDTO.setLogo("testLogoURL.com");
        newDefaultBrandDTO.setCreatedAt(mockCreatedAt);
        newDefaultBrandDTO.setUpdatedAt(mockUpdatedAt);

        return newDefaultBrandDTO;
    }
}
