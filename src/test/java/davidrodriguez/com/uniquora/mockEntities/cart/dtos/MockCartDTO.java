package davidrodriguez.com.uniquora.mockEntities.cart.dtos;

import davidrodriguez.com.uniquora.features.cart.shared.dtos.DefaultCartDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCartDTO {
    private static DefaultCartDTO instance;

    private MockCartDTO() {}

    public static DefaultCartDTO getMockDefaultCartDTO() {
        if (instance == null) {
            instance = new DefaultCartDTO(
                    1L,
                    100L,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }
        return instance;
    }

    public static DefaultCartDTO createNewMockDefaultCartDTO() {
        return new DefaultCartDTO(
                1L,
                100L,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
