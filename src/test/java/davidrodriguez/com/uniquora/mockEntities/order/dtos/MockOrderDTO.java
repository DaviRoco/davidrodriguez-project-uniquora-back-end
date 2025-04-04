package davidrodriguez.com.uniquora.mockEntities.order.dtos;

import davidrodriguez.com.uniquora.enumerations.OrderStatus;
import davidrodriguez.com.uniquora.features.order.shared.dtos.DefaultOrderDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockOrderDTO {
    private static DefaultOrderDTO instance;

    private MockOrderDTO() {}

    public static DefaultOrderDTO getMockDefaultOrderDTO() {
        if (instance == null) {
            instance = new DefaultOrderDTO(
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

    public static DefaultOrderDTO createNewMockDefaultOrderDTO() {
        return new DefaultOrderDTO(
                1L,
                10L,
                OrderStatus.IN_PROGRESS.name(),
                99.99,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
