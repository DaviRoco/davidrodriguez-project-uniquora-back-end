package davidrodriguez.com.uniquora.mockEntities.product.dtos;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTO;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO.createMockDefaultBrandDTO;

public class MockProductDTO {
    public static DefaultProductDTO createMockDefaultProductDTO() {
        return new DefaultProductDTO(
                1L,
                "Test Product",
                "Test Product Description",
                100.0,
                2,
                createMockDefaultBrandDTO(),
                new MockProductImageDTO().createMockDefaultProductImageDTOList(2),
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }

    public List<DefaultProductDTO> createMockDefaultProductDTOList(int count) {
        List<DefaultProductDTO> productDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productDTOList.add(new DefaultProductDTO(
                    (long) i + 1,
                    "Test Product " + (i + 1),
                    "Test Product Description " + (i + 1),
                    100.0,
                    2,
                    createMockDefaultBrandDTO(),
                    new MockProductImageDTO().createMockDefaultProductImageDTOList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return productDTOList;
    }
}
