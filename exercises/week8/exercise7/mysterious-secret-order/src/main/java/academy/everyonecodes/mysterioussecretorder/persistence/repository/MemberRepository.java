package academy.everyonecodes.mysterioussecretorder.persistence.repository;

import academy.everyonecodes.mysterioussecretorder.persistence.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    boolean existsByUsername(String username);

    Optional<Member> findOneByUsername(String username);

    List<Member> findAllByAuthoritiesContaining(String authority);
}

