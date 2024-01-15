import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Payment } from '../models/payment.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PaymentService {

  constructor(private http:HttpClient) {}

  private paymentUrl = 'http://localhost:8080/api/payments';

  public getPayments() {
    return this.http.get<Payment[]>(this.paymentUrl);
  }

  public getPayment(id) {
    return this.http.get(this.paymentUrl + "/get-payment/"+ id);
  }

  public deletePayment(payment) {
    return this.http.delete(this.paymentUrl + "/delete-payment/"+ payment.id);
  }

  public createPayment(payment,candidateId) {
    return this.http.post<Payment>(this.paymentUrl+'/create/'+candidateId, payment,httpOptions);
  }

  public updatePayment(payment) {
    return this.http.put<Payment>(this.paymentUrl + "/update-employee", payment);
  }

}
