package davidrodriguez.com.uniquora.features.product.shared.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.category.entities.MockCategoryEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product.entities.MockProductEntity;
import davidrodriguez.com.uniquora.mockEntities.product.entities.MockProductEntityList;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductEntityTest {
    private DefaultProductEntity mockDefaultProductEntity;
    private DefaultBrandEntity mockBrand;
    private DefaultProductImageEntity mockProductImage;
    private ArrayList<DefaultProductImageEntity> mockProductImages;
    private ArrayList<DefaultCategoryEntity> mockCategories;

    @BeforeEach
    public void setUp() {
        mockBrand  = MockBrandEntity.getMockDefaultBrandEntity();

        mockProductImage = MockProductImageEntity.getMockDefaultProductImageEntity();

        mockProductImages = new MockProductImageEntityList().createMockDefaultProductImageEntityList(1);
        mockCategories = new MockCategoryEntityList().createMockDefaultCategoryEntityList(1);

        mockDefaultProductEntity = new DefaultProductEntity(
                1L,
                "Test Product Name",
                "Test Product Description",
                100.0,
                2,
                mockBrand,
                mockProductImages,
                mockCategories,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }

    @Test
    void shouldGetAllAttributes() {
        assertThat(mockDefaultProductEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductEntity.getName()).isEqualTo("Test Product Name");
        assertThat(mockDefaultProductEntity.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductEntity.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductEntity.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductEntity.getBrand().getId()).isEqualTo(mockBrand.getId());
        assertThat(mockDefaultProductEntity.getProductImages().get(0).getId()).isEqualTo(mockProductImage.getId());
        assertThat(mockDefaultProductEntity.getCategories().get(0).getId()).isEqualTo(mockCategories.get(0).getId());
        assertThat(mockDefaultProductEntity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultProductEntity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultProductEntity> mockDefaultProductEntity = new MockProductEntityList().createMockDefaultProductEntityList(1);

        DefaultProductEntity mockDefaultProductEntitySet = new DefaultProductEntity();
        mockDefaultProductEntitySet.setId(1L);
        mockDefaultProductEntitySet.setName("Test Product 1");
        mockDefaultProductEntitySet.setDescription("Test Product Description 1");
        mockDefaultProductEntitySet.setPrice(100.0);
        mockDefaultProductEntitySet.setStockQuantity(2);
        mockDefaultProductEntitySet.setBrand(mockBrand);
        mockDefaultProductEntitySet.setProductImages(mockProductImages);
        mockDefaultProductEntitySet.setCategories(mockCategories);
        mockDefaultProductEntitySet.setCreatedAt(MockDates.getCreatedAt());
        mockDefaultProductEntitySet.setUpdatedAt(MockDates.getUpdatedAt());


        assertThat(mockDefaultProductEntity.get(0).getId()).isEqualTo(mockDefaultProductEntitySet.getId());
        assertThat(mockDefaultProductEntity.get(0).getName()).isEqualTo(mockDefaultProductEntitySet.getName());
        assertThat(mockDefaultProductEntity.get(0).getDescription()).isEqualTo(mockDefaultProductEntitySet.getDescription());
        assertThat(mockDefaultProductEntity.get(0).getPrice()).isEqualTo(mockDefaultProductEntitySet.getPrice());
        assertThat(mockDefaultProductEntity.get(0).getStockQuantity()).isEqualTo(mockDefaultProductEntitySet.getStockQuantity());
        assertThat(mockDefaultProductEntity.get(0).getBrand().getId()).isEqualTo(mockBrand.getId());
        assertThat(mockDefaultProductEntity.get(0).getProductImages().get(0).getId()).isEqualTo(mockProductImage.getId());
        assertThat(mockDefaultProductEntity.get(0).getCategories().get(0).getId()).isEqualTo(mockCategories.get(0).getId());
        assertThat(mockDefaultProductEntity.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultProductEntity.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

}
