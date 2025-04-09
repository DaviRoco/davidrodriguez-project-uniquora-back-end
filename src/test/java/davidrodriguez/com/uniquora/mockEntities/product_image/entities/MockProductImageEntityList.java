package davidrodriguez.com.uniquora.mockEntities.product_image.entities;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;

import java.util.ArrayList;

public class MockProductImageEntityList {
    public ArrayList<DefaultProductImageEntity> createMockDefaultProductImageEntityList(int count) {
        final ArrayList<DefaultProductImageEntity> productImageEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productImageEntityList.add(new DefaultProductImageEntity(
                    (long) i + 1,
                    "testProductImage.com"
            ));
        }

        return productImageEntityList;
    }
}
