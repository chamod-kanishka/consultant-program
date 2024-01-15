package com.example.demo.payments.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.candidates.model.Candidates;
import com.example.demo.candidates.service.CandidateService;
import com.example.demo.payments.model.Payments;
import com.example.demo.payments.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CandidateService candidateService;
    
   

    public Payments savePayments(Payments payments, Long candidateId) {
        Candidates candidate = candidateService.getCandidateById(candidateId);

        if (candidate != null) {
            payments.setCandidate(candidate);
            candidateService.UpdateState(candidateId);
            return paymentRepository.save(payments);
        } else {
            return null;
        }
    }

	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
        return paymentRepository.findAll();
	}
	
}
