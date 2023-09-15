package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.ResourceNotFoundException;
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
		
		return user.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado. Id " + id));
	}
	
	public User insert(User user)
	{
		return repo.insert(user);
	}
	
	public User fromDTO(UserDTO dto)
	{
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
}
