package davidrodriguez.com.uniquora.features.brand.shared.mappers;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import org.springframework.stereotype.Component;

@Component
public class DefaultBrandMapper {
    public DefaultBrandDTO toBrandDTO(DefaultBrandEntity defaultBrandEntity) {
        if (defaultBrandEntity == null) {
            return null;
        }

        return new DefaultBrandDTO(
                defaultBrandEntity.getId(),
                defaultBrandEntity.getName(),
                defaultBrandEntity.getLogo(),
                defaultBrandEntity.getCreatedAt(),
                defaultBrandEntity.getUpdatedAt()
        );
    }

    public DefaultBrandEntity toBrandEntity(DefaultBrandDTO defaultBrandDTO) {
        if (defaultBrandDTO == null) {
            return null;
        }

        return new DefaultBrandEntity(
                defaultBrandDTO.getId(),
                defaultBrandDTO.getName(),
                defaultBrandDTO.getLogo(),
                defaultBrandDTO.getCreatedAt(),
                defaultBrandDTO.getUpdatedAt()
        );
    }
}
