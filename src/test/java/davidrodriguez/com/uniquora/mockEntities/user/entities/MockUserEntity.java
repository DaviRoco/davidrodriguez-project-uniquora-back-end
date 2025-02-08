package davidrodriguez.com.uniquora.mockEntities.user.entities;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.user.shared.entities.DefaultUserEntity;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.entities.MockPasswordEntity.createMockDefaultPasswordEntity;

public class MockUserEntity {
    public static DefaultUserEntity createMockDefaultUserEntity() {
        return new DefaultUserEntity(
                1L,
                "John",
                "Doe",
                "test@email.com",
                "+506123456",
                "Costa Rica",
                Role.ADMIN,
                createMockDefaultPasswordEntity(),
                MockDates.getCreatedAt(),
                MockDates.getUpdatedAt()
        );
    }

    public List<DefaultUserEntity> createMockDefaultUserEntityList(int count) {
        List<DefaultUserEntity> userList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            userList.add(new DefaultUserEntity(
                    (long) i + 1,
                    "Jane",
                    "Smith",
                    "jane" + (i + 1) + "@email.com",
                    "+123456789",
                    "USA",
                    Role.USER,
                    createMockDefaultPasswordEntity(),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return userList;
    }
}
