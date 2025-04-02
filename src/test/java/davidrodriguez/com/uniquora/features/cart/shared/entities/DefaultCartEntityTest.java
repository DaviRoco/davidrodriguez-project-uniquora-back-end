package davidrodriguez.com.uniquora.features.cart.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.cart.entities.MockCartEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.cart.entities.MockCartEntity.getMockDefaultCartEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCartEntityTest {

    @Test
    void shouldGetAllAttributes() {
        DefaultCartEntity entity = getMockDefaultCartEntity();

        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getUserId()).isEqualTo(100L);
        assertThat(entity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(entity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test|
    void shouldSetAllAttributes() {
        List<DefaultCartEntity> entityList = new MockCartEntityList().createMockDefaultCartEntityList(1);

        DefaultCartEntity entity = new DefaultCartEntity();
        entity.setId(1L);
        entity.setUserId(100L);
        entity.setCreatedAt(MockDates.getCreatedAt());
        entity.setUpdatedAt(MockDates.getUpdatedAt());

        assertThat(entityList.get(0).getId()).isEqualTo(entity.getId());
        assertThat(entityList.get(0).getUserId()).isEqualTo(entity.getUserId());
        assertThat(entityList.get(0).getCreatedAt()).isEqualTo(entity.getCreatedAt());
        assertThat(entityList.get(0).getUpdatedAt()).isEqualTo(entity.getUpdatedAt());
    }
}
