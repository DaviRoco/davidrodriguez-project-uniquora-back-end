package davidrodriguez.com.uniquora.features.user.shared.dtos;

import davidrodriguez.com.uniquora.enumerations.Role;
import davidrodriguez.com.uniquora.features.security.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTOList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.getMockDefaultPasswordDTO;
import static davidrodriguez.com.uniquora.mockEntities.user.dtos.MockUserDTO.getMockDefaultUserDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserDTOTest {
    private DefaultPasswordDTO mockPassword;

    @BeforeEach
    public void setUp() {
        mockPassword = getMockDefaultPasswordDTO();
    }

    @Test
    void shouldGetAllAttributes() {
        final DefaultUserDTO mockDefaultUserDTO = getMockDefaultUserDTO();

        assertThat(mockDefaultUserDTO.getId()).isEqualTo(1L);
        assertThat(mockDefaultUserDTO.getName()).isEqualTo("John");
        assertThat(mockDefaultUserDTO.getLastName()).isEqualTo("Doe");
        assertThat(mockDefaultUserDTO.getEmail()).isEqualTo("test@email.com");
        assertThat(mockDefaultUserDTO.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(mockDefaultUserDTO.getLocation()).isEqualTo("Costa Rica");
        assertThat(mockDefaultUserDTO.getRole()).isEqualTo(Role.ADMIN);
        assertThat(mockDefaultUserDTO.getPassword().getId()).isEqualTo(mockPassword.getId());
        assertThat(mockDefaultUserDTO.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(mockDefaultUserDTO.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultUserDTO> newDefaultUserDTOList = new MockUserDTOList().createMockDefaultUserDTOList(1);

        final DefaultUserDTO mockDefaultUserDTOSet = new DefaultUserDTO();
        mockDefaultUserDTOSet.setId(1L);
        mockDefaultUserDTOSet.setName("Jane");
        mockDefaultUserDTOSet.setLastName("Smith");
        mockDefaultUserDTOSet.setEmail("jane1@email.com");
        mockDefaultUserDTOSet.setPhoneNumber("+123456789");
        mockDefaultUserDTOSet.setLocation("USA");
        mockDefaultUserDTOSet.setRole(Role.USER);
        mockDefaultUserDTOSet.setPassword(mockPassword);
        mockDefaultUserDTOSet.setCreatedAt(new Date());
        mockDefaultUserDTOSet.setUpdatedAt(new Date());

        assertThat(newDefaultUserDTOList.get(0).getId()).isEqualTo(mockDefaultUserDTOSet.getId());
        assertThat(newDefaultUserDTOList.get(0).getName()).isEqualTo(mockDefaultUserDTOSet.getName());
        assertThat(newDefaultUserDTOList.get(0).getLastName()).isEqualTo(mockDefaultUserDTOSet.getLastName());
        assertThat(newDefaultUserDTOList.get(0).getEmail()).isEqualTo(mockDefaultUserDTOSet.getEmail());
        assertThat(newDefaultUserDTOList.get(0).getPhoneNumber()).isEqualTo(mockDefaultUserDTOSet.getPhoneNumber());
        assertThat(newDefaultUserDTOList.get(0).getLocation()).isEqualTo(mockDefaultUserDTOSet.getLocation());
        assertThat(newDefaultUserDTOList.get(0).getRole()).isEqualTo(mockDefaultUserDTOSet.getRole());
        assertThat(newDefaultUserDTOList.get(0).getPassword().getId()).isEqualTo(mockPassword.getId());
        assertThat(newDefaultUserDTOList.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultUserDTOList.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }


}
