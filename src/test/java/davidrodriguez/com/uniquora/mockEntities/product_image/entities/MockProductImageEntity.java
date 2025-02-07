package davidrodriguez.com.uniquora.mockEntities.product_image.entities;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;

public class MockProductImageEntity {
    public static DefaultProductImageEntity createDefaultProductImageEntity() {
        return new DefaultProductImageEntity(
                1L,
                "testProductImage.com"
        );
    }


}
