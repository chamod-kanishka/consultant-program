import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Payment } from '../models/payment.model';
import { PaymentService } from './payment.service';

@Component({
  selector: 'app-payment-create',
  templateUrl: './add-payment.component.html'
})
export class AddPaymentComponent {

  payment: Payment = new Payment();
  employeeId: any;

  constructor(private router: Router, private paymentService: PaymentService,private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    // Fetch the employeeId from the route parameters
    this.route.params.subscribe((params) => {
      this.employeeId = params['id'];
      console.log('Employee ID:', this.employeeId);
    });
  }

  createPayment(): void {
    
    this.paymentService.createPayment(this.payment, this.employeeId)
        .subscribe( data => {
          alert("Payment created successfully.");
          this.router.navigate(['/payments']);
        });

  };

}