package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public String getUser(User user) {
		String Email= user.getEmail();
		String Password= user.getPassword();
		
		User retreivedUser = userRepository.findByEmail(Email);
		
		if (retreivedUser == null) {
		    return "User not found";
		}
		
		if (Password.equals(retreivedUser.getPassword())) {
            return "Successfully enrolled";
        } else {
            return "Password does not match";
        }
	}
	
	

}
