package com.Backspace.ComplaintManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backspace.ComplaintManagement.Entity.User;
import com.Backspace.ComplaintManagement.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User saveUser(@Valid @RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUsersById(@PathVariable long id)
	{
		return userService.getUserById(id);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable long id,@Valid @RequestBody User user)
	{
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable long id)
	{
		return userService.deleteUser(id);
	}
}
