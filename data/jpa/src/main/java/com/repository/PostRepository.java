package com.repository;

import com.model.Person;
import com.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PostRepository extends CrudRepository<Post, Long> {

    Post findById(Long id);

    Collection<Post> findByAuthorOrderByPostedOnDesc(Person author);

    Collection<Post> findAllByOrderByPostedOnDesc();
}
