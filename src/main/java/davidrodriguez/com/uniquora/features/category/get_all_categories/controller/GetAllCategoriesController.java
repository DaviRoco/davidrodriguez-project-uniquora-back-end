package davidrodriguez.com.uniquora.features.category.get_all_categories.controller;

import davidrodriguez.com.uniquora.features.category.get_all_categories.service.GetAllCategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class GetAllCategoriesController {
    private final GetAllCategoriesService getAllCategoriesService;

    public GetAllCategoriesController(GetAllCategoriesService getAllCategoriesService) {
        this.getAllCategoriesService = getAllCategoriesService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        try {
            return ResponseEntity.ok(getAllCategoriesService.getAllCategories());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
