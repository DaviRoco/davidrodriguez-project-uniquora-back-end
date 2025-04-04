package davidrodriguez.com.uniquora.mockEntities.category.entities;

import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCategoryEntity {
    private static DefaultCategoryEntity instance;

    private MockCategoryEntity() {
    }

    public static DefaultCategoryEntity getMockDefaultCategoryEntity() {
        if (instance == null) {
            instance = new DefaultCategoryEntity(
                    1L,
                    "Test Name",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultCategoryEntity createNewMockDefaultCategoryEntity() {
        return new DefaultCategoryEntity(
                1L,
                "Test Name",
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
