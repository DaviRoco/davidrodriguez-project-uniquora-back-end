package davidrodriguez.com.uniquora.features.users.mappers;
import davidrodriguez.com.uniquora.features.users.domain.User;
import davidrodriguez.com.uniquora.features.users.dtos.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role.name", target = "role")
    UserDTO userToUserDTO(User user);
}
