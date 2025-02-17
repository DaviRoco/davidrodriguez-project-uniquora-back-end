package davidrodriguez.com.uniquora.features.product.get_all_products.controller;

import davidrodriguez.com.uniquora.features.product.get_all_products.service.GetAllProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class GetAllProductsController {
    private final GetAllProductsService getAllProductsService;

    public GetAllProductsController(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            return ResponseEntity.ok(getAllProductsService.getAllProducts());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
