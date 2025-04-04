package davidrodriguez.com.uniquora.features.category.get_all_categories.service;

import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.features.category.shared.entities.DefaultCategoryEntity;
import davidrodriguez.com.uniquora.features.category.shared.repositories.DefaultCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCategoriesService {
    private final DefaultCategoryRepository defaultCategoryRepository;
    private final ModelMapper modelMapper;

    public GetAllCategoriesService(DefaultCategoryRepository defaultCategoryRepository, ModelMapper modelMapper) {
        this.defaultCategoryRepository = defaultCategoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultCategoryDTO> getAllCategories() {
        try {
            List<DefaultCategoryEntity> defaultCategoryEntities = defaultCategoryRepository.findAll();
            return defaultCategoryEntities.stream()
                    .map(category -> modelMapper.map(category, DefaultCategoryDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all categories due to an internal error.");
        }
    }
}
