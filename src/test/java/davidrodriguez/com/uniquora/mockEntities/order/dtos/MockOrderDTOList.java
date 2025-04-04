package davidrodriguez.com.uniquora.mockEntities.order.dtos;

import davidrodriguez.com.uniquora.enumerations.OrderStatus;
import davidrodriguez.com.uniquora.features.order.shared.dtos.DefaultOrderDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockOrderDTOList {

    public List<DefaultOrderDTO> createMockDefaultOrderDTOList(int count) {
        List<DefaultOrderDTO> orderDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            orderDTOList.add(new DefaultOrderDTO(
                    (long) i + 1,
                    10L + i,
                    OrderStatus.IN_PROGRESS.name(),
                    99.99 + i,
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return orderDTOList;
    }
}
