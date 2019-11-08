package com.example.server.controller;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.server.model.User;

@RestController
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	@PostMapping("/users")
	public Integer addUser(@Valid @RequestBody User user) {
		return userRepository.save(user).getId();
	}
	
	@GetMapping("/users/{id}")
    public User getNoteById(@PathVariable(value = "id") int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
	
	@PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setId(userDetails.getId());
//        user.setContent(userDetails.getContent());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }
}
