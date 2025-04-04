package davidrodriguez.com.uniquora.mockEntities.security.entities;

import davidrodriguez.com.uniquora.features.security.entities.DefaultPasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class MockPasswordEntityList {
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
