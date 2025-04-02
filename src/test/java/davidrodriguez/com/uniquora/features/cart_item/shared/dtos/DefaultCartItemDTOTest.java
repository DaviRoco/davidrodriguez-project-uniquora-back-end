package davidrodriguez.com.uniquora.features.cart_item.shared.dtos;

import davidrodriguez.com.uniquora.mockEntities.cart_item.dtos.MockCartItemDTOList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.cart_item.dtos.MockCartItemDTO.getMockDefaultCartItemDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCartItemDTOTest {

    @Test
    void shouldGetAllAttributes() {
        DefaultCartItemDTO dto = getMockDefaultCartItemDTO();

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getCartsId()).isEqualTo(1L);
        assertThat(dto.getProductsId()).isEqualTo(1L);
        assertThat(dto.getQuantity()).isEqualTo(2);
        assertThat(dto.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(dto.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultCartItemDTO> newList = new MockCartItemDTOList().createMockDefaultCartItemDTOList(1);

        DefaultCartItemDTO dto = new DefaultCartItemDTO();
        dto.setId(1L);
        dto.setCartsId(1L);
        dto.setProductsId(1L);
        dto.setQuantity(2);
        dto.setCreatedAt(MockDates.getCreatedAt());
        dto.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(newList.get(0).getId()).isEqualTo(dto.getId());
        assertThat(newList.get(0).getCartsId()).isEqualTo(dto.getCartsId());
        assertThat(newList.get(0).getProductsId()).isEqualTo(dto.getProductsId());
        assertThat(newList.get(0).getQuantity()).isEqualTo(dto.getQuantity());
        assertThat(newList.get(0).getCreatedAt()).isEqualTo(dto.getCreatedAt());
        assertThat(newList.get(0).getUpdatedAt()).isEqualTo(dto.getUpdatedAt());
    }
}
