package davidrodriguez.com.uniquora.mockEntities.product.dtos;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTOList;

import static davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO.getMockDefaultBrandDTO;

public class MockProductDTO {
    private static DefaultProductDTO instance;

    private MockProductDTO() {

    }

    public static DefaultProductDTO getMockDefaultProductDTO() {
        if (instance == null) {
            instance = new DefaultProductDTO(
                    1L,
                    "Test Product",
                    "Test Product Description",
                    100.0,
                    2,
                    getMockDefaultBrandDTO(),
                    new MockProductImageDTOList().createMockDefaultProductImageDTOList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }
}
