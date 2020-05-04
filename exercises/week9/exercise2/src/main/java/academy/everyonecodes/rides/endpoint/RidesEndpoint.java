package academy.everyonecodes.rides.endpoint;

import academy.everyonecodes.rides.domain.Ride;
import academy.everyonecodes.rides.logic.DriversService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class RidesEndpoint {
    private final DriversService driversService;

    public RidesEndpoint(DriversService driversService) {
        this.driversService = driversService;
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    Ride postOne(@PathVariable Long id, @RequestBody Ride ride) {
        return driversService.saveRideAddToDriver(id, ride);
    }
}
