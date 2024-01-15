import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Payment } from '../models/payment.model';
import { PaymentService } from './payment.service';

@Component({
  selector: 'app-payment-update',
  templateUrl: './update-payment.component.html',
})
export class UpdatePaymentComponent implements OnInit {


  payment: any = {};

  constructor(private router: Router, private route: ActivatedRoute, private paymentService: PaymentService) {
    
  }

  ngOnInit() {
    this.paymentService.getPayment(this.route.snapshot.params['id'])
      .subscribe(data => {
        this.payment = data;
      });
  };

  updatePayment(): void {
    this.paymentService.updatePayment(this.payment)
      .subscribe(data => {
        alert("Employee updated successfully.");
        this.router.navigate(['/employees']);
      });

  };

}