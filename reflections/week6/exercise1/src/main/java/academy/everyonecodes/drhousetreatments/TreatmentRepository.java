package academy.everyonecodes.drhousetreatments;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TreatmentRepository extends MongoRepository<Treatment, String> {
    List<Treatment> findAllByUuid(String uuid);
}
