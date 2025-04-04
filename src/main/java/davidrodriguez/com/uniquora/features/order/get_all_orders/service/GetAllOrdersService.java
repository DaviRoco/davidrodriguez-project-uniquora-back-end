package davidrodriguez.com.uniquora.features.order.get_all_orders.service;

import davidrodriguez.com.uniquora.features.order.shared.dtos.DefaultOrderDTO;
import davidrodriguez.com.uniquora.features.order.shared.entities.DefaultOrderEntity;
import davidrodriguez.com.uniquora.features.order.shared.repositories.DefaultOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllOrdersService {
    private final DefaultOrderRepository defaultOrderRepository;
    private final ModelMapper modelMapper;

    public GetAllOrdersService(DefaultOrderRepository defaultOrderRepository, ModelMapper modelMapper) {
        this.defaultOrderRepository = defaultOrderRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultOrderDTO> getAllOrders() {
        try {
            List<DefaultOrderEntity> defaultOrderEntities = defaultOrderRepository.findAll();
            return defaultOrderEntities.stream()
                    .map(order -> modelMapper.map(order, DefaultOrderDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all orders due to an internal error.");
        }
    }
}
