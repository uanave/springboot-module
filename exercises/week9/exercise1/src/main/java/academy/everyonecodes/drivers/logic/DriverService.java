package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final String authority;
    private final PasswordEncoder passwordEncoder;

    public DriverService(DriverRepository driverRepository, @Value("${driver.authority}") String authority, PasswordEncoder passwordEncoder) {
        this.driverRepository = driverRepository;
        this.authority = authority;
        this.passwordEncoder = passwordEncoder;
    }

    public Driver save(Driver driver) {
        Optional<Driver> oDriver = driverRepository.findOneByUsername(driver.getUsername());
        if (oDriver.isEmpty()) {
            String password = driver.getPassword();
            driver.setPassword(passwordEncoder.encode(password));
            driver.setAuthorities(Set.of(authority));
            driverRepository.save(driver);
            return driver;
        }
        return oDriver.get();
    }

    public Optional<Driver> findById(String id) {
        return driverRepository.findById(id);
    }

    public Optional<Driver> setAsAvailable(String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isPresent() && currentPrincipalName.equals(oDriver.get().getUsername())) {
            oDriver.get().setAvailable(true);
            driverRepository.save(oDriver.get());
            return oDriver;
        }
        return Optional.empty();
    }

    public Optional<Driver> setAsUnavailable(String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isPresent() && currentPrincipalName.equals(oDriver.get().getUsername())) {
            oDriver.get().setAvailable(false);
            driverRepository.save(oDriver.get());
            return oDriver;
        }
        return Optional.empty();
    }
}

