import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: FormGroup;
  role: string;
  name: string;

  constructor(private formBuilder: FormBuilder, private http: HttpClient, public router: Router) {
    this.router = router;
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      roles: ['',Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      // Extract user registration data from the form
      let userData = this.registerForm.value;
      this.name=userData.name;
      console.log(this.name);


      // Make a POST request to your backend API
      this.http.post('http://localhost:8080/auth/addNewUser', userData, { responseType: 'text' })
        .subscribe(
          (response) => {
            console.log('User registered successfully', response);
            let credentials = { username:userData.name , password: userData.password };
            this.http.post('http://localhost:8080/auth/generateToken', credentials, { responseType: 'text' })
            .subscribe(
              (response) => {
                console.log('User login', response);
                // Handle the JWT token here
                const token = response;
                // Remove current token
                localStorage.removeItem('token');

                // Save the token in local storage
                localStorage.setItem('token', token);
                console.log('Login successful', response);
                this.router.navigate(['/profile'], { queryParams: { name: this.name } });
              },
              (error) => {
                console.error('Error registering user', error);
              }
            )
            // Handle non-JSON response here
            //this.router.navigate(['/profile'], { queryParams: { name: this.name } });

          },
          (error) => {
            console.error('Error registering user', error);
          }
        );


    }
  }
}
