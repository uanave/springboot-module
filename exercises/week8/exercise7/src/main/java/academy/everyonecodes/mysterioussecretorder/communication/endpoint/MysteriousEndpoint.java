package academy.everyonecodes.mysterioussecretorder.communication.endpoint;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.Member;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MysteriousEndpoint {
    private final MemberRepository memberRepository;
    private final String message;
    private final PasswordEncoder passwordEncoder;

    public MysteriousEndpoint(MemberRepository memberRepository, @Value("${mysterious.message}") String message, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.message = message;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    String getMessage()  {
        return message;
    }

    @PostMapping("/members")
    @Secured("ROLE_MASTER")
    Member post(@RequestBody Member member) {
        String password = member.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        member.setPassword(passwordEncoded);
        memberRepository.save(member);
        return member;
    }

    @GetMapping("/members")
    @Secured("ROLE_MASTER")
    List<Member> findAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/apprentices")
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    List<Member> findAllApprentices() {
        return memberRepository.findAllByAuthoritiesContaining("ROLE_APPRENTICE");
    }

}
