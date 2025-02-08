package davidrodriguez.com.uniquora.mockEntities.product.entities;

import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity.createMockDefaultBrandEntity;

public class MockProductEntity {
    public static DefaultProductEntity createMockDefaultProductDTO() {
        return new DefaultProductEntity(
                1L,
                "Test Product",
                "Test Product Description",
                100.0,
                2,
                createMockDefaultBrandEntity(),
                new MockProductImageEntity().createMockDefaultProductImageEntityList(2),
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }

    public List<DefaultProductEntity> createMockDefaultProductDTOList(int count) {
        List<DefaultProductEntity> productEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productEntityList.add(new DefaultProductEntity(
                    (long) i + 1,
                    "Test Product " + (i + 1),
                    "Test Product Description " + (i + 1),
                    100.0,
                    2,
                    createMockDefaultBrandEntity(),
                    new MockProductImageEntity().createMockDefaultProductImageEntityList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return productEntityList;
    }
}
