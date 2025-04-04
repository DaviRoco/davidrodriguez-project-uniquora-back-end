package davidrodriguez.com.uniquora.features.cart.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.cart.dtos.MockCartDTOList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.cart.dtos.MockCartDTO.getMockDefaultCartDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCartDTOTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultCartDTO dto = getMockDefaultCartDTO();

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getUserId()).isEqualTo(100L);
        assertThat(dto.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(dto.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultCartDTO> dtoList = new MockCartDTOList().createMockDefaultCartDTOList(1);

        final DefaultCartDTO dto = new DefaultCartDTO();
        dto.setId(1L);
        dto.setUserId(100L);
        dto.setCreatedAt(MockDates.getCreatedAt());
        dto.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(dtoList.get(0).getId()).isEqualTo(dto.getId());
        assertThat(dtoList.get(0).getUserId()).isEqualTo(dto.getUserId());
        assertThat(dtoList.get(0).getCreatedAt()).isEqualTo(dto.getCreatedAt());
        assertThat(dtoList.get(0).getUpdatedAt()).isEqualTo(dto.getUpdatedAt());
    }
}
