package com.example.demo.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payments.model.Payments;
import com.example.demo.payments.service.PaymentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/payments")
public class PaymentsController {
	
	@Autowired
	private PaymentService paymentsService;

	
	@PostMapping("/create/{id}")
	public ResponseEntity<Payments> createPayment(@RequestBody Payments payments, @PathVariable Long id) {
	    Payments createdPayment = paymentsService.savePayments(payments, id);
	    if (createdPayment != null) {
	        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping
	public List<Payments> getAllPayments() {
		return paymentsService.getAllPayments();
	}
}
