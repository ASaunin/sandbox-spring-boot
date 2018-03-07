package com.asaunin.repository;

import com.asaunin.domain.Person;
import com.asaunin.domain.Post;
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
