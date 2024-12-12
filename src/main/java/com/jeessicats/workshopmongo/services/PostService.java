package com.jeessicats.workshopmongo.services;

import com.jeessicats.workshopmongo.domain.Post;
import com.jeessicats.workshopmongo.repository.PostRepository;
import com.jeessicats.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }
}
