package davidrodriguez.com.uniquora.mockEntities.brand.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;

import java.util.Date;

public class MockBrandDTO {
    public static DefaultBrandDTO createDefaultBrandDTO() {
        return new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                new Date(),
                new Date()
        );
    }
}
