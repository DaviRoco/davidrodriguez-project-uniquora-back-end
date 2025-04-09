package davidrodriguez.com.uniquora.features.product_image.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTOList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTO.getMockDefaultProductImageDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductImageDTOTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultProductImageDTO mockDefaultProductImageDTO = getMockDefaultProductImageDTO();

        assertThat(mockDefaultProductImageDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductImageDTO.getImageUrl()).isEqualTo("testProductImage.com");
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultProductImageDTO> newDefaultProductImageDTO = new MockProductImageDTOList().createMockDefaultProductImageDTOList(1);

        final DefaultProductImageDTO mockDefaultProductImageDTOSet = new DefaultProductImageDTO();
        mockDefaultProductImageDTOSet.setId(1L);
        mockDefaultProductImageDTOSet.setImageUrl("testProductImage.com");

        assertThat(newDefaultProductImageDTO.get(0).getId()).isEqualTo(mockDefaultProductImageDTOSet.getId());
        assertThat(newDefaultProductImageDTO.get(0).getImageUrl()).isEqualTo(mockDefaultProductImageDTOSet.getImageUrl());
    }
}
