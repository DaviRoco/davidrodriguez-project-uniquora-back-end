package davidrodriguez.com.uniquora.features.brand.update_brand.controllers;

import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.update_brand.services.UpdateBrandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class UpdateBrandController {
    private final UpdateBrandService updateBrandService;

    public UpdateBrandController(UpdateBrandService updateBrandService) {
        this.updateBrandService = updateBrandService;
    }

    @PutMapping
    public ResponseEntity<DefaultBrandDTO> updateBrand(@Valid @RequestBody DefaultBrandDTO defaultBrandDTO) {
        DefaultBrandDTO updatedBrand = updateBrandService.updateBrand(defaultBrandDTO);
        return ResponseEntity.ok(updatedBrand);
    }
}
