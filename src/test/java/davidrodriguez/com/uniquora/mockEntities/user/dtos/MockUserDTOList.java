package davidrodriguez.com.uniquora.mockEntities.user.dtos;

import davidrodriguez.com.uniquora.enumeration.Role;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

import static davidrodriguez.com.uniquora.mockEntities.security.dtos.MockPasswordDTO.getMockDefaultPasswordDTO;

public class MockUserDTOList {

    public List<DefaultUserDTO> createMockDefaultUserDTOList(int count) {
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
                    getMockDefaultPasswordDTO(),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return userList;
    }
}
