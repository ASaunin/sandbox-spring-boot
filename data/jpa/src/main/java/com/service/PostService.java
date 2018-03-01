package com.service;

import com.model.Person;
import com.model.Post;
import com.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Collection<Post> findAllByAuthor(Person author) {
        return postRepository.findByAuthorOrderByPostedOnDesc(author);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(new Post());
    }

    public Collection<Post> findAll() {
        return postRepository.findAllByOrderByPostedOnDesc();
    }
}
