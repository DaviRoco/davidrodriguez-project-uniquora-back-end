package davidrodriguez.com.uniquora.mockEntities.brand.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockBrandEntity {
    private static DefaultBrandEntity instance;

    private MockBrandEntity() {

    }

    public static DefaultBrandEntity getMockDefaultBrandEntity() {
        if (instance == null) {
            instance = new DefaultBrandEntity(
                    1L,
                    "Test Brand",
                    "testLogoURL.com",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultBrandEntity createNewMockDefaultBrandEntity() {
        return new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
