package davidrodriguez.com.uniquora.mockEntities.cart_item.entities;

import davidrodriguez.com.uniquora.features.cart_item.shared.entities.DefaultCartItemEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCartItemEntityList {

    public List<DefaultCartItemEntity> createMockDefaultCartItemEntityList(int count) {
        List<DefaultCartItemEntity> cartItemEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cartItemEntityList.add(new DefaultCartItemEntity(
                    (long) i + 1,
                    1L,
                    1L,
                    3,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return cartItemEntityList;
    }
}
