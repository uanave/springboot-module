package academy.everyonecodes.thehotelroom.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {
    private final String welcomeToHotel;
    private final String welcomeToRoom;

    public HotelEndpoint(@Value("${welcome.hotel}") String welcomeToHotel,
                         @Value("${welcome.room}") String welcomeToRoom) {
        this.welcomeToHotel = welcomeToHotel;
        this.welcomeToRoom = welcomeToRoom;
    }

    @GetMapping
    String get() {
        return welcomeToHotel;
    }

    @GetMapping("/room")
    @Secured("ROLE_CUSTOMER")
    String getRoom() {
        return welcomeToRoom;
    }
}
