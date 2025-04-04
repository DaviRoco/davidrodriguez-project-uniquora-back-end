package davidrodriguez.com.uniquora.features.product_image.get_all_product_images.controller;

import davidrodriguez.com.uniquora.features.product_image.get_all_product_images.service.GetAllProductImagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-image")
public class GetAllProductImagesController {
    private final GetAllProductImagesService getAllProductImagesService;

    public GetAllProductImagesController(GetAllProductImagesService getAllProductImagesService) {
        this.getAllProductImagesService = getAllProductImagesService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProductImages() {
        try {
            return ResponseEntity.ok(getAllProductImagesService.getAllProductImages());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
