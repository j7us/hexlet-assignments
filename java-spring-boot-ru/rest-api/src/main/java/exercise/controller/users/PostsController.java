package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

import static exercise.Data.getPosts;

// BEGIN
@RestController
@RequestMapping("/api/users")
public class PostsController {

    List<Post> posts = getPosts();

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> getAll(@PathVariable int id) {
        return ResponseEntity.ok(posts.stream().filter(p -> p.getUserId() == id).toList());
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable int id, @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);

        return ResponseEntity.status(201).body(post);
    }
}
// END
