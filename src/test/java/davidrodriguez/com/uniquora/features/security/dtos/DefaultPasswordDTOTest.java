package davidrodriguez.com.uniquora.features.security.dtos;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.createMockDefaultPasswordDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordDTOTest {
    @Test
    void shouldGetAllAttributes() {
        DefaultPasswordDTO mockDefaultPasswordDTO = createMockDefaultPasswordDTO();

        assertThat(mockDefaultPasswordDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultPasswordDTO.getPassword()).isEqualTo("Test Password");
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultPasswordDTO> mockDefaultPasswordDTO = new MockPasswordDTO().createMockDefaultPasswordDTOList(1);

        DefaultPasswordDTO mockDefaultPasswordDTOSet = createMockDefaultPasswordDTO();
        mockDefaultPasswordDTOSet.setId(1L);
        mockDefaultPasswordDTOSet.setPassword("Test Password");

        assertThat(mockDefaultPasswordDTOSet.getId()).isEqualTo(mockDefaultPasswordDTO.get(0).getId());
        assertThat(mockDefaultPasswordDTOSet.getPassword()).isEqualTo(mockDefaultPasswordDTO.get(0).getPassword());
    }
}
