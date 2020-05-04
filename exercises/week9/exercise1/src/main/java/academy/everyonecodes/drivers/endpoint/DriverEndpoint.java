package academy.everyonecodes.drivers.endpoint;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.logic.DriverService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {
    private final DriverService driverService;

    public DriverEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    Driver post(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    Driver getDriverById(@PathVariable String id) {
        return driverService.findById(id).orElse(null);
    }

    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    Driver markAsAvailable(@PathVariable String id) {
        return driverService.setAsAvailable(id).orElse(null);
    }

    @PutMapping("/{id}/unavailable")
    @Secured("ROLE_DRIVER")
    Driver markAsUnavailable(@PathVariable String id) {
        return driverService.setAsUnavailable(id).orElse(null);
    }
}
