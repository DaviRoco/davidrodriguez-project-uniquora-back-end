package davidrodriguez.com.uniquora.mockEntities.security.entities;

import davidrodriguez.com.uniquora.features.security.shared.entities.DefaultPasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class MockPasswordEntity {
    public static DefaultPasswordEntity createMockDefaultPasswordEntity() {
        return new DefaultPasswordEntity(
                1L,
                "Test Password"
        );
    }

    public List<DefaultPasswordEntity> createMockDefaultPasswordEntityList(int count) {
        List<DefaultPasswordEntity> passwordList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            passwordList.add(new DefaultPasswordEntity(
                    (long) i + 1,
                    "Test Password"
            ));
        }

        return passwordList;
    }
}
