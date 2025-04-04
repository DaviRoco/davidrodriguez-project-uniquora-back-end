package davidrodriguez.com.uniquora.mockEntities.cart_item.entities;

import davidrodriguez.com.uniquora.features.cart_item.shared.entities.DefaultCartItemEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCartItemEntity {
    private static DefaultCartItemEntity instance;

    private MockCartItemEntity() {
    }

    public static DefaultCartItemEntity getMockDefaultCartItemEntity() {
        if (instance == null) {
            instance = new DefaultCartItemEntity(
                    1L,
                    1L,
                    1L,
                    3,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultCartItemEntity createNewMockDefaultCartItemEntity() {
        return new DefaultCartItemEntity(
                1L,
                1L,
                1L,
                3,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
