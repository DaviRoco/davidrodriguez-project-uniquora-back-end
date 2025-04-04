package davidrodriguez.com.uniquora.features.order.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.order.dtos.MockOrderDTOList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.order.dtos.MockOrderDTO.getMockDefaultOrderDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOrderDTOTest {

    @Test
    void shouldGetAllAttributes() {
        DefaultOrderDTO dto = getMockDefaultOrderDTO();

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getUserId()).isEqualTo(10L);
        assertThat(dto.getStatus()).isEqualTo("IN_PROGRESS");
        assertThat(dto.getTotalPrice()).isEqualTo(99.99);
        assertThat(dto.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(dto.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultOrderDTO> mockList = new MockOrderDTOList().createMockDefaultOrderDTOList(1);

        DefaultOrderDTO dto = new DefaultOrderDTO();
        dto.setId(1L);
        dto.setUserId(10L);
        dto.setStatus("IN_PROGRESS");
        dto.setTotalPrice(99.99);
        dto.setCreatedAt(MockDates.getCreatedAt());
        dto.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(mockList.get(0).getId()).isEqualTo(dto.getId());
        assertThat(mockList.get(0).getUserId()).isEqualTo(dto.getUserId());
        assertThat(mockList.get(0).getStatus()).isEqualTo(dto.getStatus());
        assertThat(mockList.get(0).getTotalPrice()).isEqualTo(dto.getTotalPrice());
        assertThat(mockList.get(0).getCreatedAt()).isEqualTo(dto.getCreatedAt());
        assertThat(mockList.get(0).getUpdatedAt()).isEqualTo(dto.getUpdatedAt());
    }
}
