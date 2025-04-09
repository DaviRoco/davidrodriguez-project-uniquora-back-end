package davidrodriguez.com.uniquora.mockEntities.cart.entities;

import davidrodriguez.com.uniquora.features.cart.shared.entities.DefaultCartEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCartEntityList {

    public List<DefaultCartEntity> createMockDefaultCartEntityList(int count) {
        final List<DefaultCartEntity> cartEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cartEntityList.add(new DefaultCartEntity(
                    (long) i + 1,
                    100L + i,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return cartEntityList;
    }
}
