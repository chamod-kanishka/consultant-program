package com.example.demo.candidates.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.candidates.model.Candidates;

public interface CandidateRepository extends JpaRepository<Candidates, Long>{
	
	
}
