package davidrodriguez.com.uniquora.features.product_image.shared.mappers;

import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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

    public ArrayList<DefaultProductImageDTO> toProductImageDTOArrayList(ArrayList<DefaultProductImageEntity> defaultProductImageEntities) {
        if (defaultProductImageEntities == null) {
            return null;
        }

        ArrayList<DefaultProductImageDTO> defaultProductImageDTOArrayList = new ArrayList<>();
        for (DefaultProductImageEntity defaultProductImageEntity : defaultProductImageEntities) {
            defaultProductImageDTOArrayList.add(toProductImageDTO(defaultProductImageEntity));
        }

        return defaultProductImageDTOArrayList;
    }

    public ArrayList<DefaultProductImageEntity> toProductImageEntityArrayList(ArrayList<DefaultProductImageDTO> defaultProductImageDTOArrayList) {
        if (defaultProductImageDTOArrayList == null) {
            return null;
        }

        ArrayList<DefaultProductImageEntity> defaultProductImageEntityArrayList = new ArrayList<>();
        for (DefaultProductImageDTO defaultProductImageDTO : defaultProductImageDTOArrayList) {
            defaultProductImageEntityArrayList.add(toProductImageEntity(defaultProductImageDTO));
        }

        return defaultProductImageEntityArrayList;
    }
}
