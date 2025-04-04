package davidrodriguez.com.uniquora.mockEntities.order.entities;

import davidrodriguez.com.uniquora.enumerations.OrderStatus;
import davidrodriguez.com.uniquora.features.order.shared.entities.DefaultOrderEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockOrderEntityList {

    public List<DefaultOrderEntity> createMockDefaultOrderEntityList(int count) {
        List<DefaultOrderEntity> orderEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            orderEntityList.add(new DefaultOrderEntity(
                    (long) i + 1,
                    10L + i,
                    OrderStatus.IN_PROGRESS.name(),
                    99.99 + i,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return orderEntityList;
    }
}
