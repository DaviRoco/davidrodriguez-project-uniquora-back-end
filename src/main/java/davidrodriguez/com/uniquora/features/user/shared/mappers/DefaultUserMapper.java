package davidrodriguez.com.uniquora.features.user.shared.mappers;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.features.security.shared.mappers.DefaultPasswordMapper;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserMapper {
    private final DefaultPasswordMapper defaultPasswordMapper;

    public DefaultUserMapper(DefaultPasswordMapper defaultPasswordMapper) {
        this.defaultPasswordMapper = defaultPasswordMapper;
    }

    public DefaultUserDTO toUserDTO(DefaultUserEntity defaultUserEntity) {
        if (defaultUserEntity == null) {
            return null;
        }

        DefaultPasswordDTO mappedPasswordDTO = defaultPasswordMapper.toPasswordDTO(defaultUserEntity.getPassword());

        return new DefaultUserDTO(
                defaultUserEntity.getId(),
                defaultUserEntity.getName(),
                defaultUserEntity.getLastName(),
                defaultUserEntity.getEmail(),
                defaultUserEntity.getPhoneNumber(),
                defaultUserEntity.getLocation(),
                defaultUserEntity.getRole(),
                mappedPasswordDTO,
                defaultUserEntity.getCreatedAt(),
                defaultUserEntity.getUpdatedAt()
        );
    }

    public DefaultUserEntity toUser(DefaultUserDTO defaultUserDTO) {
        if (defaultUserDTO == null) {
            return null;
        }

        DefaultPasswordEntity mappedPasswordEntity = defaultPasswordMapper.toPasswordEntity(defaultUserDTO.getPassword());

        return new DefaultUserEntity(
                defaultUserDTO.getId(),
                defaultUserDTO.getName(),
                defaultUserDTO.getLastName(),
                defaultUserDTO.getEmail(),
                defaultUserDTO.getPhoneNumber(),
                defaultUserDTO.getLocation(),
                defaultUserDTO.getRole(),
                mappedPasswordEntity,
                defaultUserDTO.getCreatedAt(),
                defaultUserDTO.getUpdatedAt()
        );
    }
}