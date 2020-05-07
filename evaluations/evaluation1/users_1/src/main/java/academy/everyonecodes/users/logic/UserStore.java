package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("users")
public class UserStore {
    private List<User> users;

    void setUsers(List<User> users) {
        this.users = users;
    }

    public Optional<User> find(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}
