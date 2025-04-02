package davidrodriguez.com.uniquora.features.category.get_all_categories.controller;

import davidrodriguez.com.uniquora.features.category.get_all_categories.service.GetAllCategoriesService;
import davidrodriguez.com.uniquora.features.category.shared.dtos.DefaultCategoryDTO;
import davidrodriguez.com.uniquora.mockEntities.category.dtos.MockCategoryDTOList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetAllCategoriesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetAllCategoriesService getAllCategoriesService;

    @InjectMocks
    private GetAllCategoriesController getAllCategoriesController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getAllCategoriesController).build();
    }

    @Test
    void shouldReturnAllCategories() throws Exception {
        List<DefaultCategoryDTO> mockCategories = new MockCategoryDTOList().createMockDefaultCategoryDTOList(1);

        when(getAllCategoriesService.getAllCategories()).thenReturn(mockCategories);

        mockMvc.perform(get("/api/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockCategories.size()))
                .andExpect(jsonPath("$[0].id").value(mockCategories.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(mockCategories.get(0).getName()))
                .andExpect(jsonPath("$[0].createdAt").value(mockCategories.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[0].updatedAt").value(mockCategories.get(0).getUpdatedAt()));

        verify(getAllCategoriesService, times(1)).getAllCategories();
    }

    @Test
    void shouldNotReturnCategoriesWhenInternalServerError() throws Exception {
        when(getAllCategoriesService.getAllCategories())
                .thenThrow(new RuntimeException("Could not get all categories due to an internal error."));

        mockMvc.perform(get("/api/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
