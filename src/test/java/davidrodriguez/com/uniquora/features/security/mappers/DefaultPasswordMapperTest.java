package davidrodriguez.com.uniquora.features.security.mappers;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.features.security.shared.mappers.DefaultPasswordMapper;
import davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO;
import davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordMapperTest {
    private DefaultPasswordMapper mockDefaultPasswordMapper;

    @BeforeEach
    public void setUp() {
        mockDefaultPasswordMapper = new DefaultPasswordMapper();
    }

    @Test
    void shouldNotMapPasswordDTOToPasswordWhenPasswordIsNull() {
        DefaultPasswordEntity mockDefaultPasswordEntity = mockDefaultPasswordMapper.toPasswordEntity(null);

        assertThat(mockDefaultPasswordEntity).isNull();
    }

    @Test
    void shouldMapPasswordToPasswordDTO() {
        DefaultPasswordEntity mockDefaultPasswordEntity = MockPasswordEntity.createMockDefaultPasswordEntity();

        DefaultPasswordDTO mockDefaultPasswordDTO = mockDefaultPasswordMapper.toPasswordDTO(mockDefaultPasswordEntity);

        assertThat(mockDefaultPasswordDTO).isNotNull()
                .extracting(DefaultPasswordDTO::getId)
                .isEqualTo(mockDefaultPasswordEntity.getId());
        assertThat(mockDefaultPasswordDTO.getPassword()).isEqualTo(mockDefaultPasswordEntity.getPassword());
    }

    @Test
    void shouldNotMapPasswordToPasswordDTOWhenPasswordDTOIsNull() {
        DefaultPasswordDTO mockDefaultPasswordDTO = mockDefaultPasswordMapper.toPasswordDTO(null);

        assertThat(mockDefaultPasswordDTO).isNull();
    }

    @Test
    void shouldMapPasswordDTOToPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        DefaultPasswordDTO mockDefaultPasswordDTO = MockPasswordDTO.getMockDefaultPasswordDTO();

        DefaultPasswordEntity mockDefaultPasswordEntityMapped = mockDefaultPasswordMapper.toPasswordEntity(mockDefaultPasswordDTO);

        assertThat(mockDefaultPasswordEntityMapped).isNotNull()
                .extracting(DefaultPasswordEntity::getId)
                .isEqualTo(mockDefaultPasswordEntityMapped.getId());
        assertThat(mockDefaultPasswordDTO.getPassword()).isEqualTo(mockDefaultPasswordEntityMapped.getPassword());
    }
}
