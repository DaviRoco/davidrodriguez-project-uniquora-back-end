package davidrodriguez.com.uniquora.mockEntities.brand.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBrandEntity {
    public static DefaultBrandEntity createMockDefaultBrandEntity() {
        return new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                new Date(),
                new Date()
        );
    }

    public List<DefaultBrandEntity> createMockDefaultBrandEntityList(int count) {
        List<DefaultBrandEntity> brandEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            brandEntityList.add(new DefaultBrandEntity(
                    (long) i + 1,
                    "Test Brand",
                    "testLogoURL.com",
                    new Date(),
                    new Date()
            ));
        }

        return brandEntityList;
    }
}
