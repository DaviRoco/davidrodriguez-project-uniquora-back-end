package davidrodriguez.com.uniquora.features.brand.create_brand.services;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.mappers.DefaultBrandMapper;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateBrandService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;
    private final DefaultBrandMapper defaultBrandMapper;

    public CreateBrandService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper, DefaultBrandMapper defaultBrandMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
        this.defaultBrandMapper = defaultBrandMapper;
    }

    public DefaultBrandDTO createBrand(DefaultBrandDTO defaultBrandDTO) {
        if (defaultBrandDTO.getCreatedAt() == null){
            defaultBrandDTO.setCreatedAt(new Date());
        }

        if (defaultBrandDTO.getUpdatedAt() == null){
            defaultBrandDTO.setUpdatedAt(new Date());
        }

        DefaultBrandEntity defaultBrandEntity = modelMapper.map(defaultBrandDTO, DefaultBrandEntity.class);
        DefaultBrandEntity newDefaultBrandEntity = defaultBrandRepository.save(defaultBrandEntity);
        return defaultBrandMapper.toBrandDTO(newDefaultBrandEntity);
    }
}
