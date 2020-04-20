package academy.everyonecodes.gatsby.persistence.repository;

import academy.everyonecodes.gatsby.persistence.domain.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
