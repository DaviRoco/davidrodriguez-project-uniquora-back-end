package davidrodriguez.com.uniquora.mockEntities.security.entities;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;

public class MockPasswordEntity {
    public static DefaultPasswordEntity createMockPasswordEntity() {
        return new DefaultPasswordEntity(
                1L,
                "MockPassword"
        );
    }
}
