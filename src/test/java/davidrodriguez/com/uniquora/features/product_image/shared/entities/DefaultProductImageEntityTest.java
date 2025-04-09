package davidrodriguez.com.uniquora.features.product_image.shared.entities;

import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity.getMockDefaultProductImageEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductImageEntityTest {

    @Test
    void shouldGetAllAttributes() {
        final DefaultProductImageEntity mockDefaultProductImageEntity = getMockDefaultProductImageEntity();

        assertThat(mockDefaultProductImageEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductImageEntity.getImageUrl()).isEqualTo("testProductImage.com");
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultProductImageEntity> newDefaultProductImageEntity = new MockProductImageEntityList().createMockDefaultProductImageEntityList(1);

        final DefaultProductImageEntity mockDefaultProductImageEntitySet = new DefaultProductImageEntity();
        mockDefaultProductImageEntitySet.setId(1L);
        mockDefaultProductImageEntitySet.setImageUrl("testProductImage.com");

        assertThat(newDefaultProductImageEntity.get(0).getId()).isEqualTo(mockDefaultProductImageEntitySet.getId());
        assertThat(newDefaultProductImageEntity.get(0).getImageUrl()).isEqualTo(mockDefaultProductImageEntitySet.getImageUrl());
    }
}
