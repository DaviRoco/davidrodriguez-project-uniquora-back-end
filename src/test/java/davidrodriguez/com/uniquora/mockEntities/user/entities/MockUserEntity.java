package davidrodriguez.com.uniquora.mockEntities.user.entities;

import davidrodriguez.com.uniquora.enumerations.Role;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.getMockDefaultPasswordEntity;

public class MockUserEntity {
    private static DefaultUserEntity instance;

    private MockUserEntity() {

    }

    public static DefaultUserEntity getMockDefaultUserEntity() {
        if (instance == null) {
            instance = new DefaultUserEntity(
                    1L,
                    "John",
                    "Doe",
                    "test@email.com",
                    "+506123456",
                    "Costa Rica",
                    Role.ADMIN,
                    getMockDefaultPasswordEntity(),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }
}
