package davidrodriguez.com.uniquora.mockEntities.user.dtos;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.getMockDefaultPasswordDTO;

public class MockUserDTO {
    private static DefaultUserDTO instance;

    private MockUserDTO() {

    }

    public static DefaultUserDTO getMockDefaultUserDTO() {
        if (instance == null) {
            instance = new DefaultUserDTO(
                    1L,
                    "John",
                    "Doe",
                    "test@email.com",
                    "+506123456",
                    "Costa Rica",
                    Role.ADMIN,
                    getMockDefaultPasswordDTO(),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            );
        }

        return instance;
    }
}

