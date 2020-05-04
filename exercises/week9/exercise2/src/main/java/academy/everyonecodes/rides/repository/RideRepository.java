package academy.everyonecodes.rides.repository;

import academy.everyonecodes.rides.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
