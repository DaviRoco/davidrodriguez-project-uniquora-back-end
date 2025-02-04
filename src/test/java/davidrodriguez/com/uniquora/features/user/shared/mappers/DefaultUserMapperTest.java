package davidrodriguez.com.uniquora.features.user.shared.mappers;

import davidrodriguez.com.uniquora.features.security.entity.Password;
import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserMapperTest {
    private Password mockPassword;
    private DefaultUserMapper defaultUserMapper;

    @BeforeEach
    void setUp() {
        mockPassword = new Password("test");
        defaultUserMapper = new DefaultUserMapper();
    }

    @Test
    void shouldMapUserToUserDTO() {
        DefaultUserEntity mockDefaultUserEntity = new DefaultUserEntity( "John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);

        DefaultUserDTO mockDefaultUserDTOMapped = defaultUserMapper.toUserDTO(mockDefaultUserEntity);

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
        DefaultUserDTO mockDefaultUserDTOMapped = defaultUserMapper.toUserDTO(null);

        assertThat(mockDefaultUserDTOMapped).isNull();
    }

    @Test
    void shouldMapUserDTOToUser() {
        DefaultUserDTO mockDefaultUserDTO = new DefaultUserDTO("John", "Doe", "test@email.com", "+506123456", "Costa Rica", Role.ADMIN, new Date(), new Date(), mockPassword);

        DefaultUserEntity mockDefaultUserEntityMapped = defaultUserMapper.toUser(mockDefaultUserDTO);

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
        DefaultUserEntity mockDefaultUserEntityMapped = defaultUserMapper.toUser(null);

        assertThat(mockDefaultUserEntityMapped).isNull();
    }
}
