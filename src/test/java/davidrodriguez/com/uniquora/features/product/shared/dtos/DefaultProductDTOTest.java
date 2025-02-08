package davidrodriguez.com.uniquora.features.product.shared.dtos;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.product.dtos.MockProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.product.dtos.MockProductDTO.createMockDefaultProductDTO;
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
        DefaultProductDTO mockDefaultProductDTO = createMockDefaultProductDTO();

        assertThat(mockDefaultProductDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultProductDTO.getName()).isEqualTo("Test Product");
        assertThat(mockDefaultProductDTO.getDescription()).isEqualTo("Test Product Description");
        assertThat(mockDefaultProductDTO.getPrice()).isEqualTo(100.0);
        assertThat(mockDefaultProductDTO.getStockQuantity()).isEqualTo(2);
        assertThat(mockDefaultProductDTO.getBrand().getId()).isEqualTo(mockBrand.getId());
        assertThat(mockDefaultProductDTO.getProductImages().get(0).getId()).isEqualTo(mockProductImages.get(0).getId());
        assertThat(mockDefaultProductDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultProductDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultProductDTO> newDefaultProductDTO = new MockProductDTO().createMockDefaultProductDTOList(1);

        DefaultProductDTO mockDefaultProductDTOSet = new DefaultProductDTO();
        mockDefaultProductDTOSet.setId(1L);
        mockDefaultProductDTOSet.setName("Test Product 1");
        mockDefaultProductDTOSet.setDescription("Test Product Description 1");
        mockDefaultProductDTOSet.setPrice(100.0);
        mockDefaultProductDTOSet.setStockQuantity(2);
        mockDefaultProductDTOSet.setBrand(mockBrand);
        mockDefaultProductDTOSet.setProductImages(mockProductImages);
        mockDefaultProductDTOSet.setCreatedAt(mockCreatedAt);
        mockDefaultProductDTOSet.setUpdatedAt(mockUpdatedAt);

        assertThat(newDefaultProductDTO.get(0).getId()).isEqualTo(mockDefaultProductDTOSet.getId());
        assertThat(newDefaultProductDTO.get(0).getName()).isEqualTo(mockDefaultProductDTOSet.getName());
        assertThat(newDefaultProductDTO.get(0).getDescription()).isEqualTo(mockDefaultProductDTOSet.getDescription());
        assertThat(newDefaultProductDTO.get(0).getPrice()).isEqualTo(mockDefaultProductDTOSet.getPrice());
        assertThat(newDefaultProductDTO.get(0).getStockQuantity()).isEqualTo(mockDefaultProductDTOSet.getStockQuantity());
        assertThat(newDefaultProductDTO.get(0).getBrand().getId()).isEqualTo(mockBrand.getId());
        assertThat(newDefaultProductDTO.get(0).getProductImages().get(0).getId()).isEqualTo(mockProductImages.get(0).getId());
        assertThat(newDefaultProductDTO.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultProductDTO.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }
}
