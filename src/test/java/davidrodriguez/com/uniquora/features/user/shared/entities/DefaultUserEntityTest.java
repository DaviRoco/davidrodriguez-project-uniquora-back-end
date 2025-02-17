package davidrodriguez.com.uniquora.features.user.shared.entities;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.enumerations.Role;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;
import davidrodriguez.com.uniquora.mockEntities.user.entities.MockUserEntityList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.getMockDefaultPasswordEntity;
import static davidrodriguez.com.uniquora.mockEntities.user.entities.MockUserEntity.getMockDefaultUserEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultUserEntityTest {
    private DefaultPasswordEntity mockPassword;

    @BeforeEach
    public void setUp() {
        mockPassword = getMockDefaultPasswordEntity();
    }

    @Test
    void shouldGetAllAttributes() {
        DefaultUserEntity defaultUserEntity = getMockDefaultUserEntity();

        assertThat(defaultUserEntity.getId()).isEqualTo(1L);
        assertThat(defaultUserEntity.getName()).isEqualTo("John");
        assertThat(defaultUserEntity.getLastName()).isEqualTo("Doe");
        assertThat(defaultUserEntity.getEmail()).isEqualTo("test@email.com");
        assertThat(defaultUserEntity.getPhoneNumber()).isEqualTo("+506123456");
        assertThat(defaultUserEntity.getLocation()).isEqualTo("Costa Rica");
        assertThat(defaultUserEntity.getRole()).isEqualTo(Role.ADMIN);
        assertThat(defaultUserEntity.getPassword().getId()).isEqualTo(mockPassword.getId());
        assertThat(defaultUserEntity.getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(defaultUserEntity.getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultUserEntity> newDefaultUserEntityList = new MockUserEntityList().createMockDefaultUserEntityList(1);

        DefaultUserEntity mockDefaultUserEntitySet = new DefaultUserEntity();
        mockDefaultUserEntitySet.setId(1L);
        mockDefaultUserEntitySet.setName("Jane");
        mockDefaultUserEntitySet.setLastName("Smith");
        mockDefaultUserEntitySet.setEmail("jane1@email.com");
        mockDefaultUserEntitySet.setPhoneNumber("+123456789");
        mockDefaultUserEntitySet.setLocation("USA");
        mockDefaultUserEntitySet.setRole(Role.USER);
        mockDefaultUserEntitySet.setPassword(mockPassword);
        mockDefaultUserEntitySet.setCreatedAt(new Date());
        mockDefaultUserEntitySet.setUpdatedAt(new Date());

        assertThat(newDefaultUserEntityList.get(0).getId()).isEqualTo(1L);
        assertThat(newDefaultUserEntityList.get(0).getName()).isEqualTo("Jane");
        assertThat(newDefaultUserEntityList.get(0).getLastName()).isEqualTo("Smith");
        assertThat(newDefaultUserEntityList.get(0).getEmail()).isEqualTo("jane1@email.com");
        assertThat(newDefaultUserEntityList.get(0).getPhoneNumber()).isEqualTo("+123456789");
        assertThat(newDefaultUserEntityList.get(0).getLocation()).isEqualTo("USA");
        assertThat(newDefaultUserEntityList.get(0).getRole()).isEqualTo(Role.USER);
        assertThat(newDefaultUserEntityList.get(0).getPassword().getId()).isEqualTo(mockPassword.getId());
        assertThat(newDefaultUserEntityList.get(0).getCreatedAt()).isEqualTo(MockDates.getCreatedAt());
        assertThat(newDefaultUserEntityList.get(0).getUpdatedAt()).isEqualTo(MockDates.getUpdatedAt());
    }
}
