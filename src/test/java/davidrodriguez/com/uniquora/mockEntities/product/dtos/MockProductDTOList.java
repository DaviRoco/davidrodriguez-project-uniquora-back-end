package davidrodriguez.com.uniquora.mockEntities.product.dtos;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTO;
import davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTOList;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO.getMockDefaultBrandDTO;

public class MockProductDTOList {

    public List<DefaultProductDTO> createMockDefaultProductDTOList(int count) {
        List<DefaultProductDTO> productDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productDTOList.add(new DefaultProductDTO(
                    (long) i + 1,
                    "Test Product " + (i + 1),
                    "Test Product Description " + (i + 1),
                    100.0,
                    2,
                    getMockDefaultBrandDTO(),
                    new MockProductImageDTOList().createMockDefaultProductImageDTOList(2),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return productDTOList;
    }
}
