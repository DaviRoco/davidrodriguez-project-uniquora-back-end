package davidrodriguez.com.uniquora.mockEntities.cart_item.dtos;

import davidrodriguez.com.uniquora.features.cart_item.shared.dtos.DefaultCartItemDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCartItemDTOList {
    public List<DefaultCartItemDTO> createMockDefaultCartItemDTOList(int count) {
        final List<DefaultCartItemDTO> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new DefaultCartItemDTO(
                    (long) i + 1,
                    1L,
                    1L,
                    2,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }
        return list;
    }
}
