package davidrodriguez.com.uniquora.features.brand.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandDTOTest {

    @Test
    void shouldGetAllAttributes() {
        DefaultBrandDTO mockDefaultBrandDTO = new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );

        assertThat(mockDefaultBrandDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandDTO.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandDTO.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultBrandDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultBrandDTO newDefaultBrandDTO = getNewDefaultBrandDTO();

        assertThat(newDefaultBrandDTO.getId()).isEqualTo(2L);
        assertThat(newDefaultBrandDTO.getName()).isEqualTo("Test Brand 2");
        assertThat(newDefaultBrandDTO.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(newDefaultBrandDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultBrandDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    private DefaultBrandDTO getNewDefaultBrandDTO() {
        DefaultBrandDTO newDefaultBrandDTO = new DefaultBrandDTO();
        newDefaultBrandDTO.setId(2L);
        newDefaultBrandDTO.setName("Test Brand 2");
        newDefaultBrandDTO.setLogo("testLogoURL.com");
        newDefaultBrandDTO.setCreatedAt(MockDates.getCreatedAt());
        newDefaultBrandDTO.setUpdatedAt(MockDates.getUpdatedAt());

        return newDefaultBrandDTO;
    }
}
