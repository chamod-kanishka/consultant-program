import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Employee } from '../models/employee.model';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee-create',
  templateUrl: './add-employee.component.html'
})
export class AddEmployeeComponent {

  employee: Employee = new Employee();
  // state:boolean = false;
  constructor(private router: Router, private employeeService: EmployeeService) {

  }

  createEmployee() {

    this.employeeService.createEmployee(this.employee)
        .subscribe( data => {
          alert("Employee created successfully.");
          this.router.navigate(['/candidate']);
        });

  };

}