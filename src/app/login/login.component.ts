// login.component.ts
import { Component } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  credentials = { username: '', password: '' };

  constructor(private loginService: LoginService) {}

  login() {
    this.loginService.login(this.credentials).subscribe(
      (response) => {
        // Handle successful login
        console.log('Login successful', response);
        // Store the token (you can use localStorage or a cookie)
      },
      (error) => {
        // Handle login failure
        console.error('Login failed', error);
      }
    );
  }
}
