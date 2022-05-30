package com.mateuszroszkowski.Mikroblog.controller;

import com.mateuszroszkowski.Mikroblog.dto.PostDto;
import com.mateuszroszkowski.Mikroblog.model.Post;
import com.mateuszroszkowski.Mikroblog.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @Operation(summary = "Get user posts", description = "Returns a list of posts. If user does not exist" +
            " returns message informing about it.")
    @GetMapping("/{username}/")
    public List<Post> getUserLectures(@PathVariable String username) {
        return postService.getUserPosts(username);
    }

    @Operation(summary = "Create post", description = "Creates new post.")
    @PostMapping("/")
    public void addPost(PostDto postDto){
        postService.addPost(postDto);
    }

    @Operation(summary = "Delete post", description = "Delete post.")
    @DeleteMapping("/")
    public void deletePost(PostDto postDto){
        postService.deletePost(postDto);
    }
}
