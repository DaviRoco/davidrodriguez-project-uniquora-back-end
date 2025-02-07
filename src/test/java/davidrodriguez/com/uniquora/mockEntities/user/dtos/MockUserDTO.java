package davidrodriguez.com.uniquora.mockEntities.user.dtos;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.createMockPasswordDTO;

public class MockUserDTO {

    public static DefaultUserDTO createMockDefaultUserDTO() {
        return new DefaultUserDTO(
                1L,
                "John",
                "Doe",
                "test@email.com",
                "+506123456",
                "Costa Rica",
                Role.ADMIN,
                createMockPasswordDTO(),
                new Date(),
                new Date()
        );
    }

    public static List<DefaultUserDTO> createMockDefaultUserDTOList(int count) {
        List<DefaultUserDTO> userList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            userList.add(new DefaultUserDTO(
                    (long) i + 1,
                    "Jane",
                    "Smith",
                    "jane" + (i + 1) + "@email.com",
                    "+123456789",
                    "USA",
                    Role.USER,
                    createMockPasswordDTO(),
                    new Date(),
                    new Date()
            ));
        }

        return userList;
    }

}

