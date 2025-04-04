package davidrodriguez.com.uniquora.mockEntities.cart.entities;

import davidrodriguez.com.uniquora.features.cart.shared.entities.DefaultCartEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCartEntity {
    private static DefaultCartEntity instance;

    private MockCartEntity() {}

    public static DefaultCartEntity getMockDefaultCartEntity() {
        if (instance == null) {
            instance = new DefaultCartEntity(
                    1L,
                    100L,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }
        return instance;
    }

    public static DefaultCartEntity createNewMockDefaultCartEntity() {
        return new DefaultCartEntity(
                1L,
                100L,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
