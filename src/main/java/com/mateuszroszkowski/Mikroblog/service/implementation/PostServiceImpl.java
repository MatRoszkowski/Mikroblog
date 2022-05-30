package com.mateuszroszkowski.Mikroblog.service.implementation;

import com.mateuszroszkowski.Mikroblog.dto.HashtagDto;
import com.mateuszroszkowski.Mikroblog.dto.PostDto;
import com.mateuszroszkowski.Mikroblog.mapper.PostMapper;
import com.mateuszroszkowski.Mikroblog.model.Hashtag;
import com.mateuszroszkowski.Mikroblog.model.Post;
import com.mateuszroszkowski.Mikroblog.model.User;
import com.mateuszroszkowski.Mikroblog.repository.HashtagRepository;
import com.mateuszroszkowski.Mikroblog.repository.PostRepository;
import com.mateuszroszkowski.Mikroblog.repository.UserRepository;
import com.mateuszroszkowski.Mikroblog.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HashtagRepository hashtagRepository;
    private final PostMapper postMapper;

    @Override
    public List<Post> getUserPosts(String username) {
        return null;
    }

    @Override
    public PostDto addPost(PostDto postDto) {
        User author = userRepository.findByUsername(postDto.getAuthor().getUsername()).get();

        Set<Hashtag> hashtags = getHashtags(postDto);
        Post post = Post.builder()
                .author(author)
                .content(postDto.getContent())
                .timestamp(LocalDateTime.now())
                .hashtags(hashtags)
                .build();

        PostDto createdPost = postMapper.map(postRepository.save(post));
        log.info("Post successfully created");
        return createdPost;
    }

    private Set<Hashtag> getHashtags(PostDto postDto) {
        Set<HashtagDto> hashtagDtoSet = postDto.getHashtags().stream()
                .map(hashtagDto -> new HashtagDto(hashtagDto.getId(), hashtagDto.getName().toLowerCase())).collect(Collectors.toSet());

        Set<Hashtag> hashtags = new HashSet<>();
        hashtagDtoSet.stream().forEach(hashtagDto -> {
                    Optional<Hashtag> hashtag = hashtagRepository.findByName(hashtagDto.getName());
                    if (hashtag.isPresent()) {
                        hashtags.add(hashtag.get());
                    } else {
                        hashtags.add(hashtagRepository.save(Hashtag.builder().name(hashtagDto.getName()).build()));
                    }
                }
        );
        return hashtags;
    }

    @Override
    public void deletePost(PostDto postDto) {

    }
}
