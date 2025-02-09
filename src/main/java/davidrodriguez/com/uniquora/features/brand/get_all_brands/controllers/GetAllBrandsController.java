package davidrodriguez.com.uniquora.features.brand.get_all_brands.controllers;

import davidrodriguez.com.uniquora.features.brand.get_all_brands.services.GetAllBrandsService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class GetAllBrandsController {
    private final GetAllBrandsService getAllBrandsService;

    public GetAllBrandsController(GetAllBrandsService getAllBrandsService) {
        this.getAllBrandsService = getAllBrandsService;
    }

    @GetMapping
    public ResponseEntity<List<DefaultBrandDTO>> getAllBrands() {
        return ResponseEntity.ok(getAllBrandsService.getAllBrands());
    }
}
