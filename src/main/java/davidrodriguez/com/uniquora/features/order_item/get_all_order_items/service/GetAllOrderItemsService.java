package davidrodriguez.com.uniquora.features.order_item.get_all_order_items.service;

import davidrodriguez.com.uniquora.features.order_item.shared.dtos.DefaultOrderItemDTO;
import davidrodriguez.com.uniquora.features.order_item.shared.entities.DefaultOrderItemEntity;
import davidrodriguez.com.uniquora.features.order_item.shared.repositories.DefaultOrderItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllOrderItemsService {

    private final DefaultOrderItemRepository defaultOrderItemRepository;
    private final ModelMapper modelMapper;

    public GetAllOrderItemsService(DefaultOrderItemRepository defaultOrderItemRepository, ModelMapper modelMapper) {
        this.defaultOrderItemRepository = defaultOrderItemRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultOrderItemDTO> getAllOrderItems() {
        try {
            List<DefaultOrderItemEntity> entities = defaultOrderItemRepository.findAll();
            return entities.stream()
                    .map(orderItem -> modelMapper.map(orderItem, DefaultOrderItemDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all order items due to an internal error.");
        }
    }
}
