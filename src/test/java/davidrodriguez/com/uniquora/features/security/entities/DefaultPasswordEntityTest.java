package davidrodriguez.com.uniquora.features.security.entities;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.createMockDefaultPasswordEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordEntityTest {
    @BeforeEach
    public void setUp() {

    }

    @Test
    void shouldGetAllAttributes() {
        DefaultPasswordEntity mockDefaultPasswordEntity = createMockDefaultPasswordEntity();

        assertThat(mockDefaultPasswordEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultPasswordEntity.matches("Test Password")).isEqualTo(true);
    }

    @Test
    void shouldSetAllAttributes() {
        List<DefaultPasswordEntity> mockDefaultPasswordEntity = new MockPasswordEntity().createMockDefaultPasswordEntityList(1);

        DefaultPasswordEntity newDefaultPasswordEntity = new DefaultPasswordEntity();
        newDefaultPasswordEntity.setId(1L);
        newDefaultPasswordEntity.setPassword("newPassword");

        assertThat(newDefaultPasswordEntity.getId()).isEqualTo(mockDefaultPasswordEntity.get(0).getId());
        assertThat(newDefaultPasswordEntity.matches("Test Password")).isEqualTo(mockDefaultPasswordEntity.get(0).getPassword().matches("Test Password"));
    }
}
