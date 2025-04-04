package davidrodriguez.com.uniquora.features.cart.get_all_carts.controller;

import davidrodriguez.com.uniquora.features.cart.get_all_carts.service.GetAllCartsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class GetAllCartsController {
    private final GetAllCartsService getAllCartsService;

    public GetAllCartsController(GetAllCartsService getAllCartsService) {
        this.getAllCartsService = getAllCartsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCarts() {
        try {
            return ResponseEntity.ok(getAllCartsService.getAllCarts());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
