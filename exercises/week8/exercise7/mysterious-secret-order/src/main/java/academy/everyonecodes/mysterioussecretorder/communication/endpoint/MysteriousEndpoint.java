package academy.everyonecodes.mysterioussecretorder.communication.endpoint;

import academy.everyonecodes.mysterioussecretorder.logic.MysteriousService;
import academy.everyonecodes.mysterioussecretorder.persistence.domain.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MysteriousEndpoint {
    private final MysteriousService mysteriousService;
    private final String message;

    public MysteriousEndpoint(MysteriousService mysteriousService,
                              @Value("${mysterious.message}") String message) {
        this.mysteriousService = mysteriousService;
        this.message = message;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    String getMessage() {
        return message;
    }

    @PostMapping("/members")
    @Secured("ROLE_MASTER")
    Member post(@RequestBody Member member) {
        return mysteriousService.save(member);
    }

    @GetMapping("/members")
    @Secured("ROLE_MASTER")
    List<Member> findAll() {
        return mysteriousService.findAll();
    }

    @GetMapping("/members/apprentices")
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    List<Member> findAllApprentices() {
        return mysteriousService.findByApprentice();
    }
}
