package davidrodriguez.com.uniquora.mockEntities.security.dtos;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;

public class MockPasswordDTO {
    private static DefaultPasswordDTO instance;

    private MockPasswordDTO() {

    }

    public static DefaultPasswordDTO getMockDefaultPasswordDTO() {
        if (instance == null) {
            instance = new DefaultPasswordDTO(
                    1L,
                    "Test Password"
            );
        }

        return instance;
    }
}
