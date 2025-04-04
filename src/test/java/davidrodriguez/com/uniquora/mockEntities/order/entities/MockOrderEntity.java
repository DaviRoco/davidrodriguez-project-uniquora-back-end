package davidrodriguez.com.uniquora.mockEntities.order.entities;

import davidrodriguez.com.uniquora.enumerations.OrderStatus;
import davidrodriguez.com.uniquora.features.order.shared.entities.DefaultOrderEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockOrderEntity {
    private static DefaultOrderEntity instance;

    private MockOrderEntity() {}

    public static DefaultOrderEntity getMockDefaultOrderEntity() {
        if (instance == null) {
            instance = new DefaultOrderEntity(
                    1L,
                    10L,
                    OrderStatus.IN_PROGRESS.name(),
                    99.99,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }
        return instance;
    }

    public static DefaultOrderEntity createNewMockDefaultOrderEntity() {
        return new DefaultOrderEntity(
                1L,
                10L,
                OrderStatus.IN_PROGRESS.name(),
                99.99,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
