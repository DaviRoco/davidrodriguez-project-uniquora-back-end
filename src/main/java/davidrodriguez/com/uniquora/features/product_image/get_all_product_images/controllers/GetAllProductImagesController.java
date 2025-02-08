package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.controllers;

import davidrodriguez.com.uniquora.features.product_image.get_all_product_images.services.GetAllProductImagesService;
import davidrodriguez.com.uniquora.features.product_image.shared.dtos.DefaultProductImageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-image")
public class GetAllProductImagesController {
    private final GetAllProductImagesService getAllProductImagesService;

    public GetAllProductImagesController(GetAllProductImagesService getAllProductImagesService) {
        this.getAllProductImagesService = getAllProductImagesService;
    }

    @GetMapping
    public ResponseEntity<List<DefaultProductImageDTO>> getAllProductImages() {
        return ResponseEntity.ok(getAllProductImagesService.getAllProductImages());
    }
}
