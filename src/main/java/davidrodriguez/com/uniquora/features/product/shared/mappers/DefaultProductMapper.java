package davidrodriguez.com.uniquora.features.product.shared.mappers;

import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductMapper {

    public DefaultProductDTO toProductDTO(DefaultProductEntity defaultProductEntity) {
        if (defaultProductEntity == null) {
            return null;
        }
        return new DefaultProductDTO(
                defaultProductEntity.getId(),
                defaultProductEntity.getName(),
                defaultProductEntity.getDescription(),
                defaultProductEntity.getPrice(),
                defaultProductEntity.getStockQuantity(),
                defaultProductEntity.getBrand(),
                defaultProductEntity.getProductImages(),
                defaultProductEntity.getCreatedAt(),
                defaultProductEntity.getUpdatedAt()
        );
    }

    public DefaultProductEntity toDefaultProductEntity(DefaultProductDTO defaultProductDTO) {
        if (defaultProductDTO == null) {
            return null;
        }
        return new DefaultProductEntity(
                defaultProductDTO.getId(),
                defaultProductDTO.getName(),
                defaultProductDTO.getDescription(),
                defaultProductDTO.getPrice(),
                defaultProductDTO.getStockQuantity(),
                defaultProductDTO.getBrand(),
                defaultProductDTO.getProductImages(),
                defaultProductDTO.getCreatedAt(),
                defaultProductDTO.getUpdatedAt()
        );
    }
}
