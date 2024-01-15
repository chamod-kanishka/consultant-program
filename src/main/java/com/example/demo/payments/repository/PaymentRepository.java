package com.example.demo.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.payments.model.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>{
	
}
