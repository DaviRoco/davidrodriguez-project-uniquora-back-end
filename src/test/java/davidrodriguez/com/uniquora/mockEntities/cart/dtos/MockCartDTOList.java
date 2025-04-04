package davidrodriguez.com.uniquora.mockEntities.cart.dtos;

import davidrodriguez.com.uniquora.features.cart.shared.dtos.DefaultCartDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCartDTOList {

    public List<DefaultCartDTO> createMockDefaultCartDTOList(int count) {
        final List<DefaultCartDTO> cartDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cartDTOList.add(new DefaultCartDTO(
                    (long) i + 1,
                    100L + i,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return cartDTOList;
    }
}
