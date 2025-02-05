package davidrodriguez.com.uniquora.features.security.shared.mappers;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordMapper {
    public DefaultPasswordDTO toPasswordDTO(DefaultPasswordEntity defaultPasswordEntity) {
        if (defaultPasswordEntity == null) {
            return null;
        }

        return new DefaultPasswordDTO(
                defaultPasswordEntity.getId(),
                defaultPasswordEntity.getPassword()
        );
    }

    public DefaultPasswordEntity toPasswordEntity(DefaultPasswordDTO defaultPasswordDTO) {
        if (defaultPasswordDTO == null) {
            return null;
        }

        return new DefaultPasswordEntity(
                defaultPasswordDTO.getId(),
                defaultPasswordDTO.getPassword()
        );
    }
}
