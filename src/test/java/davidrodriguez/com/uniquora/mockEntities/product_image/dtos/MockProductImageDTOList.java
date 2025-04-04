package davidrodriguez.com.uniquora.mockEntities.product_image.dtos;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MockProductImageDTOList {
    public List<DefaultProductImageDTO> createMockDefaultProductImageDTOList(int count) {
        List<DefaultProductImageDTO> productImageDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            productImageDTOList.add(new DefaultProductImageDTO(
                    (long) i + 1,
                    "testProductImage.com"
            ));
        }

        return productImageDTOList;
    }
}
