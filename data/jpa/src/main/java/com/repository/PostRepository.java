package com.repository;

import com.model.Person;
import com.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findById(Long id);

    Collection<Post> findByAuthorOrderByPostedOnDesc(Person author);

    Collection<Post> findAllByOrderByPostedOnDesc();
}
