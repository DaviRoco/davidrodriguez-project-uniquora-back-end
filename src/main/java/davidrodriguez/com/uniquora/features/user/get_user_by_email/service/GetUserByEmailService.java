package davidrodriguez.com.uniquora.features.user.get_user_by_email.service;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.user.get_user_by_email.repository.GetUserByEmailRepository;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class GetUserByEmailService {
    private final GetUserByEmailRepository getUserByEmailRepository;
    private final ModelMapper modelMapper;

    public GetUserByEmailService(GetUserByEmailRepository getUserByEmailRepository, ModelMapper modelMapper) {
        this.getUserByEmailRepository = getUserByEmailRepository;
        this.modelMapper = modelMapper;
    }

    public DefaultUserDTO getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("User email cannot be null");
        }

        try {
            DefaultUserEntity existingUserEntity = getUserByEmailRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));

            return modelMapper.map(existingUserEntity, DefaultUserDTO.class);
        } catch (Exception exception) {
            throw new RuntimeException("Could not find user by email due to an internal error.");
        }
    }
}
