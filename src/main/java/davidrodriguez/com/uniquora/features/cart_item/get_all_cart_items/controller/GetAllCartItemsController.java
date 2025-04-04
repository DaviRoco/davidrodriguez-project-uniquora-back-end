package davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.controller;

import davidrodriguez.com.uniquora.features.cart_item.get_all_cart_items.service.GetAllCartItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart-item")
public class GetAllCartItemsController {
    private final GetAllCartItemsService getAllCartItemsService;

    public GetAllCartItemsController(GetAllCartItemsService getAllCartItemsService) {
        this.getAllCartItemsService = getAllCartItemsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCartItems() {
        try {
            return ResponseEntity.ok(getAllCartItemsService.getAllCartItems());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
