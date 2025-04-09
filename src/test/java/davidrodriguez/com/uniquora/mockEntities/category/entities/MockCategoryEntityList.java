package davidrodriguez.com.uniquora.mockEntities.category.entities;

import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;

public class MockCategoryEntityList {

    public ArrayList<DefaultCategoryEntity> createMockDefaultCategoryEntityList(int count) {
        final ArrayList<DefaultCategoryEntity> categoryEntityList = new ArrayList<>();

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
