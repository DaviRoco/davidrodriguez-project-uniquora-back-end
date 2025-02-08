package davidrodriguez.com.uniquora.mockEntities.brand.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockBrandEntityList {

    public List<DefaultBrandEntity> createMockDefaultBrandEntityList(int count) {
        List<DefaultBrandEntity> brandEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            brandEntityList.add(new DefaultBrandEntity(
                    (long) i + 1,
                    "Test Brand",
                    "testLogoURL.com",
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return brandEntityList;
    }
}
