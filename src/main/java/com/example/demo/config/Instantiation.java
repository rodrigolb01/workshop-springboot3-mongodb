package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	PostRepository repo1;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		repo.deleteAll();
		repo1.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		repo.saveAll(Arrays.asList(maria, alex, bob));

		Post p1 = new Post(null, "Visiting Disney", "Just came with my girlfriend", sdf.parse("18/02/2020"), new AuthorDTO(alex));
		Post p2 = new Post(null, "Trip to San Francisco", "Going to visit family", sdf.parse("11/07/2021"), new AuthorDTO(alex));
		repo1.saveAll(Arrays.asList(p1, p2));
		
		alex.getPosts().addAll(Arrays.asList(p1, p2));
		repo.save(alex);
		
		Comment c1 = new Comment("Enjoy the trip!", sdf.parse("11/07/2021"), new AuthorDTO(maria));
		Comment c2 = new Comment("I'm going with my wife", sdf.parse("18/02/2020"), new AuthorDTO(bob));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		repo1.save(p1);
	}

}
