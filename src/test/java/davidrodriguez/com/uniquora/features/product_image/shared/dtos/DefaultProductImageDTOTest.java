package davidrodriguez.com.uniquora.features.product_image.shared.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DefaultProductImageDTOTest {
    private DefaultProductImageDTO mockDefaultProductImageDTO;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    public void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
    }

    @Test
    void shouldGetAllAttributes() {
        
    }
}
