package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.logic.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured("ROLE_USER")
@RequestMapping("/login")
public class LoginEndpoint {
    private final UserService userService;

    public LoginEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    String login() {
        return userService.login();
    }
}
