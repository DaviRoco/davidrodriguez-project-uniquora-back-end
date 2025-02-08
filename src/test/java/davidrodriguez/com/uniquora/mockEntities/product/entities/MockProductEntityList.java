package davidrodriguez.com.uniquora.mockEntities.product.entities;

import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.entities.MockProductImageEntityList;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.entities.MockBrandEntity.getMockDefaultBrandEntity;

public class MockProductEntityList {
    public List<DefaultProductEntity> createMockDefaultProductEntityList(int count) {
        List<DefaultProductEntity> productEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productEntityList.add(new DefaultProductEntity(
                    (long) i + 1,
                    "Test Product " + (i + 1),
                    "Test Product Description " + (i + 1),
                    100.0,
                    2,
                    getMockDefaultBrandEntity(),
                    new MockProductImageEntityList().createMockDefaultProductImageEntityList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return productEntityList;
    }
}
