package com.example.demo.payments.model;

import com.example.demo.candidates.model.Candidates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Payments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bank;
    private double amount;
    
    @OneToOne
    private Candidates candidate;

    public Payments() {
        // Default constructor
    }

    public Payments( String bank, double amount, Candidates candidate) {
        this.bank = bank;
        this.amount = amount;
        this.candidate = candidate;

    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidates getcandidate() {
		return candidate;
	}

	public void setCandidate(Candidates candidate) {
		this.candidate = candidate;
	}
   
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

