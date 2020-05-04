package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.repository.DriverRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DriverServiceTest {

    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${driver.authority}")
    String authority;

    String id = "test";

    Driver driver = new Driver("test", "test", "test");


    @Test
    void saveNonExistingDriver() {
        when(driverRepository.findOneByUsername(driver.getUsername()))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(driver.getPassword()))
                .thenReturn("encrypted");

        assertTrue(driver.getAuthorities().isEmpty());

        driverService.save(driver);

        assertTrue(driver.getAuthorities().contains(authority));
        assertEquals(1, driver.getAuthorities().size());
        Driver expected = new Driver("test", "encrypted", "test", Set.of(authority), false);


        verify(driverRepository).findOneByUsername(driver.getUsername());


        verify(driverRepository).save(expected);
    }

    @Test
    void existingDriver() {
        Driver expected = new Driver("test", "encrypted", "test", Set.of(authority), false);

        when(driverRepository.findOneByUsername(driver.getUsername()))
                .thenReturn(Optional.of(expected));

        driverService.save(driver);

        verify(driverRepository).findOneByUsername(driver.getUsername());
        verifyNoInteractions(passwordEncoder);
        verifyNoMoreInteractions(driverRepository);

    }

    @Test
    void findById() {
        driverService.findById(id);
        verify(driverRepository).findById(id);
    }

//    @Test
//    void setAsAvailableFindsDriver() {
//        Optional<Driver> oExpected = Optional.of(driver);
//        when(driverRepository.findById(id)).thenReturn(oExpected);
//
//        Optional<Driver> oResult = driverService.setAsAvailable(id);
//        oExpected.get().setAvailable(true);
//        assertEquals(oExpected, oResult);
//
//        verify(driverRepository).findById(id);
//        verify(driverRepository).save(oExpected.get());
//    }
//
//    @Test
//    void setAsAvailableDoesNotFindDriver() {
//        Optional<Driver> oExpected = Optional.empty();
//        when(driverRepository.findById(id)).thenReturn(oExpected);
//
//        Optional<Driver> oResult = driverService.setAsAvailable(id);
//        assertEquals(oExpected, oResult);
//
//        verify(driverRepository).findById(id);
//    }
//    @Test
//    void setAsUnavailableFindsDriver() {
//        Optional<Driver> oExpected = Optional.of(driver);
//        when(driverRepository.findById(id)).thenReturn(oExpected);
//
//        Optional<Driver> oResult = driverService.setAsUnavailable(id);
//        oExpected.get().setAvailable(true);
//        assertEquals(oExpected, oResult);
//
//        verify(driverRepository).findById(id);
//        verify(driverRepository).save(oExpected.get());
//    }
//
//    @Test
//    void setAsUnavailableDoesNotFindDriver() {
//        Optional<Driver> oExpected = Optional.empty();
//        when(driverRepository.findById(id)).thenReturn(oExpected);
//
//        Optional<Driver> oResult = driverService.setAsUnavailable(id);
//        assertEquals(oExpected, oResult);
//
//        verify(driverRepository).findById(id);
//    }
}