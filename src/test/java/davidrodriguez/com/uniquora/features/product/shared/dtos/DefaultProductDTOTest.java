package davidrodriguez.com.uniquora.features.product.shared.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductDTOTest {
    DefaultBrandDTO mockBrand;
    DefaultProductImageDTO mockProductImage;
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
        mockProductImage = new DefaultProductImageDTO(1L, "testImageURL");
        mockProductImages = new ArrayList<>();
        mockProductImages.add(mockProductImage);
    }

    @Test
    void shouldGetAllAttributes() {
        DefaultProductDTO mockDefaultProductDTO = new DefaultProductDTO(
                1L,
                "Test Product Name",
                "Test Product Description",
                100.0,
                2,
                mockBrand,
                mockProductImages,
                mockCreatedAt,
                mockUpdatedAt
        );

        assertThat(mockDefaultProductDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductDTO.getName()).isEqualTo("Test Product Name");
        assertThat(mockDefaultProductDTO.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductDTO.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductDTO.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductDTO.getBrand()).isEqualTo(mockBrand);
        assertThat(mockDefaultProductDTO.getProductImages().get(0)).isEqualTo(mockProductImage);
        assertThat(mockDefaultProductDTO.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(mockDefaultProductDTO.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultProductDTO newDefaultProductDTO = getNewDefaultProductDTO();

        assertThat(newDefaultProductDTO.getId()).isEqualTo(2L);
        assertThat(newDefaultProductDTO.getName()).isEqualTo("Test Product Name 2");
        assertThat(newDefaultProductDTO.getDescription()).isEqualTo("Test Product Description");
        assertThat(newDefaultProductDTO.getPrice()).isEqualTo(100.0);
        assertThat(newDefaultProductDTO.getStockQuantity()).isEqualTo(2);
        assertThat(newDefaultProductDTO.getBrand()).isEqualTo(mockBrand);
        assertThat(newDefaultProductDTO.getProductImages()).isEqualTo(mockProductImages);
        assertThat(newDefaultProductDTO.getCreatedAt()).isEqualTo(mockCreatedAt);
        assertThat(newDefaultProductDTO.getUpdatedAt()).isEqualTo(mockUpdatedAt);
    }

    private DefaultProductDTO getNewDefaultProductDTO() {
        DefaultProductDTO newDefaultProductDTO = new DefaultProductDTO();
        newDefaultProductDTO.setId(2L);
        newDefaultProductDTO.setName("Test Product Name 2");
        newDefaultProductDTO.setDescription("Test Product Description");
        newDefaultProductDTO.setPrice(100.0);
        newDefaultProductDTO.setStockQuantity(2);
        newDefaultProductDTO.setBrand(mockBrand);
        newDefaultProductDTO.setProductImages(mockProductImages);
        newDefaultProductDTO.setCreatedAt(mockCreatedAt);
        newDefaultProductDTO.setUpdatedAt(mockUpdatedAt);
        return newDefaultProductDTO;
    }
}
