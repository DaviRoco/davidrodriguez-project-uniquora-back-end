package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.repositories;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.repositories.DefaultProductImageRepository;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class GetAllProductImagesRepositoryTest {
    @Autowired
    private DefaultProductImageRepository defaultProductImageRepository;

    @Test
    void shouldFindAllProductImages() {
        DefaultProductImageEntity mockDefaultProductImageEntity = MockProductImageEntity.getMockDefaultProductImageEntity();
        defaultProductImageRepository.save(mockDefaultProductImageEntity);

        assertThat(defaultProductImageRepository.findAll()).hasSize(1);
        assertThat(defaultProductImageRepository.findAll().get(0).getId()).isEqualTo(mockDefaultProductImageEntity.getId());
        assertThat(defaultProductImageRepository.findAll().get(1).getImageUrl()).isEqualTo(mockDefaultProductImageEntity.getImageUrl());
    }
}
