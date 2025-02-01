package davidrodriguez.com.uniquora.features.security.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {
    @BeforeEach
    public void setUp() {

    }

    @Test
    void shouldGetAllAttributes() {
        Password mockPassword = new Password(1L, "test");

        assertThat(mockPassword.getId()).isEqualTo(1L);
        assertThat(mockPassword.matches("test")).isEqualTo(true);
    }

    @Test
    void shouldSetAllAttributes() {
        Password newPassword = new Password();
        newPassword.setId(2L);
        newPassword.setPassword("newPassword");

        assertThat(newPassword.getId()).isEqualTo(2L);
        assertThat(newPassword.matches("newPassword")).isEqualTo(true);
    }
}
