package academy.everyonecodes.rides.endpoint;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.logic.DriversService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@Secured("ROLE_ADMIN")
public class DriversEndpoint {

    private final DriversService driversService;

    public DriversEndpoint(DriversService driversService) {
        this.driversService = driversService;
    }

    @PostMapping
    Driver post(@RequestBody Driver driver) {
        return driversService.save(driver);
    }

    @GetMapping
    List<Driver> findAll() {
        return driversService.findAll();
    }
}
