package davidrodriguez.com.uniquora.features.product.shared.mappers;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.shared.entities.DefaultBrandEntity;
import davidrodriguez.com.uniquora.features.brand.shared.mappers.DefaultBrandMapper;
import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import davidrodriguez.com.uniquora.features.product.shared.entities.DefaultProductEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.entities.DefaultProductImageEntity;
import davidrodriguez.com.uniquora.features.product_image.shared.mappers.DefaultProductImageMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DefaultProductMapper {
    private final DefaultBrandMapper defaultBrandMapper;
    private final DefaultProductImageMapper defaultProductImageMapper;

    public DefaultProductMapper(DefaultBrandMapper defaultBrandMapper, DefaultProductImageMapper defaultProductImageMapper) {
        this.defaultBrandMapper = defaultBrandMapper;
        this.defaultProductImageMapper = defaultProductImageMapper;
    }

    public DefaultProductDTO toProductDTO(DefaultProductEntity defaultProductEntity) {
        if (defaultProductEntity == null) {
            return null;
        }

        DefaultBrandDTO mappedBrandDTO = defaultBrandMapper.toBrandDTO(defaultProductEntity.getBrand());
        ArrayList<DefaultProductImageDTO> mappedProductImageDTO = defaultProductImageMapper.toProductImageDTOArrayList(defaultProductEntity.getProductImages());

        return new DefaultProductDTO(
                defaultProductEntity.getId(),
                defaultProductEntity.getName(),
                defaultProductEntity.getDescription(),
                defaultProductEntity.getPrice(),
                defaultProductEntity.getStockQuantity(),
                mappedBrandDTO,
                mappedProductImageDTO,
                defaultProductEntity.getCreatedAt(),
                defaultProductEntity.getUpdatedAt()
        );
    }

    public DefaultProductEntity toProductEntity(DefaultProductDTO defaultProductDTO) {
        if (defaultProductDTO == null) {
            return null;
        }
        DefaultBrandEntity mappedBrandEntity = defaultBrandMapper.toBrandEntity(defaultProductDTO.getBrand());
        ArrayList<DefaultProductImageEntity> mappedProductImageEntity = defaultProductImageMapper.toProductImageEntityArrayList(defaultProductDTO.getProductImages());

        return new DefaultProductEntity(
                defaultProductDTO.getId(),
                defaultProductDTO.getName(),
                defaultProductDTO.getDescription(),
                defaultProductDTO.getPrice(),
                defaultProductDTO.getStockQuantity(),
                mappedBrandEntity,
                mappedProductImageEntity,
                defaultProductDTO.getCreatedAt(),
                defaultProductDTO.getUpdatedAt()
        );
    }
}
