package davidrodriguez.com.uniquora.features.brand.update_brand.service;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdateBrandService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;

    public UpdateBrandService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
    }

    public DefaultBrandDTO updateBrand(DefaultBrandDTO defaultBrandDTO) {
        if (defaultBrandDTO == null) {
            throw new IllegalArgumentException("Brand data cannot be null");
        }

        try {
            final DefaultBrandEntity existingBrandEntity = defaultBrandRepository.findById(defaultBrandDTO.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Brand with ID " + defaultBrandDTO.getId() + " not found"));

            existingBrandEntity.setName(defaultBrandDTO.getName());
            existingBrandEntity.setLogo(defaultBrandDTO.getLogo());
            existingBrandEntity.setActive(defaultBrandDTO.isActive());
            existingBrandEntity.setUpdatedAt(new Date());

            final DefaultBrandEntity updatedBrandEntity = defaultBrandRepository.save(existingBrandEntity);

            return modelMapper.map(updatedBrandEntity, DefaultBrandDTO.class);
        } catch (Exception exception) {
            throw new RuntimeException("Could not update brand due to an internal error.");
        }
    }
}
