package com.rajiv.pt.projecttrackerapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.pt.projecttrackerapi.model.User;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/all")
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	@PostMapping("/user")
//	public User createUser(@Valid @RequestBody User user) {
	public User createUser() {
		User tempUser = new User();
		tempUser.setUsername("rajivsahu10");
		tempUser.setLastName("sahu");
		tempUser.setFirstName("rajiv");
		User createdUser = userRepository.save(tempUser);
		return createdUser;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value="id") Long userId) {
		User user = userRepository.findById(userId)
								  .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return user;
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value="id") Long userId, @Valid @RequestBody User user) {
		User foundUser = userRepository.findById(userId)
				  .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		
		foundUser.setFirstName(user.getFirstName());
		foundUser.setLastName(user.getLastName());
		User updatedUser = userRepository.save(foundUser);
		return updatedUser;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id")Long userId) {
		User user = userRepository.findById(userId)
				  .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}
	
}
