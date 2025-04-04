package davidrodriguez.com.uniquora.mockEntities.order_item.dtos;

import davidrodriguez.com.uniquora.features.order_item.shared.dtos.DefaultOrderItemDTO;

import java.util.ArrayList;
import java.util.List;

public class MockOrderItemDTOList {

    public List<DefaultOrderItemDTO> createMockDefaultOrderItemDTOList(int count) {
        List<DefaultOrderItemDTO> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new DefaultOrderItemDTO(
                    (long) i + 1,
                    100L + i,
                    200L + i,
                    2 + i
            ));
        }

        return list;
    }
}
