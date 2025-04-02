package davidrodriguez.com.uniquora.mockEntities.category.entities;

import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCategoryEntityList {

    public List<DefaultCategoryEntity> createMockDefaultCategoryEntityList(int count) {
        List<DefaultCategoryEntity> categoryEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            categoryEntityList.add(new DefaultCategoryEntity(
                    (long) i + 1,
                    "Test Name",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return categoryEntityList;
    }
}
