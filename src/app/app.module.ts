import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {HttpClientModule} from "@angular/common/http";

import { EmployeeComponent } from './employee/employee.component';
import {AddEmployeeComponent} from './employee/add-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee.component';
import {EmployeeService} from './employee/employee.service';

import { PaymentComponent } from './payment/payment.component';
import { AddPaymentComponent } from './payment/add-payment.component';
import { UpdatePaymentComponent } from './payment/update-payment.component';
import {PaymentService} from './payment/payment.service';
import { NavigationComponent } from './navigation/navigation.component';

import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';


@NgModule({
  declarations: [
    NavigationComponent,
    LoginComponent,
    AppComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    PaymentComponent,
    AddPaymentComponent,
    UpdatePaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EmployeeService,PaymentService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
