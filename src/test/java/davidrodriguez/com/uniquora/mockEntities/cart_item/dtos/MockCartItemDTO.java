package davidrodriguez.com.uniquora.mockEntities.cart_item.dtos;

import davidrodriguez.com.uniquora.features.cart_item.shared.dtos.DefaultCartItemDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

public class MockCartItemDTO {
    private static DefaultCartItemDTO instance;

    private MockCartItemDTO() {}

    public static DefaultCartItemDTO getMockDefaultCartItemDTO() {
        if (instance == null) {
            instance = new DefaultCartItemDTO(
                    1L,
                    1L,
                    1L,
                    2,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }

    public static DefaultCartItemDTO createNewMockDefaultCartItemDTO() {
        return new DefaultCartItemDTO(
                1L,
                1L,
                1L,
                2,
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }
}
