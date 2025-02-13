package davidrodriguez.com.uniquora.features.brand.update_brand.services;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.mappers.DefaultBrandMapper;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdateBrandService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;
    private final DefaultBrandMapper defaultBrandMapper;

    public UpdateBrandService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper, DefaultBrandMapper defaultBrandMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
        this.defaultBrandMapper = defaultBrandMapper;
    }

    public DefaultBrandDTO updateBrand(DefaultBrandDTO defaultBrandDTO) {
        defaultBrandDTO.setUpdatedAt(new Date());

        DefaultBrandEntity defaultBrandEntity = modelMapper.map(defaultBrandDTO, DefaultBrandEntity.class);
        DefaultBrandEntity updatedDefaultBrandEntity = defaultBrandRepository.save(defaultBrandEntity);
        return defaultBrandMapper.toBrandDTO(updatedDefaultBrandEntity);
    }
}
