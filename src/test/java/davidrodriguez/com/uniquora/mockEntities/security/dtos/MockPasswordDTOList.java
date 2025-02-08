package davidrodriguez.com.uniquora.mockEntities.security.dtos;

import davidrodriguez.com.uniquora.features.security.shared.dtos.DefaultPasswordDTO;

import java.util.ArrayList;
import java.util.List;

public class MockPasswordDTOList {
    public List<DefaultPasswordDTO> createMockDefaultPasswordDTOList(int count) {
        List<DefaultPasswordDTO> passwordList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            passwordList.add(new DefaultPasswordDTO(
                    (long) i + 1,
                    "Test Password"
            ));
        }

        return passwordList;
    }
}
