package davidrodriguez.com.uniquora.features.brand.get_all_brands.controller;

import davidrodriguez.com.uniquora.features.brand.get_all_brands.service.GetAllBrandsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class GetAllBrandsController {
    private final GetAllBrandsService getAllBrandsService;

    public GetAllBrandsController(GetAllBrandsService getAllBrandsService) {
        this.getAllBrandsService = getAllBrandsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        try {
            return ResponseEntity.ok(getAllBrandsService.getAllBrands());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
