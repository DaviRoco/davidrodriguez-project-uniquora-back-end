package davidrodriguez.com.uniquora.mockEntities.category.dtos;

import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.mockEntities.date.MockDates;

import java.util.ArrayList;
import java.util.List;

public class MockCategoryDTOList {
    public List<DefaultCategoryDTO> createMockDefaultCategoryDTOList(int count) {
        final List<DefaultCategoryDTO> categoryDTOList = new ArrayList<DefaultCategoryDTO>();

        for (int i = 0; i < count; i++) {
            categoryDTOList.add(new DefaultCategoryDTO(
                    (long) i + 1,
                    "Test Name " + (i + 1),
                    MockDates.getCreatedAt(),
                    MockDates.getUpdatedAt()
            ));
        }

        return categoryDTOList;
    }
}
