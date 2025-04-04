package davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.service;

import davidrodriguez.com.uniquora.features.cart_item.shared.dtos.DefaultCartItemDTO;
import davidrodriguez.com.uniquora.features.cart_item.shared.entities.DefaultCartItemEntity;
import davidrodriguez.com.uniquora.features.cart_item.shared.repositories.DefaultCartItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCartItemsService {
    private final DefaultCartItemRepository defaultCartItemRepository;
    private final ModelMapper modelMapper;

    public GetAllCartItemsService(DefaultCartItemRepository defaultCartItemRepository, ModelMapper modelMapper) {
        this.defaultCartItemRepository = defaultCartItemRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultCartItemDTO> getAllCartItems() {
        try {
            List<DefaultCartItemEntity> cartItemEntities = defaultCartItemRepository.findAll();
            return cartItemEntities.stream()
                    .map(entity -> modelMapper.map(entity, DefaultCartItemDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Could not get all cart items due to an internal error.");
        }
    }
}
