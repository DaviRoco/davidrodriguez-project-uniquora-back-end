package davidrodriguez.com.uniquora.mockEntities.category.dtos;

import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCategoryDTO {
    private static DefaultCategoryDTO instance;

    public MockCategoryDTO() {
    }

    public static DefaultCategoryDTO getMockDefaultCategoryDTO() {
        if (instance == null) {
            instance = new DefaultCategoryDTO(
                    1L,
                    "Test Name",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultCategoryDTO createNewMockDefaultCategoryDTO() {
        return new DefaultCategoryDTO(
                1L,
                "Test Name",
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
