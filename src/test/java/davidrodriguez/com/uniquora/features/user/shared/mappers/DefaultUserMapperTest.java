package davidrodriguez.com.uniquora.features.user.shared.mappers;

import davidrodriguez.com.uniquora.features.security.shared.mappers.DefaultPasswordMapper;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTO.getMockDefaultUserDTO;
import static davidrodriguez.com.uniquora.mockEntities.user.entities.MockUserEntity.getMockDefaultUserEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserMapperTest {
    private DefaultUserMapper mockDefaultUserMapper;

    @BeforeEach
    void setUp() {
        DefaultPasswordMapper mockDefaultPasswordMapper = new DefaultPasswordMapper();
        mockDefaultUserMapper = new DefaultUserMapper(mockDefaultPasswordMapper);
    }

    @Test
    void shouldMapUserToUserDTO() {

        DefaultUserEntity mockDefaultUserEntity = getMockDefaultUserEntity();

        DefaultUserDTO mockDefaultUserDTOMapped = mockDefaultUserMapper.toUserDTO(mockDefaultUserEntity);

        assertThat(mockDefaultUserDTOMapped).isNotNull()
                .extracting(DefaultUserDTO::getId)
                .isEqualTo(mockDefaultUserEntity.getId());
        assertThat(mockDefaultUserDTOMapped.getName()).isEqualTo(mockDefaultUserEntity.getName());
        assertThat(mockDefaultUserDTOMapped.getLastName()).isEqualTo(mockDefaultUserEntity.getLastName());
        assertThat(mockDefaultUserDTOMapped.getEmail()).isEqualTo(mockDefaultUserEntity.getEmail());
        assertThat(mockDefaultUserDTOMapped.getPhoneNumber()).isEqualTo(mockDefaultUserEntity.getPhoneNumber());
        assertThat(mockDefaultUserDTOMapped.getLocation()).isEqualTo(mockDefaultUserEntity.getLocation());
        assertThat(mockDefaultUserDTOMapped.getPassword().getPassword()).isEqualTo(mockDefaultUserEntity.getPassword().getPassword());
        assertThat(mockDefaultUserDTOMapped.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultUserDTOMapped.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldNotMapUserToUserDTOWhenUserIsNull() {
        DefaultUserDTO mockDefaultUserDTOMapped = mockDefaultUserMapper.toUserDTO(null);

        assertThat(mockDefaultUserDTOMapped).isNull();
    }

    @Test
    void shouldMapUserDTOToUser() {
        DefaultUserDTO mockDefaultUserDTO = getMockDefaultUserDTO();

        DefaultUserEntity mockDefaultUserEntityMapped = mockDefaultUserMapper.toUser(mockDefaultUserDTO);

        assertThat(mockDefaultUserEntityMapped).isNotNull()
                .extracting(DefaultUserEntity::getId)
                .isEqualTo(mockDefaultUserDTO.getId());
        assertThat(mockDefaultUserEntityMapped.getName()).isEqualTo(mockDefaultUserDTO.getName());
        assertThat(mockDefaultUserEntityMapped.getLastName()).isEqualTo(mockDefaultUserDTO.getLastName());
        assertThat(mockDefaultUserEntityMapped.getEmail()).isEqualTo(mockDefaultUserDTO.getEmail());
        assertThat(mockDefaultUserEntityMapped.getPhoneNumber()).isEqualTo(mockDefaultUserDTO.getPhoneNumber());
        assertThat(mockDefaultUserEntityMapped.getLocation()).isEqualTo(mockDefaultUserDTO.getLocation());
        assertThat(mockDefaultUserEntityMapped.getPassword().getId()).isEqualTo(mockDefaultUserDTO.getPassword().getId());
        assertThat(mockDefaultUserEntityMapped.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultUserEntityMapped.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldNotMapUserDTOToUserWhenUserIsNull() {
        DefaultUserEntity mockDefaultUserEntityMapped = mockDefaultUserMapper.toUser(null);

        assertThat(mockDefaultUserEntityMapped).isNull();
    }
}
