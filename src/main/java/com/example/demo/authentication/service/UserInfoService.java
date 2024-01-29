package com.example.demo.authentication.service;

import com.example.demo.authentication.entity.UserInfo; 
import com.example.demo.authentication.repository.UserInfoRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service; 

import java.util.Optional; 

@Service
public class UserInfoService implements UserDetailsService { 

	@Autowired
	private UserInfoRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		Optional<UserInfo> userDetail = repository.findByName(username); 

		// Converting userDetail to UserDetails 
		return userDetail.map(UserInfoDetails::new) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	} 

	public String addUser(UserInfo userInfo) { 
		userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
		repository.save(userInfo); 
		return "User Added Successfully"; 
	}

	public Optional<UserInfo> loadUserByname(String name) throws Exception {
		Optional<UserInfo> userDetail = repository.findByName(name.trim());

	    if (userDetail.isPresent()) {
	        return userDetail;
	    } else {
	        // UserNotFoundException is a custom exception that you need to define
	        throw new Exception("User not found with name: " + name);
	    }
	}


} 
