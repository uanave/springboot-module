package academy.everyonecodes.startsecretorder.persistence.repository;

import academy.everyonecodes.startsecretorder.persistence.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

    boolean existsByUsername(String username);

}

