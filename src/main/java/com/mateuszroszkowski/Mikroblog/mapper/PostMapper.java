package com.mateuszroszkowski.Mikroblog.mapper;

import com.mateuszroszkowski.Mikroblog.dto.PostDto;
import com.mateuszroszkowski.Mikroblog.dto.UserDto;
import com.mateuszroszkowski.Mikroblog.model.Post;
import com.mateuszroszkowski.Mikroblog.model.User;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post map(PostDto postDto) {
        return Post.builder()
                .id(null)
                .author(null)
                .content(postDto.getContent())
                .timestamp(null)
                .hashtags(postDto.getHashtags())
                .build();
    }

    public PostDto map(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .content(post.getContent())
                .timestamp(post.getTimestamp())
                .hashtags(post.getHashtags())
                .build();
    }
}
