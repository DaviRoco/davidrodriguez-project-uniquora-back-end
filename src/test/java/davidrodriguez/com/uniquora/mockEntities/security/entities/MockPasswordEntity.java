package davidrodriguez.com.uniquora.mockEntities.security.entities;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;
import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class MockPasswordEntity {
    private static DefaultPasswordEntity instance;

    private MockPasswordEntity() {

    }

    public static DefaultPasswordEntity createMockDefaultPasswordEntity() {
        if (instance == null) {
            instance = new DefaultPasswordEntity(
                    1L,
                    "Test Password"
            );
        }

        return instance;
    }
}
