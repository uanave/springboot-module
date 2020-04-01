package academy.everyonecodes.jsonplaceholder.logic;

import academy.everyonecodes.jsonplaceholder.communication.controller.PostTranslator;
import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.communication.dto.PostDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTranslatorTest {

    PostTranslator postTranslator = new PostTranslator();

    Post post = new Post("title", "content", 1, 2);

    PostDTO postDTO = new PostDTO(2, 1, "title", "content");

    @Test
    void translateToDTO() {
        PostDTO result = postTranslator.translateToDTO(post);

        assertEquals(postDTO, result);
    }

    @Test
    void translateToPost() {
        Post result = postTranslator.translateToPost(postDTO);

        assertEquals(post, result);
    }
}

