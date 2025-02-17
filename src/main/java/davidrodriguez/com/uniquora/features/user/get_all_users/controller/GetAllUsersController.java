package davidrodriguez.com.uniquora.features.user.get_all_users.controller;

import davidrodriguez.com.uniquora.features.user.get_all_users.service.GetAllUsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class GetAllUsersController {
    private final GetAllUsersService getAllUsersService;

    public GetAllUsersController(GetAllUsersService getAllUsersService) {
        this.getAllUsersService = getAllUsersService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(getAllUsersService.getAllUsers());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

}
