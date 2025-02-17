package davidrodriguez.com.uniquora.features.brand.delete_brand.controller;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.delete_brand.service.DeleteBrandService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand/")
public class DeleteBrandController {
    private final DeleteBrandService deleteBrandService;

    public DeleteBrandController(DeleteBrandService deleteBrandService) {
        this.deleteBrandService = deleteBrandService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        try {
            DefaultBrandDTO deletedBrand = deleteBrandService.deleteBrand(id);
            return ResponseEntity.ok(deletedBrand);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
