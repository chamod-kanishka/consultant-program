package com.example.demo.authentication.controller;

import com.example.demo.authentication.entity.AuthRequest; 
import com.example.demo.authentication.entity.UserInfo; 
import com.example.demo.authentication.service.JwtService; 
import com.example.demo.authentication.service.UserInfoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.web.bind.annotation.*; 

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth") 
public class UserController { 

	@Autowired
	private UserInfoService service; 

	@Autowired
	private JwtService jwtService; 

	@Autowired
	private AuthenticationManager authenticationManager; 

	@GetMapping("/welcome") 
	public String welcome() { 
		return "hi, Welcome this endpoint is not secure"; 
	} 

	@PostMapping("/addNewUser") 
	public String addNewUser(@RequestBody UserInfo userInfo) { 
		return service.addUser(userInfo); 
	} 
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUserByLogin(@RequestParam String name) {
	    try {
	        Optional<UserInfo> userInfo = service.loadUserByname(name);
	        return userInfo.map(user -> ResponseEntity.ok().body(user))
	                .orElse(ResponseEntity.notFound().build());
	    } catch (Exception e) {
	        // Log the exception for debugging purposes
	        e.printStackTrace();
	        
	        // Return a generic error response
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("An error occurred while processing the request.");
	    }
	}


	@GetMapping("/user/userProfile") 
	@PreAuthorize("hasAuthority('user')") 
	public String userProfile() { 
		return "Welcome to User Profile"; 
	} 

	@GetMapping("/admin/adminProfile") 
	@PreAuthorize("hasAuthority('admin')") 
	public String adminProfile() { 
		return "Welcome to Admin Profile"; 
	} 

	@PostMapping("/generateToken") 
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
		String name = authRequest.getUsername();
		String roles = null;
		System.out.println(name);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
		if (authentication.isAuthenticated()) { 
			try {
				Optional<UserInfo> userInfo = service.loadUserByname(name);
				roles = userInfo.get().getRoles();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return jwtService.generateToken(name,roles); 
		} else { 
			throw new UsernameNotFoundException("invalid user request !"); 
		} 
	} 
	
	

} 
