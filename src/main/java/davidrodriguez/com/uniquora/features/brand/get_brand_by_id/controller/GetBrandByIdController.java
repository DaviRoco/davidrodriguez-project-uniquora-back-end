package davidrodriguez.com.uniquora.features.brand.get_brand_by_id.controller;

import davidrodriguez.com.uniquora.exceptions.ResourceNotFoundException;
import davidrodriguez.com.uniquora.features.brand.get_brand_by_id.service.GetBrandByIdService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class GetBrandByIdController {
    private final GetBrandByIdService getBrandByIdService;

    public GetBrandByIdController(GetBrandByIdService getBrandByIdService) {
        this.getBrandByIdService = getBrandByIdService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Long id) {
        try {
            final DefaultBrandDTO foundBrand = getBrandByIdService.getBrandById(id);
            return ResponseEntity.ok(foundBrand);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
