package davidrodriguez.com.uniquora.features.user.get_all_users.controllers;

import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import davidrodriguez.com.uniquora.features.user.get_all_users.services.GetAllUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class GetAllUsersController {
    private final GetAllUsersService getAllUsersService;

    public GetAllUsersController(GetAllUsersService getAllUsersService) {
        this.getAllUsersService = getAllUsersService;
    }

    @GetMapping
    public ResponseEntity<List<DefaultUserDTO>> getAllUsers() {
        return ResponseEntity.ok(getAllUsersService.getAllUsers());
    }

}
