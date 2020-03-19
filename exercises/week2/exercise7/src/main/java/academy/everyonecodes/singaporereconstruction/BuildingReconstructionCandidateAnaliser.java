package academy.everyonecodes.singaporereconstruction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnaliser {
    private List<Building> buildings;

    public BuildingReconstructionCandidateAnaliser(List<Building> buildings) {
        this.buildings = buildings;
    }

    void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates() {
        return buildings.stream()
                .filter(building -> (ChronoUnit.YEARS.between(building.getBuilt(), LocalDate.now(ZoneId.of("Singapore"))) > 20) && !building.isHistoric())
                .collect(Collectors.toList());
    }
}
