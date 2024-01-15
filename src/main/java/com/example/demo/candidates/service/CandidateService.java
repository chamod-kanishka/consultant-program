package com.example.demo.candidates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.candidates.model.Candidates;
import com.example.demo.candidates.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
    private CandidateRepository candidateRepository;

	public Candidates SaveCandidate(Candidates candidate) {
		// TODO Auto-generated method stub
		return candidateRepository.save(candidate);
	}

	public List<Candidates> getAllCandidates() {
		// TODO Auto-generated method stub
        return candidateRepository.findAll();
	}

	public Candidates getCandidateById(Long id) {
        Optional<Candidates> optionalCandidate = candidateRepository.findById(id);
        return optionalCandidate.orElse(null);
    }

	public void UpdateState(Long id) {
		Optional<Candidates> candidateOptional = candidateRepository.findById(id);

		candidateOptional.ifPresent(candidate -> {
		    candidate.setState(true);
		    // Perform other operations with the candidate
		});

		// Or handle the case when the candidate is not found
		if (!candidateOptional.isPresent()) {
		    // Handle the case when the candidate is not found
		}
		

	}
	
	
}
