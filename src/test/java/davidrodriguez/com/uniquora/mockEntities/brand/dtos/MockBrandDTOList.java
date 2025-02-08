package davidrodriguez.com.uniquora.mockEntities.brand.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockBrandDTOList {

    public List<DefaultBrandDTO> createMockDefaultBrandDTOList(int count) {
        List<DefaultBrandDTO> brandDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            brandDTOList.add(new DefaultBrandDTO(
                    (long) i + 1,
                    "Test Brand",
                    "testLogoURL.com",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return brandDTOList;
    }
}
