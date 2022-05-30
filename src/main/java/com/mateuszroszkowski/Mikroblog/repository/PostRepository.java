package com.mateuszroszkowski.Mikroblog.repository;


import com.mateuszroszkowski.Mikroblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
