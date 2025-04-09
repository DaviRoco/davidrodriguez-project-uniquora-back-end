package davidrodriguez.com.uniquora.features.cart_item.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.cart_item.entities.MockCartItemEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.cart_item.entities.MockCartItemEntity.getMockDefaultCartItemEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCartItemEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultCartItemEntity entity = getMockDefaultCartItemEntity();

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getCartsId()).isEqualTo(1L);
        assertThat(entity.getProductsId()).isEqualTo(1L);
        assertThat(entity.getQuantity()).isEqualTo(3);
        assertThat(entity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(entity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultCartItemEntity> list = new MockCartItemEntityList().createMockDefaultCartItemEntityList(1);

        final DefaultCartItemEntity entity = new DefaultCartItemEntity();
        entity.setId(1L);
        entity.setCartsId(1L);
        entity.setProductsId(1L);
        entity.setQuantity(3);
        entity.setCreatedAt(MockDates.getCreatedAt());
        entity.setUpdatedAt(MockDates.getUpdatedAt());

        final DefaultCartItemEntity ref = list.get(0);
        assertThat(ref.getId()).isEqualTo(entity.getId());
        assertThat(ref.getCartsId()).isEqualTo(entity.getCartsId());
        assertThat(ref.getProductsId()).isEqualTo(entity.getProductsId());
        assertThat(ref.getQuantity()).isEqualTo(entity.getQuantity());
        assertThat(ref.getCreatedAt()).isEqualTo(entity.getCreatedAt());
        assertThat(ref.getUpdatedAt()).isEqualTo(entity.getUpdatedAt());
    }
}
