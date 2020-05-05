package academy.everyonecodes.validation.endpoint;

import academy.everyonecodes.validation.domain.Artwork;
import academy.everyonecodes.validation.domain.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ArtEndpoint.class)
class ArtEndpointTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenInput1IsInvalid_thenReturnsStatus400() throws Exception {
        Artwork artwork = new Artwork("", new Rating(3));
        String body = objectMapper.writeValueAsString(artwork);

        mvc.perform(post("/artworks")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenInput2IsInvalid_thenReturnsStatus400() throws Exception {
        Artwork artwork = new Artwork("Picasso", new Rating(10));
        String body = objectMapper.writeValueAsString(artwork);

        mvc.perform(post("/artworks")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenInputIsValid_thenReturnsStatus200() throws Exception {
        Artwork artwork = new Artwork("Picasso", new Rating(2));
        String body = objectMapper.writeValueAsString(artwork);

        mvc.perform(post("/artworks")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isOk());
    }
}