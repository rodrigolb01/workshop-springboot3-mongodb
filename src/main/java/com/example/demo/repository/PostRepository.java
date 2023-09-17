package com.example.demo.repository;

import com.example.demo.domain.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
