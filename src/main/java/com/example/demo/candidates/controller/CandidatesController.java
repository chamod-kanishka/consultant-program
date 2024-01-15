package com.example.demo.candidates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.candidates.model.Candidates;
import com.example.demo.candidates.service.CandidateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping
	public Candidates createCandidate(@RequestBody Candidates candidate) {
		return candidateService.SaveCandidate(candidate);
		
	}
	
	@GetMapping
	public List<Candidates> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	@GetMapping("/candidates/{id}")
	public ResponseEntity<Candidates> getCandidateById(@PathVariable Long id) {
	    Candidates candidate = candidateService.getCandidateById(id);

	    if (candidate != null) {
	        return new ResponseEntity<>(candidate, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	

}
