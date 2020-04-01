package academy.everyonecodes.jsonplaceholder.communication.endpoint;

import academy.everyonecodes.jsonplaceholder.domain.Post;
import academy.everyonecodes.jsonplaceholder.communication.client.JsonPlaceholderClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostEndpoint(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @GetMapping
    List<Post> getAll() {
        return jsonPlaceholderClient.getAll();
    }

    @GetMapping("/{id}")
    Post getOne(@PathVariable int id) {
        return jsonPlaceholderClient.getOne(id);
    }

    @PostMapping
    Post post(@RequestBody Post post) {
        return jsonPlaceholderClient.post(post);
    }

    @PutMapping("/{id}")
    Post put(@PathVariable int id, @RequestBody Post post) {
        return jsonPlaceholderClient.put(id, post);
    }

    @DeleteMapping
    void deleteAll() {
        jsonPlaceholderClient.delete();
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable int id) {
        jsonPlaceholderClient.delete(id);
    }
}

