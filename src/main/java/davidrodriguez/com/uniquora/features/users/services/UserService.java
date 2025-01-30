package davidrodriguez.com.uniquora.features.users.services;

import davidrodriguez.com.uniquora.features.users.domain.User;
import davidrodriguez.com.uniquora.features.users.dtos.UserDTO;
import davidrodriguez.com.uniquora.features.users.mappers.UserMapper;
import davidrodriguez.com.uniquora.features.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.MAPPER::userToUserDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper.MAPPER::userToUserDTO);
    }
}
