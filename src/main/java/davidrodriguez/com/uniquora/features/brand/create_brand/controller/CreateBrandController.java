package davidrodriguez.com.uniquora.features.brand.create_brand.controller;

import davidrodriguez.com.uniquora.features.brand.create_brand.service.CreateBrandService;
import davidrodriguez.com.uniquora.features.brand.shared.dtos.DefaultBrandDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class CreateBrandController {
    private final CreateBrandService createBrandService;

    public CreateBrandController(CreateBrandService createBrandService) {
        this.createBrandService = createBrandService;
    }

    @PostMapping
    public ResponseEntity<?> createBrand(@Valid @RequestBody DefaultBrandDTO defaultBrandDTO) {
        try {
            DefaultBrandDTO createdBrand = createBrandService.createBrand(defaultBrandDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }
}
