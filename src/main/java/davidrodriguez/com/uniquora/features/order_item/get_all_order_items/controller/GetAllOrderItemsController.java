package davidrodriguez.com.uniquora.features.order_item.get_all_order_items.controller;

import davidrodriguez.com.uniquora.features.order_item.get_all_order_items.service.GetAllOrderItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-item")
public class GetAllOrderItemsController {

    private final GetAllOrderItemsService getAllOrderItemsService;

    public GetAllOrderItemsController(GetAllOrderItemsService getAllOrderItemsService) {
        this.getAllOrderItemsService = getAllOrderItemsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrderItems() {
        try {
            return ResponseEntity.ok(getAllOrderItemsService.getAllOrderItems());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
