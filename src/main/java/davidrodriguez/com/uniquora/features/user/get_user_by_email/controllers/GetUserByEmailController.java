package davidrodriguez.com.uniquora.features.user.get_user_by_email.controllers;

import davidrodriguez.com.uniquora.features.user.get_user_by_email.services.GetUserByEmailService;
import davidrodriguez.com.uniquora.features.user.shared.dtos.DefaultUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class GetUserByEmailController {
    private final GetUserByEmailService getUserByEmailService;

    public GetUserByEmailController(GetUserByEmailService getUserByEmailService) {
        this.getUserByEmailService = getUserByEmailService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<DefaultUserDTO> getUserByEmail(@PathVariable String email) {
        Optional<DefaultUserDTO> user = Optional.ofNullable(getUserByEmailService.getUserByEmail(email));
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
