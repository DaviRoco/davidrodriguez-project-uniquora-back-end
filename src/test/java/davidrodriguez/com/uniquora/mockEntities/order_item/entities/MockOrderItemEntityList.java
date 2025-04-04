package davidrodriguez.com.uniquora.mockEntities.order_item.entities;

import davidrodriguez.com.uniquora.features.order_item.shared.entities.DefaultOrderItemEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockOrderItemEntityList {

    public List<DefaultOrderItemEntity> createMockDefaultOrderItemEntityList(int count) {
        List<DefaultOrderItemEntity> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new DefaultOrderItemEntity(
                    (long) i + 1,
                    100L + i,
                    200L + i,
                    2 + i
            ));
        }

        return list;
    }
}
