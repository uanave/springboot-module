package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.domain.Ride;
import academy.everyonecodes.rides.repository.DriverRepository;
import academy.everyonecodes.rides.repository.RideRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DriversServiceTest {

    @Autowired
    DriversService driversService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    RideRepository rideRepository;
    Driver driver = new Driver("tom", "combi");
    Long id = 1L;
    Ride ride = new Ride("tom", "16.8 km", 18.9);


    @Test
    void save() {
        driversService.save(driver);
        verify(driverRepository).save(driver);
    }

    @Test
    void findAll() {
        driversService.findAll();
        verify(driverRepository).findAll();
    }

    @Test
    void saveRideAddToDriver() {
        when(rideRepository.save(ride)).thenReturn(ride);
        when(driverRepository.findById(id)).thenReturn(Optional.of(driver));
        assertTrue(driver.getRides().isEmpty());

        driversService.saveRideAddToDriver(id, ride);
        assertEquals(1, driver.getRides().size());
        verify(driverRepository).save(driver);
        verify(rideRepository).save(ride);
    }

    @Test
    void doesNotFindDriver() {
        when(driverRepository.findById(id)).thenReturn(Optional.empty());
        driversService.saveRideAddToDriver(id, ride);
        verify(driverRepository).findById(id);
        verifyNoMoreInteractions(driverRepository);
        verifyNoInteractions(rideRepository);
    }
}