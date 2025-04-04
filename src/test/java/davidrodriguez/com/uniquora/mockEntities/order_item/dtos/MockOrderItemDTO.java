package davidrodriguez.com.uniquora.mockEntities.order_item.dtos;

import davidrodriguez.com.uniquora.features.order_item.shared.dtos.DefaultOrderItemDTO;

public class MockOrderItemDTO {
    private static DefaultOrderItemDTO instance;

    private MockOrderItemDTO() {}

    public static DefaultOrderItemDTO getMockDefaultOrderItemDTO() {
        if (instance == null) {
            instance = new DefaultOrderItemDTO(
                    1L,
                    100L,
                    200L,
                    3
            );
        }

        return instance;
    }

    public static DefaultOrderItemDTO createNewMockDefaultOrderItemDTO() {
        return new DefaultOrderItemDTO(
                1L,
                100L,
                200L,
                3
        );
    }
}
