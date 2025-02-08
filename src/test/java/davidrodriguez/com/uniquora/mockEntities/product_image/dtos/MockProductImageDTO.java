package davidrodriguez.com.uniquora.mockEntities.product_image.dtos;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;

import java.util.ArrayList;

public class MockProductImageDTO {
    public static DefaultProductImageDTO createMockDefaultProductImageDTO() {
        return new DefaultProductImageDTO(
                1L,
                "testProductImage.com"
        );
    }

    public ArrayList<DefaultProductImageDTO> createMockDefaultProductImageDTOList(int count) {
        ArrayList<DefaultProductImageDTO> productImageDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productImageDTOList.add(new DefaultProductImageDTO(
                    (long) i + 1,
                    "testProductImage.com"
            ));
        }

        return productImageDTOList;
    }
}
