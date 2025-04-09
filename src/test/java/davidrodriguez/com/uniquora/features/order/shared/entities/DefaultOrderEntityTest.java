package davidrodriguez.com.uniquora.features.order.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.order.entities.MockOrderEntityList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.order.entities.MockOrderEntity.getMockDefaultOrderEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOrderEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultOrderEntity entity = getMockDefaultOrderEntity();

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getUserId()).isEqualTo(10L);
        assertThat(entity.getStatus()).isEqualTo("IN_PROGRESS");
        assertThat(entity.getTotalPrice()).isEqualTo(99.99);
        assertThat(entity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(entity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultOrderEntity> mockList = new MockOrderEntityList().createMockDefaultOrderEntityList(1);

        final DefaultOrderEntity entity = new DefaultOrderEntity();
        entity.setId(1L);
        entity.setUserId(10L);
        entity.setStatus("IN_PROGRESS");
        entity.setTotalPrice(99.99);
        entity.setCreatedAt(MockDates.getCreatedAt());
        entity.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(mockList.get(0).getId()).isEqualTo(entity.getId());
        assertThat(mockList.get(0).getUserId()).isEqualTo(entity.getUserId());
        assertThat(mockList.get(0).getStatus()).isEqualTo(entity.getStatus());
        assertThat(mockList.get(0).getTotalPrice()).isEqualTo(entity.getTotalPrice());
        assertThat(mockList.get(0).getCreatedAt()).isEqualTo(entity.getCreatedAt());
        assertThat(mockList.get(0).getUpdatedAt()).isEqualTo(entity.getUpdatedAt());
    }
}
