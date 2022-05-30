package com.mateuszroszkowski.Mikroblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HashtagDto {
    private Long id;
    private String name;
}
