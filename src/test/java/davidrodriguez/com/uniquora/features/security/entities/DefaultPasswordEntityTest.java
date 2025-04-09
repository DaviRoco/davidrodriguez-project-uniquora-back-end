package davidrodriguez.com.uniquora.features.security.entities;

import davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntityList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.getMockDefaultPasswordEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordEntityTest {
    @BeforeEach
    public void setUp() {

    }

    @Test
    void shouldGetAllAttributes() {
        final DefaultPasswordEntity mockDefaultPasswordEntity = getMockDefaultPasswordEntity();

        assertThat(mockDefaultPasswordEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultPasswordEntity.getPassword()).isEqualTo("Test Password");
    }

    @Test
    void shouldSetAllAttributes() {
        final List<DefaultPasswordEntity> mockDefaultPasswordEntity = new MockPasswordEntityList().createMockDefaultPasswordEntityList(1);

        final DefaultPasswordEntity newDefaultPasswordEntity = new DefaultPasswordEntity();
        newDefaultPasswordEntity.setId(1L);
        newDefaultPasswordEntity.setPassword("Test Password");

        assertThat(newDefaultPasswordEntity.getId()).isEqualTo(mockDefaultPasswordEntity.get(0).getId());
        assertThat(newDefaultPasswordEntity.getPassword()).isEqualTo(mockDefaultPasswordEntity.get(0).getPassword());
    }
}
