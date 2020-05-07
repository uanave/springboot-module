package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.logic.UserService;
import academy.everyonecodes.users.persistence.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Secured("ROLE_APP")
public class UsersEndpoint {
    private final UserService userService;

    public UsersEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User post(@RequestBody User user) {
        return userService.save(user);
    }
}
