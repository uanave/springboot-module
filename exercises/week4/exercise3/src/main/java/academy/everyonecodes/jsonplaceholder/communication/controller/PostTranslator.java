package academy.everyonecodes.jsonplaceholder.communication.controller;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.communication.dto.PostDTO;
import org.springframework.stereotype.Controller;

@Controller
public class PostTranslator {

    public PostDTO translateToDTO(Post post) {
        return new PostDTO(
                post.getIdentifier(),
                post.getUser(),
                post.getTitle(),
                post.getContent()
        );
    }

    public Post translateToPost(PostDTO postDTO) {
        return new Post(
                postDTO.getTitle(),
                postDTO.getBody(),
                postDTO.getUserId(),
                postDTO.getId()
        );
    }
}
