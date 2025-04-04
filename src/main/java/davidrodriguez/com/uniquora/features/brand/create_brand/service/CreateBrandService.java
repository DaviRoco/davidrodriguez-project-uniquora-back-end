package davidrodriguez.com.uniquora.features.brand.create_brand.service;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateBrandService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;

    public CreateBrandService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
    }

    public DefaultBrandDTO createBrand(DefaultBrandDTO defaultBrandDTO) {
        if (defaultBrandDTO == null) {
            throw new IllegalArgumentException("Brand data cannot be null");
        }

        try {
            final DefaultBrandEntity brandEntity = modelMapper.map(defaultBrandDTO, DefaultBrandEntity.class);

            brandEntity.setCreatedAt(
                    java.util.Optional.ofNullable(brandEntity.getCreatedAt()).orElse(new Date())
            );

            brandEntity.setUpdatedAt(new Date());

            final DefaultBrandEntity savedEntity = defaultBrandRepository.save(brandEntity);

            return modelMapper.map(savedEntity, DefaultBrandDTO.class);
        } catch (Exception exception) {
            throw new RuntimeException("Could not create brand due to an internal error.");
        }
    }
}
