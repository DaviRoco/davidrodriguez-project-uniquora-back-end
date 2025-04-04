package davidrodriguez.com.uniquora.features.brand.delete_brand.service;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.repositories.DefaultBrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteBrandService {
    private final DefaultBrandRepository defaultBrandRepository;
    private final ModelMapper modelMapper;

    public DeleteBrandService(DefaultBrandRepository defaultBrandRepository, ModelMapper modelMapper) {
        this.defaultBrandRepository = defaultBrandRepository;
        this.modelMapper = modelMapper;
    }

    public DefaultBrandDTO deleteBrand(Long id) {
        if (id == null) {
            throw new ResourceNotFoundException("Brand ID cannot be null");
        }

        try {
            DefaultBrandEntity existingBrandEntity = defaultBrandRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Brand with ID " + id + " not found"));

            if (existingBrandEntity.isActive()) {
                existingBrandEntity.setActive(false);

                DefaultBrandEntity updatedBrandEntity = defaultBrandRepository.save(existingBrandEntity);

                return modelMapper.map(updatedBrandEntity, DefaultBrandDTO.class);
            }

            return modelMapper.map(existingBrandEntity, DefaultBrandDTO.class);
        } catch (Exception exception) {
            throw new RuntimeException("Could not delete brand due to an internal error.");
        }
    }
}
