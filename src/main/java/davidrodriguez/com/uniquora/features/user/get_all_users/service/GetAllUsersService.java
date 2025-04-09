package davidrodriguez.com.uniquora.features.user.get_all_users.service;

import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.shared.repositories.DefaultUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsersService {
    private final DefaultUserRepository defaultUserRepository;
    private final ModelMapper modelMapper;

    public GetAllUsersService(DefaultUserRepository defaultUserRepository, ModelMapper modelMapper) {
        this.defaultUserRepository = defaultUserRepository;
        this.modelMapper = modelMapper;
    }

    public List<DefaultUserDTO> getAllUsers() {
        try {
            final List<DefaultUserEntity> defaultUserEntities = defaultUserRepository.findAll();
            return defaultUserEntities.stream()
                    .map(user -> modelMapper.map(user, DefaultUserDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException("Could not get all users due to an internal error.");
        }
    }
}
