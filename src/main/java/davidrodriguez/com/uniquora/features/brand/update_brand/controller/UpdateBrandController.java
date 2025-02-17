package davidrodriguez.com.uniquora.features.brand.update_brand.controller;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import davidrodriguez.com.uniquora.features.brand.update_brand.service.UpdateBrandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> updateBrand(@Valid @RequestBody DefaultBrandDTO defaultBrandDTO) {
        try {
            return ResponseEntity.ok(updateBrandService.updateBrand(defaultBrandDTO));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
