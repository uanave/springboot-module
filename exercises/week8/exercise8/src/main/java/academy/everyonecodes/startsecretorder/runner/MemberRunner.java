package academy.everyonecodes.startsecretorder.runner;

import academy.everyonecodes.startsecretorder.persistence.domain.Member;
import academy.everyonecodes.startsecretorder.persistence.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class MemberRunner {

    @Bean
    ApplicationRunner prepareMember(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String username = "master";
            if (!memberRepository.existsByUsername(username)) {
                String password = passwordEncoder.encode("secret");
                Member member = new Member(username, password, Set.of("ROLE_MASTER"));
                memberRepository.save(member);
            }
        };
    }
}
