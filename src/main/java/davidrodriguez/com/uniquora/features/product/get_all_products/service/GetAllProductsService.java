package davidrodriguez.com.uniquora.features.product.get_all_products.service;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.features.product.shared.repositories.DefaultProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllProductsService {
    private final DefaultProductRepository defaultProductRepository;
    private final ModelMapper modelMapper;

    public GetAllProductsService(DefaultProductRepository defaultProductRepository, ModelMapper modelMapper) {
        this.defaultProductRepository = defaultProductRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultProductDTO> getAllProducts() {
        try {
            final List<DefaultProductEntity> defaultProductEntities = defaultProductRepository.findAll();
            return defaultProductEntities.stream()
                    .map(product -> modelMapper.map(product, DefaultProductDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all products due to an internal error.");
        }
    }
}
