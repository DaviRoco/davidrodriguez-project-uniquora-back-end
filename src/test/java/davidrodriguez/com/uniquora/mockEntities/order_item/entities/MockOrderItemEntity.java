package davidrodriguez.com.uniquora.mockEntities.order_item.entities;

import davidrodriguez.com.uniquora.features.order_item.shared.entities.DefaultOrderItemEntity;
public class MockOrderItemEntity {
    private static DefaultOrderItemEntity instance;

    private MockOrderItemEntity() {}

    public static DefaultOrderItemEntity getMockDefaultOrderItemEntity() {
        if (instance == null) {
            instance = new DefaultOrderItemEntity(
                    1L,
                    100L,
                    200L,
                    3
            );
        }

        return instance;
    }

    public static DefaultOrderItemEntity createNewMockDefaultOrderItemEntity() {
        return new DefaultOrderItemEntity(
                1L,
                100L,
                200L,
                3
        );
    }
}
