package davidrodriguez.com.uniquora.features.brand.get_all_brands.service;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllBrandsService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;

    public GetAllBrandsService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultBrandDTO> getAllBrands() {
        try {
            List<DefaultBrandEntity> defaultBrandEntities = defaultBrandRepository.findAll();
            return defaultBrandEntities.stream()
                    .map(brand -> modelMapper.map(brand, DefaultBrandDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all brands due to an internal error.");
        }
    }
}
