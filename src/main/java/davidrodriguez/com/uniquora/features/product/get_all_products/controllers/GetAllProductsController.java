package davidrodriguez.com.uniquora.features.product.get_all_products.controllers;

import davidrodriguez.com.uniquora.features.product.get_all_products.services.GetAllProductsService;
import davidrodriguez.com.uniquora.features.product.shared.dtos.DefaultProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class GetAllProductsController {
    private final GetAllProductsService getAllProductsService;

    public GetAllProductsController(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @GetMapping
    public ResponseEntity<List<DefaultProductDTO>> getAllProducts() {
        return ResponseEntity.ok(getAllProductsService.getAllProducts());
    }
}
