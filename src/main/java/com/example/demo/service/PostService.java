package com.example.demo.service;

import java.util.Date;
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
	
	public List<Post> findByTitle(String title)
	{
		return repo.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate)
	{
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
