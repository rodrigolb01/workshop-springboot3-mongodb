package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);

		return user.orElseThrow(() -> new ResourceNotFoundException("Post não encontrado. Id " + id));
	}
}
