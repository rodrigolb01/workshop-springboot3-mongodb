package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		repo.saveAll(Arrays.asList(maria, alex, bob));

		Post p1 = new Post(null, "Visiting Disney", "Just came with my girlfriend :)", sdf.parse("18/02/2020"), new AuthorDTO(alex));

		repo1.saveAll(Arrays.asList(p1));
		
		alex.getPosts().addAll(Arrays.asList(p1));
		repo.save(alex);
	}

}
