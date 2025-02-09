package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.repositories;

import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import davidrodriguez.com.uniquora.features.product.shared.repositories.DefaultProductRepository;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.repositories.DefaultProductImageRepository;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.product.entities.MockProductEntity;
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

    @Autowired
    private DefaultProductRepository defaultProductRepository;

    @Autowired
    private DefaultBrandRepository defaultBrandRepository;

    @Test
    void shouldFindAllProductImages() {
        var brand = MockBrandEntity.getMockDefaultBrandEntity();
        defaultBrandRepository.saveAndFlush(brand);

        var product = MockProductEntity.getMockDefaultProductEntityForRepository();
        product.setBrand(brand);
        defaultProductRepository.saveAndFlush(product);

        var productImage = MockProductImageEntity.getMockDefaultProductImageEntity();
        defaultProductImageRepository.saveAndFlush(productImage);

        product.getProductImages().add(productImage);
        defaultProductRepository.saveAndFlush(product);

        assertThat(defaultProductImageRepository.findAll()).hasSize(1);
        assertThat(defaultProductImageRepository.findAll().get(0).getId()).isEqualTo(productImage.getId());
    }
}
