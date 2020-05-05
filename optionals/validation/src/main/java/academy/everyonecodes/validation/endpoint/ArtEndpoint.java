package academy.everyonecodes.validation.endpoint;

import academy.everyonecodes.validation.domain.Artwork;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/artworks")
public class ArtEndpoint {

    @PostMapping
    Artwork post(@RequestBody @Valid Artwork artwork) {
        return artwork;
    }
}
