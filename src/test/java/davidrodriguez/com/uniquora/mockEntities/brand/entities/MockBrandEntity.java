package davidrodriguez.com.uniquora.mockEntities.brand.entities;

import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;

import java.util.Date;

public class MockBrandEntity {
    public static DefaultBrandEntity createDefaultBrandEntity() {
        return new DefaultBrandEntity(
                1L,
                "Test Brand",
                "testLogoURL.com",
                new Date(),
                new Date()
        );
    }
}
