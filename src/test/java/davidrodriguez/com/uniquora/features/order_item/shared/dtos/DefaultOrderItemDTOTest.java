package davidrodriguez.com.uniquora.features.order_item.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.order_item.dtos.MockOrderItemDTOList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.order_item.dtos.MockOrderItemDTO.getMockDefaultOrderItemDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOrderItemDTOTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultOrderItemDTO dto = getMockDefaultOrderItemDTO();

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getOrderId()).isEqualTo(100L);
        assertThat(dto.getProductId()).isEqualTo(200L);
        assertThat(dto.getQuantity()).isEqualTo(3);
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultOrderItemDTO> list = new MockOrderItemDTOList().createMockDefaultOrderItemDTOList(1);

        final DefaultOrderItemDTO dto = new DefaultOrderItemDTO();
        dto.setId(1L);
        dto.setOrderId(100L);
        dto.setProductId(200L);
        dto.setQuantity(2);

        assertThat(list.get(0).getId()).isEqualTo(dto.getId());
        assertThat(list.get(0).getOrderId()).isEqualTo(dto.getOrderId());
        assertThat(list.get(0).getProductId()).isEqualTo(dto.getProductId());
        assertThat(list.get(0).getQuantity()).isEqualTo(dto.getQuantity());
    }
}
