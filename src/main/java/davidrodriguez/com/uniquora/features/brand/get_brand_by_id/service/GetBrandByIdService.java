package davidrodriguez.com.uniquora.features.brand.get_brand_by_id.service;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.get_brand_by_id.repository.GetBrandByIdRepository;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GetBrandByIdService {
    private final GetBrandByIdRepository getBrandByIdRepository;
    private final ModelMapper modelMapper;

    public GetBrandByIdService(GetBrandByIdRepository getBrandByIdRepository, ModelMapper modelMapper) {
        this.getBrandByIdRepository = getBrandByIdRepository;
        this.modelMapper = modelMapper;
    }

    public DefaultBrandDTO getBrandById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Brand ID cannot be null.");
        }

        try {
            DefaultBrandEntity existingBrandEntity = getBrandByIdRepository.findBrandById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Brand with ID " + id + " not found"));

            return modelMapper.map(existingBrandEntity, DefaultBrandDTO.class);
        } catch (Exception exception) {
            throw new RuntimeException("Could not find brand by ID due to an internal error.");
        }
    }
}
