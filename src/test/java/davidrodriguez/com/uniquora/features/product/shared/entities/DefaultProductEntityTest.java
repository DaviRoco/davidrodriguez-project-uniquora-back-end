package davidrodriguez.com.uniquora.features.product.shared.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductEntityTest {
    private DefaultProductEntity mockDefaultProductEntity;
    private DefaultBrandEntity mockBrand;
    private DefaultProductImageEntity mockProductImage;
    private ArrayList<DefaultProductImageEntity> mockProductImages;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    public void setUp() {
        mockBrand  = new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );
        mockProductImage = new DefaultProductImageEntity(1L, "testImageURL");
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();

        mockProductImages = new ArrayList<>();
        mockProductImages.add(mockProductImage);

        mockDefaultProductEntity = new DefaultProductEntity(
                1L,
                "Test Product Name",
                "Test Product Description",
                100.0,
                2,
                mockBrand,
                mockProductImages,
                mockCreatedAt,
                mockUpdatedAt
        );
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockDefaultProductEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductEntity.getName()).isEqualTo("Test Product Name");
        assertThat(mockDefaultProductEntity.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductEntity.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductEntity.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductEntity.getBrand()).isEqualTo(mockBrand);
        assertThat(mockDefaultProductEntity.getProductImages().get(0)).isEqualTo(mockProductImage);
        assertThat(mockDefaultProductEntity.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultProductEntity.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultProductEntity mockDefaultProductEntity = getNewDefaultProductEntity();

        assertThat(mockDefaultProductEntity.getId()).isEqualTo(2L);
        assertThat(mockDefaultProductEntity.getName()).isEqualTo("Test Product Name 2");
        assertThat(mockDefaultProductEntity.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductEntity.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductEntity.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductEntity.getBrand()).isEqualTo(mockBrand);
        assertThat(mockDefaultProductEntity.getProductImages().get(0)).isEqualTo(mockProductImage);
        assertThat(mockDefaultProductEntity.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultProductEntity.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    private DefaultProductEntity getNewDefaultProductEntity() {
        DefaultProductEntity mockDefaultProductEntity = new DefaultProductEntity();
        mockDefaultProductEntity.setId(2L);
        mockDefaultProductEntity.setName("Test Product Name 2");
        mockDefaultProductEntity.setDescription("Test Product Description");
        mockDefaultProductEntity.setPrice(100.0);
        mockDefaultProductEntity.setStockQuantity(2);
        mockDefaultProductEntity.setBrand(mockBrand);
        mockDefaultProductEntity.setProductImages(mockProductImages);
        mockDefaultProductEntity.setCreatedAt(mockCreatedAt);
        mockDefaultProductEntity.setUpdatedAt(mockUpdatedAt);
        return mockDefaultProductEntity;
    }
}
