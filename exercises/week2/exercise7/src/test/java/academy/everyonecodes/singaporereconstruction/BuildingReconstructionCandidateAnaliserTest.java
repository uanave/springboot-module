package academy.everyonecodes.singaporereconstruction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BuildingReconstructionCandidateAnaliserTest {

    @Autowired
    BuildingReconstructionCandidateAnaliser analiser;

    @Test
    void findCandidates() {
        List<Building> result = analiser.findCandidates();

        List<Building> expected = List.of(new Building("Eliptic Appartments", LocalDate.of(1993, 5, 3), false),
                new Building("New World Amusement Park", LocalDate.of(1991, 8, 1), false));
        assertEquals(expected, result);
    }
}