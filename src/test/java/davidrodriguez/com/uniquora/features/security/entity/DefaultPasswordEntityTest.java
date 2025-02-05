package davidrodriguez.com.uniquora.features.security.entity;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPasswordEntityTest {
    @BeforeEach
    public void setUp() {

    }

    @Test
    void shouldGetAllAttributes() {
        DefaultPasswordEntity mockDefaultPasswordEntity = new DefaultPasswordEntity(1L, "test");

        assertThat(mockDefaultPasswordEntity.getId()).isEqualTo(1L);
        assertThat(mockDefaultPasswordEntity.matches("test")).isEqualTo(true);
    }

    @Test
    void shouldSetAllAttributes() {
        DefaultPasswordEntity newDefaultPasswordEntity = new DefaultPasswordEntity();
        newDefaultPasswordEntity.setId(2L);
        newDefaultPasswordEntity.setPassword("newPassword");

        assertThat(newDefaultPasswordEntity.getId()).isEqualTo(2L);
        assertThat(newDefaultPasswordEntity.matches("newPassword")).isEqualTo(true);
    }
}
