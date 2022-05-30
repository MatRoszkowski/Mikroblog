package com.mateuszroszkowski.Mikroblog.dto;

import com.mateuszroszkowski.Mikroblog.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PostDto {
    private Long id;
    private LocalDateTime timestamp;
    private String content;
    private User author;
    private List<HashtagDto> hashtags = new ArrayList<>();
}
