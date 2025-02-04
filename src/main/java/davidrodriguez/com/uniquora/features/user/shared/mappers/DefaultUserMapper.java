package davidrodriguez.com.uniquora.features.user.shared.mappers;

import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class DefaultUserMapper {

    public DefaultUserDTO toUserDTO(DefaultUserEntity defaultUserEntity) {
        if (defaultUserEntity == null) {
            return null;
        }
        return new DefaultUserDTO(
                defaultUserEntity.getId(),
                defaultUserEntity.getName(),
                defaultUserEntity.getLastName(),
                defaultUserEntity.getEmail(),
                defaultUserEntity.getPhoneNumber(),
                defaultUserEntity.getLocation(),
                defaultUserEntity.getRole(),
                defaultUserEntity.getPasswordHash(),
                defaultUserEntity.getCreatedAt(),
                defaultUserEntity.getUpdatedAt()
        );
    }

    public DefaultUserEntity toUser(DefaultUserDTO defaultUserDTO) {
        if (defaultUserDTO == null) {
            return null;
        }
        DefaultUserEntity defaultUserEntity = new DefaultUserEntity();
        defaultUserEntity.setId(defaultUserDTO.getId());
        defaultUserEntity.setName(defaultUserDTO.getName());
        defaultUserEntity.setLastName(defaultUserDTO.getLastName());
        defaultUserEntity.setEmail(defaultUserDTO.getEmail());
        defaultUserEntity.setPhoneNumber(defaultUserDTO.getPhoneNumber());
        defaultUserEntity.setLocation(defaultUserDTO.getLocation());
        defaultUserEntity.setRole(defaultUserDTO.getRole());
        defaultUserEntity.setPasswordHash(defaultUserDTO.getPassword());
        defaultUserEntity.setCreatedAt(defaultUserDTO.getCreatedAt());
        defaultUserEntity.setUpdatedAt(defaultUserDTO.getUpdatedAt());

        return defaultUserEntity;
    }
}