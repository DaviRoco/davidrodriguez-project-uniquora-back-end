package davidrodriguez.com.uniquora.features.user.mappers;

import davidrodriguez.com.uniquora.features.user.domain.User;
import davidrodriguez.com.uniquora.features.user.dtos.UserDTO;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getLocation()
        );
    }

    public User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setLocation(userDTO.getLocation());
        return user;
    }
}