package davidrodriguez.com.uniquora.features.user.get_all_users.services;

import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.features.user.shared.repositories.DefaultUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@Service
public class GetAllUsersServiceTest {

    @Mock
    private DefaultUserRepository defaultUserRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GetAllUsersService getAllUsersService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllUsers() {
        List<DefaultUserEntity> mockDefaultUserEntities = new ArrayList<>();
        mockDefaultUserEntities.add(new DefaultUserEntity(1L, "John Doe", "john@example.com"));
        mockDefaultUserEntities.add(new DefaultUserEntity(2L, "Jane Doe", "jane@example.com"));
        mockDefaultUserEntities.add(new DefaultUserEntity(3L, "Jack Doe", "jack@example.com"));

        when(modelMapper.map(any(DefaultUserEntity.class), eq(DefaultUserDTO.class))).thenAnswer(invocation -> {
            DefaultUserEntity defaultUserEntity = invocation.getArgument(0);
            return new DefaultUserDTO(defaultUserEntity.getId(), defaultUserEntity.getName(), defaultUserEntity.getEmail());
        });
        when(defaultUserRepository.findAll()).thenReturn(mockDefaultUserEntities);
        List<DefaultUserDTO> defaultUserDTOList = getAllUsersService.getAllUsers();

        assertEquals(mockDefaultUserEntities.size(), defaultUserDTOList.size());
        assertThat(defaultUserDTOList).isNotEmpty();
        assertThat(defaultUserDTOList).isNotNull()
                .extracting(DefaultUserDTO::getId)
                .containsExactly(1L, 2L, 3L);
    }
}
