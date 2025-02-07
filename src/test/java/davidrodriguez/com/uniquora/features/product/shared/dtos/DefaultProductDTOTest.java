package davidrodriguez.com.uniquora.features.product.shared.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static davidrodriguez.com.uniquora.mockEntities.product.dtos.MockProductDTO.createDefaultProductDTO;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductDTOTest {
    DefaultBrandDTO mockBrand;
    ArrayList<DefaultProductImageDTO> mockProductImages;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    public void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
        mockBrand = new DefaultBrandDTO(
                1L,
                "Test Brand",
                "testLogoURL.com",
                mockCreatedAt,
                mockUpdatedAt
        );
        mockProductImages = new ArrayList<>();
        mockProductImages.add(new DefaultProductImageDTO(1L, "testImageURL.com"));
        mockProductImages.add(new DefaultProductImageDTO(2L, "testImageURL.com"));
    }

    @Test
    void shouldGetAllAttributes() {
        DefaultProductDTO mockDefaultProductDTO = createDefaultProductDTO();

        assertThat(mockDefaultProductDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductDTO.getName()).isEqualTo("Test Product");
        assertThat(mockDefaultProductDTO.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductDTO.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductDTO.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductDTO.getBrand()).isEqualTo(mockBrand);
        assertThat(mockDefaultProductDTO.getProductImages().get(0)).isEqualTo(mockProductImages.get(0));
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultProductDTO newDefaultProductDTO = createDefaultProductDTO();

        DefaultProductDTO mockDefaultProductDTOSet = new DefaultProductDTO();
        mockDefaultProductDTOSet.setId(1L);
        mockDefaultProductDTOSet.setName("Test Product 2");
        mockDefaultProductDTOSet.setDescription("Test Product Description");
        mockDefaultProductDTOSet.setPrice(100.0);
        mockDefaultProductDTOSet.setStockQuantity(2);
        mockDefaultProductDTOSet.setBrand(mockBrand);
        mockDefaultProductDTOSet.setProductImages(mockProductImages);
        mockDefaultProductDTOSet.setCreatedAt(mockCreatedAt);
        mockDefaultProductDTOSet.setUpdatedAt(mockUpdatedAt);

        assertThat(newDefaultProductDTO.getId()).isEqualTo(mockDefaultProductDTOSet.getId());
        assertThat(newDefaultProductDTO.getName()).isEqualTo(mockDefaultProductDTOSet.getName());
        assertThat(newDefaultProductDTO.getDescription()).isEqualTo(mockDefaultProductDTOSet.getDescription());
        assertThat(newDefaultProductDTO.getPrice()).isEqualTo(mockDefaultProductDTOSet.getPrice());
        assertThat(newDefaultProductDTO.getStockQuantity()).isEqualTo(mockDefaultProductDTOSet.getStockQuantity());
        assertThat(newDefaultProductDTO.getBrand()).isEqualTo(mockBrand);
        assertThat(newDefaultProductDTO.getProductImages()).isEqualTo(mockProductImages);
        assertThat(newDefaultProductDTO.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(newDefaultProductDTO.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }
}
