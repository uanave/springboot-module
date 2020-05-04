package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.domain.Ride;
import academy.everyonecodes.rides.repository.DriverRepository;
import academy.everyonecodes.rides.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriversService {
    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;

    public DriversService(DriverRepository driverRepository, RideRepository rideRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    public Driver save(Driver driver) {
        driverRepository.save(driver);
        return driver;
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Ride saveRideAddToDriver(Long id, Ride ride) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isPresent()) {
            oDriver.get().getRides().add(ride);
            driverRepository.save(oDriver.get());
            rideRepository.save(ride);
        }
        return ride;
    }
}
