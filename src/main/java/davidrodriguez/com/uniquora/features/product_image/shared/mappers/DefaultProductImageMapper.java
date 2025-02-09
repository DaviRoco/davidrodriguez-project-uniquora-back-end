package davidrodriguez.com.uniquora.features.product_image.shared.mappers;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DefaultProductImageMapper {

    public DefaultProductImageDTO toProductImageDTO(DefaultProductImageEntity defaultProductImageEntity) {
        if (defaultProductImageEntity == null) {
            return null;
        }

        return new DefaultProductImageDTO(
                defaultProductImageEntity.getId(),
                defaultProductImageEntity.getImageUrl()
        );
    }

    public DefaultProductImageEntity toProductImageEntity(DefaultProductImageDTO defaultProductImageDTO) {
        if (defaultProductImageDTO == null) {
            return null;
        }

        return new DefaultProductImageEntity(
                defaultProductImageDTO.getId(),
                defaultProductImageDTO.getImageUrl()
        );
    }

    public List<DefaultProductImageDTO> toProductImageDTOList(List<DefaultProductImageEntity> defaultProductImageEntities) {
        if (defaultProductImageEntities == null) {
            return null;
        }

        List<DefaultProductImageDTO> defaultProductImageDTOArrayList = new ArrayList<>();
        for (DefaultProductImageEntity defaultProductImageEntity : defaultProductImageEntities) {
            defaultProductImageDTOArrayList.add(toProductImageDTO(defaultProductImageEntity));
        }

        return defaultProductImageDTOArrayList;
    }

    public List<DefaultProductImageEntity> toProductImageEntityArrayList(List<DefaultProductImageDTO> defaultProductImageDTOArrayList) {
        if (defaultProductImageDTOArrayList == null) {
            return null;
        }

        List<DefaultProductImageEntity> defaultProductImageEntityArrayList = new ArrayList<>();
        for (DefaultProductImageDTO defaultProductImageDTO : defaultProductImageDTOArrayList) {
            defaultProductImageEntityArrayList.add(toProductImageEntity(defaultProductImageDTO));
        }

        return defaultProductImageEntityArrayList;
    }
}
