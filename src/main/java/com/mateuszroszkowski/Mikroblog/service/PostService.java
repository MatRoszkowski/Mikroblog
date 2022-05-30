package com.mateuszroszkowski.Mikroblog.service;

import com.mateuszroszkowski.Mikroblog.dto.PostDto;
import com.mateuszroszkowski.Mikroblog.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getUserPosts(String username);

    PostDto addPost(PostDto postDto);

    void deletePost(PostDto postDto);
}
