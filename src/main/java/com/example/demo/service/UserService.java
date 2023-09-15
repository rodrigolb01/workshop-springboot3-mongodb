package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id)
	{
        Optional<User> user = repo.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado. Id " + id));
	}
}
