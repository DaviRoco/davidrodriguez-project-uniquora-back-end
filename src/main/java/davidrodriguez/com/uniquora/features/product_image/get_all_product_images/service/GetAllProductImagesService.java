package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.service;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.repositories.DefaultProductImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllProductImagesService {
    private final DefaultProductImageRepository defaultProductImageRepository;
    private final ModelMapper modelMapper;

    public GetAllProductImagesService(DefaultProductImageRepository defaultProductImageRepository, ModelMapper modelMapper) {
        this.defaultProductImageRepository = defaultProductImageRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultProductImageDTO> getAllProductImages() {
        try {
            final List<DefaultProductImageEntity> defaultProductImageEntities = defaultProductImageRepository.findAll();
            return defaultProductImageEntities.stream()
                    .map(productImage -> modelMapper.map(productImage, DefaultProductImageDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all product images due to an internal error.");
        }
    }
}
