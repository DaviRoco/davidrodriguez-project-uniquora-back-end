package davidrodriguez.com.uniquora.mockEntities.product.entities;

import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.mockEntities.category.entities.MockCategoryEntityList;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;

import java.util.ArrayList;

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
                    new MockCategoryEntityList().createMockDefaultCategoryEntityList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultProductEntity getMockDefaultProductEntityForRepository() {

        return new DefaultProductEntity(
                1L,
                "Test Product",
                "Test Product Description",
                100.0,
                2,
                getMockDefaultBrandEntity(),
                new ArrayList<>(),
                new ArrayList<>(),
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
