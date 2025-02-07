package davidrodriguez.com.uniquora.mockEntities.security.dtos;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;

public class MockPasswordDTO {
    public static DefaultPasswordDTO createMockPasswordDTO() {
        return new DefaultPasswordDTO(
                1L,
                "MockPassword"
        );
    }
}
