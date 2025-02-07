package davidrodriguez.com.uniquora.mockEntities.product.dtos;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.brand.dtos.MockBrandDTO.createDefaultBrandDTO;
import static davidrodriguez.com.uniquora.mockEntities.product_image.dtos.MockProductImageDTO.createDefaultProductImageDTOList;

public class MockProductDTO {
    public static DefaultProductDTO createDefaultProductDTO() {
        return new DefaultProductDTO(
                1L,
                "Test Product",
                "Test Product Description",
                100.0,
                2,
                createDefaultBrandDTO(),
                createDefaultProductImageDTOList(2),
                new Date(),
                new Date()
        );
    }

    public static List<DefaultProductDTO> createDefaultProductDTOList(int count) {
        List<DefaultProductDTO> productDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productDTOList.add(new DefaultProductDTO(
                    (long) i + 1,
                    "Test Product " + (i + 1),
                    "Test Product Description " + (i + 1),
                    100.0,
                    2,
                    createDefaultBrandDTO(),
                    createDefaultProductImageDTOList(2),
                    new Date(),
                    new Date()
            ));
        }

        return productDTOList;
    }
}
