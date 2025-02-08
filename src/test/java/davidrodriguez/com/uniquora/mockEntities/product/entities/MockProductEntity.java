package davidrodriguez.com.uniquora.mockEntities.product.entities;

import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntity;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;

import static davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity.getMockDefaultBrandEntity;

public class MockProductEntity {
    private static DefaultProductEntity instance;

    private MockProductEntity() {

    }

    public static DefaultProductEntity getMockDefaultProductEntity() {
        if (instance == null) {
            instance = new DefaultProductEntity(
                    1L,
                    "Test Product",
                    "Test Product Description",
                    100.0,
                    2,
                    getMockDefaultBrandEntity(),
                    new MockProductImageEntityList().createMockDefaultProductImageEntityList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }
}
