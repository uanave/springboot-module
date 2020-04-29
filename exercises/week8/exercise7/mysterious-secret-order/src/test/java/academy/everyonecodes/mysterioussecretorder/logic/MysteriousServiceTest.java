package academy.everyonecodes.mysterioussecretorder.logic;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.Member;
import academy.everyonecodes.mysterioussecretorder.persistence.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MysteriousServiceTest {

    @Autowired
    MysteriousService mysteriousService;

    @MockBean
    MemberRepository memberRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${mysterious.role}")
    String role;

    Member member = new Member("master1", "secret", Set.of("ROLE_MASTER"));
    Member saved = new Member("master1", "123", Set.of("ROLE_MASTER"));


    @Test
    void save() {
        when(mysteriousService.save(member)).thenReturn(saved);

        when(passwordEncoder.encode(member.getPassword())).thenReturn("123");

        Member result = mysteriousService.save(member);

        assertEquals(saved, result);
        verify(memberRepository).save(member);

    }

    @Test
    void findAll() {
        when(mysteriousService.findAll()).thenReturn(List.of(member));

        List<Member> result = mysteriousService.findAll();

        List<Member> expected = List.of(member);

        assertEquals(expected, result);
        verify(memberRepository).findAll();
    }

    @Test
    void findByApprentice() {
        when(mysteriousService.findByApprentice()).thenReturn(List.of(member));

        List<Member> result = mysteriousService.findByApprentice();

        List<Member> expected = List.of(member);

        assertEquals(expected, result);
        verify(memberRepository).findAllByAuthoritiesContaining(role);
    }
}