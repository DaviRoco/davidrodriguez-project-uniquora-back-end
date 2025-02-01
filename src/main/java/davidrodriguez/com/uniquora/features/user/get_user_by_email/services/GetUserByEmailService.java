package davidrodriguez.com.uniquora.features.user.get_user_by_email.services;

import davidrodriguez.com.uniquora.features.user.get_user_by_email.repositories.GetUserByEmailRepository;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.shared.entity.DefaultUserEntity;
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
        DefaultUserEntity defaultUserEntity = getUserByEmailRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(defaultUserEntity, DefaultUserDTO.class);
    }
}
