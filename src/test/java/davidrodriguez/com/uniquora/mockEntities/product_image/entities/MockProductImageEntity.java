package davidrodriguez.com.uniquora.mockEntities.product_image.entities;

import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;

import java.util.ArrayList;

public class MockProductImageEntity {
    public static DefaultProductImageEntity createMockDefaultProductImageEntity() {
        return new DefaultProductImageEntity(
                1L,
                "testProductImage.com"
        );
    }

    public ArrayList<DefaultProductImageEntity> createMockDefaultProductImageEntityList(int count) {
        ArrayList<DefaultProductImageEntity> productImageEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productImageEntityList.add(new DefaultProductImageEntity(
                    (long) i + 1,
                    "testProductImage.com"
            ));
        }

        return productImageEntityList;
    }
}
