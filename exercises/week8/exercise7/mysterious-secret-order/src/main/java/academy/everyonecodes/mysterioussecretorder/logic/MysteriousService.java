package academy.everyonecodes.mysterioussecretorder.logic;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.Member;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysteriousService {
    private final MemberRepository memberRepository;
    private final String role;
    private final PasswordEncoder passwordEncoder;

    public MysteriousService(MemberRepository memberRepository,
                             @Value("${mysterious.role}")String role,
                             PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.role = role;
        this.passwordEncoder = passwordEncoder;
    }

    public Member save(Member member) {
        String password = member.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        member.setPassword(passwordEncoded);
        memberRepository.save(member);
        return member;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<Member> findByApprentice() {
        return memberRepository.findAllByAuthoritiesContaining(role);
    }
}
