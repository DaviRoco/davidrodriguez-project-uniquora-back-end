package davidrodriguez.com.uniquora.features.user.shared.mappers;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.security.shared.mappers.DefaultPasswordMapper;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserMapperTest {
    private DefaultUserMapper mockDefaultUserMapper;
    private Date mockCreatedAt;
    private Date mockUpdatedAt;

    @BeforeEach
    void setUp() {
        mockCreatedAt = new Date();
        mockUpdatedAt = new Date();
        DefaultPasswordMapper mockDefaultPasswordMapper = new DefaultPasswordMapper();
        mockDefaultUserMapper = new DefaultUserMapper(mockDefaultPasswordMapper);
    }

    @Test
    void shouldMapUserToUserDTO() {
        DefaultPasswordEntity mockDefaultPasswordEntity = new DefaultPasswordEntity(1L, "test");
        DefaultUserEntity mockDefaultUserEntity = new DefaultUserEntity( "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, mockDefaultPasswordEntity, mockCreatedAt, mockUpdatedAt);

        DefaultUserDTO mockDefaultUserDTOMapped = mockDefaultUserMapper.toUserDTO(mockDefaultUserEntity);

        assertThat(mockDefaultUserDTOMapped).isNotNull()
                .extracting(DefaultUserDTO::getId)
                .isEqualTo(mockDefaultUserEntity.getId());
        assertThat(mockDefaultUserDTOMapped.getName()).isEqualTo(mockDefaultUserEntity.getName());
        assertThat(mockDefaultUserDTOMapped.getLastName()).isEqualTo(mockDefaultUserEntity.getLastName());
        assertThat(mockDefaultUserDTOMapped.getEmail()).isEqualTo(mockDefaultUserEntity.getEmail());
        assertThat(mockDefaultUserDTOMapped.getPhoneNumber()).isEqualTo(mockDefaultUserEntity.getPhoneNumber());
        assertThat(mockDefaultUserDTOMapped.getLocation()).isEqualTo(mockDefaultUserEntity.getLocation());
    }

    @Test
    void shouldNotMapUserToUserDTOWhenUserIsNull() {
        DefaultUserDTO mockDefaultUserDTOMapped = mockDefaultUserMapper.toUserDTO(null);

        assertThat(mockDefaultUserDTOMapped).isNull();
    }

    @Test
    void shouldMapUserDTOToUser() {
        DefaultPasswordDTO mockDefaultPasswordDTO = new DefaultPasswordDTO(1L, "test");
        DefaultUserDTO mockDefaultUserDTO = new DefaultUserDTO("John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, mockDefaultPasswordDTO, mockCreatedAt, mockUpdatedAt);

        DefaultUserEntity mockDefaultUserEntityMapped = mockDefaultUserMapper.toUser(mockDefaultUserDTO);

        assertThat(mockDefaultUserEntityMapped).isNotNull()
                .extracting(DefaultUserEntity::getId)
                .isEqualTo(mockDefaultUserDTO.getId());
        assertThat(mockDefaultUserEntityMapped.getName()).isEqualTo(mockDefaultUserDTO.getName());
        assertThat(mockDefaultUserEntityMapped.getLastName()).isEqualTo(mockDefaultUserDTO.getLastName());
        assertThat(mockDefaultUserEntityMapped.getEmail()).isEqualTo(mockDefaultUserDTO.getEmail());
        assertThat(mockDefaultUserEntityMapped.getPhoneNumber()).isEqualTo(mockDefaultUserDTO.getPhoneNumber());
        assertThat(mockDefaultUserEntityMapped.getLocation()).isEqualTo(mockDefaultUserDTO.getLocation());
    }

    @Test
    void shouldNotMapUserDTOToUserWhenUserIsNull() {
        DefaultUserEntity mockDefaultUserEntityMapped = mockDefaultUserMapper.toUser(null);

        assertThat(mockDefaultUserEntityMapped).isNull();
    }
}
