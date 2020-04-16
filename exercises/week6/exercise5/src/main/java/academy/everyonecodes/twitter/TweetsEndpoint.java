package academy.everyonecodes.twitter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {
    private final TwitterService twitterService;

    public TweetsEndpoint(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping
    List<Tweet> getAllOrdered() {
        return twitterService.getAllOrdered();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getByUser(@PathVariable String user) {
        return twitterService.getTweetsByUser(user);
    }

    @PostMapping
    Tweet postOne(@RequestBody Tweet tweet) {
        twitterService.postOne(tweet);
        return tweet;
    }

    @PutMapping("/{id}/likes")
    void addLike(@PathVariable String id) {
        twitterService.addLike(id);
    }

    @PutMapping("/{id}/comments")
    void addComment(@PathVariable String id, @RequestBody String comment) {
        twitterService.addComment(id, comment);
    }
}
