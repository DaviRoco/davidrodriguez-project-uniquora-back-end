package davidrodriguez.com.uniquora.features.user.get_user_by_email.services;

import davidrodriguez.com.uniquora.features.user.get_user_by_email.repositories.GetUserByEmailRepository;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTO.getMockDefaultUserDTO;
import static davidrodriguez.com.uniquora.mockEntities.user.entities.MockUserEntity.getMockDefaultUserEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@Service
public class GetUserByEmailServiceTest {
    @Mock
    private GetUserByEmailRepository getUserByEmailRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetUserByEmailService getUserByEmailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnUserByEmailWhenUserExists() {
        DefaultUserEntity mockDefaultUserEntity = getMockDefaultUserEntity();

        when(modelMapper.map(any(DefaultUserEntity.class), eq(DefaultUserDTO.class))).thenAnswer(invocation -> getMockDefaultUserDTO());
        when(getUserByEmailRepository.findByEmail(mockDefaultUserEntity.getEmail())).thenReturn(Optional.of(mockDefaultUserEntity));
        DefaultUserDTO defaultUserDTO = getUserByEmailService.getUserByEmail(mockDefaultUserEntity.getEmail());

        assertEquals(mockDefaultUserEntity.getId(), defaultUserDTO.getId());
        assertEquals(mockDefaultUserEntity.getName(), defaultUserDTO.getName());
        assertEquals(mockDefaultUserEntity.getEmail(), defaultUserDTO.getEmail());
    }

    @Test
    void shouldNotReturnUserByEmailWhenUserDoesNotExist() {
        when(getUserByEmailRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> getUserByEmailService.getUserByEmail("john@example.com"));

        assertEquals("User not found", exception.getMessage());
    }
}
