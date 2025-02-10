package davidrodriguez.com.uniquora.mockEntities.brand.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockBrandDTO {
    private static DefaultBrandDTO instance;

    private MockBrandDTO() {

    }

    public static DefaultBrandDTO getMockDefaultBrandDTO() {
        if (instance == null) {
            instance = new DefaultBrandDTO(
                    1L,
                    "Test Brand",
                    "testLogoURL.com",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultBrandDTO createNewMockDefaultBrandDTO() {
        return new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
