package davidrodriguez.com.uniquora.features.order.get_all_orders.controller;

import davidrodriguez.com.uniquora.features.order.get_all_orders.service.GetAllOrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class GetAllOrdersController {
    private final GetAllOrdersService getAllOrdersService;

    public GetAllOrdersController(GetAllOrdersService getAllOrdersService) {
        this.getAllOrdersService = getAllOrdersService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        try {
            return ResponseEntity.ok(getAllOrdersService.getAllOrders());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }
}
