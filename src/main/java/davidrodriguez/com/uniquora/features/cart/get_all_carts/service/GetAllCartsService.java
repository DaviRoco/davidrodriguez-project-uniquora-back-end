package davidrodriguez.com.uniquora.features.cart.get_all_carts.service;

import davidrodriguez.com.uniquora.features.cart.shared.dtos.DefaultCartDTO;
import davidrodriguez.com.uniquora.features.cart.shared.entities.DefaultCartEntity;
import davidrodriguez.com.uniquora.features.cart.shared.repositories.DefaultCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCartsService {
    private final DefaultCartRepository defaultCartRepository;
    private final ModelMapper modelMapper;

    public GetAllCartsService(DefaultCartRepository defaultCartRepository, ModelMapper modelMapper) {
        this.defaultCartRepository = defaultCartRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultCartDTO> getAllCarts() {
        try {
            final List<DefaultCartEntity> defaultCartEntities = defaultCartRepository.findAll();
            return defaultCartEntities.stream()
                    .map(cart -> modelMapper.map(cart, DefaultCartDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all carts due to an internal error.");
        }
    }
}
