package davidrodriguez.com.uniquora.features.security.mappers;

import davidrodriguez.com.uniquora.features.security.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.entities.DefaultPasswordEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.getMockDefaultPasswordDTO;
import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.getMockDefaultPasswordEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordMapperTest {
    private DefaultPasswordMapper mockDefaultPasswordMapper;

    @BeforeEach
    public void setUp() {
        mockDefaultPasswordMapper = new DefaultPasswordMapper();
    }

    @Test
    void shouldNotMapPasswordDTOToPasswordWhenPasswordIsNull() {
        final DefaultPasswordEntity mockDefaultPasswordEntity = mockDefaultPasswordMapper.toPasswordEntity(null);

        assertThat(mockDefaultPasswordEntity).isNull();
    }

    @Test
    void shouldMapPasswordToPasswordDTO() {
        final DefaultPasswordEntity mockDefaultPasswordEntity = getMockDefaultPasswordEntity();

        final DefaultPasswordDTO mockDefaultPasswordDTO = mockDefaultPasswordMapper.toPasswordDTO(mockDefaultPasswordEntity);

        assertThat(mockDefaultPasswordDTO).isNotNull()
                .extracting(DefaultPasswordDTO::getId)
                .isEqualTo(mockDefaultPasswordEntity.getId());
        assertThat(mockDefaultPasswordDTO.getPassword()).isEqualTo(mockDefaultPasswordEntity.getPassword());
    }

    @Test
    void shouldNotMapPasswordToPasswordDTOWhenPasswordDTOIsNull() {
        final DefaultPasswordDTO mockDefaultPasswordDTO = mockDefaultPasswordMapper.toPasswordDTO(null);

        assertThat(mockDefaultPasswordDTO).isNull();
    }

    @Test
    void shouldMapPasswordDTOToPassword() {
        final DefaultPasswordDTO mockDefaultPasswordDTO = getMockDefaultPasswordDTO();

        final DefaultPasswordEntity mockDefaultPasswordEntityMapped = mockDefaultPasswordMapper.toPasswordEntity(mockDefaultPasswordDTO);

        assertThat(mockDefaultPasswordEntityMapped).isNotNull()
                .extracting(DefaultPasswordEntity::getId)
                .isEqualTo(mockDefaultPasswordEntityMapped.getId());
        assertThat(mockDefaultPasswordDTO.getPassword()).isEqualTo(mockDefaultPasswordEntityMapped.getPassword());
    }
}
