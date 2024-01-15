import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './employee/add-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee.component';

import { PaymentComponent } from './payment/payment.component';
import { AddPaymentComponent } from './payment/add-payment.component';
import { UpdatePaymentComponent } from './payment/update-payment.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'candidate', component: EmployeeComponent },
  { path: 'add-candidate', component: AddEmployeeComponent },
  { path: 'update-candidate/:id', component: UpdateEmployeeComponent },
  { path: '', redirectTo: '/candidate', pathMatch: 'full'},
  { path: 'payments', component: PaymentComponent },
  { path: 'add-payment/:id', component: AddPaymentComponent },
  { path: 'update-payment/:id', component: UpdatePaymentComponent },
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: '/payments', pathMatch: 'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }