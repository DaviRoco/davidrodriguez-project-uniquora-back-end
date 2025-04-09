package davidrodriguez.com.uniquora.features.order_item.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.order_item.entities.MockOrderItemEntityList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.order_item.entities.MockOrderItemEntity.getMockDefaultOrderItemEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOrderItemEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultOrderItemEntity entity = getMockDefaultOrderItemEntity();

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getOrderId()).isEqualTo(100L);
        assertThat(entity.getProductId()).isEqualTo(200L);
        assertThat(entity.getQuantity()).isEqualTo(3);
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultOrderItemEntity> list = new MockOrderItemEntityList().createMockDefaultOrderItemEntityList(1);

        final DefaultOrderItemEntity entity = new DefaultOrderItemEntity();
        entity.setId(1L);
        entity.setOrderId(100L);
        entity.setProductId(200L);
        entity.setQuantity(2);

        assertThat(list.get(0).getId()).isEqualTo(entity.getId());
        assertThat(list.get(0).getOrderId()).isEqualTo(entity.getOrderId());
        assertThat(list.get(0).getProductId()).isEqualTo(entity.getProductId());
        assertThat(list.get(0).getQuantity()).isEqualTo(entity.getQuantity());
    }
}
