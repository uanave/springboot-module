package academy.everyonecodes.mysterioussecretorderstarter.persistence.repository;

import academy.everyonecodes.mysterioussecretorderstarter.persistence.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

    boolean existsByUsername(String username);

}

