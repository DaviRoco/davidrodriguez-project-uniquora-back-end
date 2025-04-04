package davidrodriguez.com.uniquora.mockEntities.product_image.dtos;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;

public class MockProductImageDTO {
    private static DefaultProductImageDTO instance;

    private MockProductImageDTO() {

    }

    public static DefaultProductImageDTO getMockDefaultProductImageDTO() {
        if (instance == null) {
            instance = new DefaultProductImageDTO(
                    1L,
                    "testProductImage.com"
            );
        }

        return instance;
    }
}
