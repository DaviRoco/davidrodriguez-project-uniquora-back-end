package davidrodriguez.com.uniquora.mockEntities.security.entities;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;

public class MockPasswordEntity {
    private static DefaultPasswordEntity instance;

    private MockPasswordEntity() {

    }

    public static DefaultPasswordEntity getMockDefaultPasswordEntity() {
        if (instance == null) {
            instance = new DefaultPasswordEntity(
                    1L,
                    "Test Password"
            );
        }

        return instance;
    }
}
