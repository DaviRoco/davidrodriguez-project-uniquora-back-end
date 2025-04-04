package davidrodriguez.com.uniquora.mockEntities.product_image.entities;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;

public class MockProductImageEntity {
    private static DefaultProductImageEntity instance;

    private MockProductImageEntity() {

    }

    public static DefaultProductImageEntity getMockDefaultProductImageEntity() {
        if (instance == null) {
            instance = new DefaultProductImageEntity(
                    1L,
                    "testProductImage.com"
            );
        }

        return instance;
    }
}
