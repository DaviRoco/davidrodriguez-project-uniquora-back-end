package davidrodriguez.com.uniquora.features.brand.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTOList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO.getMockDefaultBrandDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultBrandDTOTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultBrandDTO mockDefaultBrandDTO = getMockDefaultBrandDTO();

        assertThat(mockDefaultBrandDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultBrandDTO.getName()).isEqualTo("Test Brand");
        assertThat(mockDefaultBrandDTO.getLogo()).isEqualTo("testLogoURL.com");
        assertThat(mockDefaultBrandDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultBrandDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(mockDefaultBrandDTO.isActive()).isEqualTo(true);
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultBrandDTO> newDefaultBrandDTO = new MockBrandDTOList().createMockDefaultBrandDTOList(1);

        final DefaultBrandDTO mockDefaultBrandDTOSet = new DefaultBrandDTO();
        mockDefaultBrandDTOSet.setId(1L);
        mockDefaultBrandDTOSet.setName("Test Brand");
        mockDefaultBrandDTOSet.setLogo("testLogoURL.com");
        mockDefaultBrandDTOSet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultBrandDTOSet.setUpdatedAt(MockDates.getUpdatedAt());
        mockDefaultBrandDTOSet.setActive(true);

        assertThat(newDefaultBrandDTO.get(0).getId()).isEqualTo(mockDefaultBrandDTOSet.getId());
        assertThat(newDefaultBrandDTO.get(0).getName()).isEqualTo(mockDefaultBrandDTOSet.getName());
        assertThat(newDefaultBrandDTO.get(0).getLogo()).isEqualTo(mockDefaultBrandDTOSet.getLogo());
        assertThat(newDefaultBrandDTO.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultBrandDTO.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
        assertThat(newDefaultBrandDTO.get(0).isActive()).isEqualTo(mockDefaultBrandDTOSet.isActive());
    }

}
