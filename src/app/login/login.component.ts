// login.component.ts
import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  credentials = { username: '', password: '' };

  constructor(private loginService: LoginService,public router: Router) {this.router=router}

  ngOnInit() {
    localStorage.clear(); 
   }

  login() {
    const options = { responseType: 'text' as 'json' }; // Explicitly set the response type to 'text'
  
    this.loginService.login(this.credentials, options).subscribe(
      (response) => {
        // Assuming the response is the JWT token
        const newToken = response;
        // Clear the entire localStorage
        localStorage.clear();

        // Set the new token
        localStorage.setItem('token', newToken);
  
        console.log('Login successful', response);
        this.router.navigate(['/profile'], { queryParams: { name: this.credentials.username } });      },
      (error) => {
        console.error('Login failed', error);
      }
    );
  }
  
  handleRegisterClick(): void {
    this.router.navigate(['/register']);
  }
  
}
