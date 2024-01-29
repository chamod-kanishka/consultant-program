import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Consultant Service';
  // roles : string;

  constructor(private router: Router) {}

  ngOnInit(): void {
    // this.roles=this.decodeToken(localStorage.getItem('token'))
    // console.log(this.roles);
  }


  isLoginPage(): boolean {
    // Check if the current route is the login page
    return this.router.url === '/login';
  }

  isRegisterPage(): boolean {
    // Check if the current route is the login page
    return this.router.url === '/register';
  }

  isProfilePage(): boolean {
    // Check if the current route is the profile page
    let roles;
    
    if(localStorage.getItem('token')==null){
      roles = roles === null ? "user" : roles;
    }else{
      roles=this.decodeToken(localStorage.getItem('token'));
    }  
    
    console.log(roles);
    return this.router.url === '/profile' || roles === "user";
  
    
  }

  decodeToken(token: string): any {
    try {
      // Decode the token
      interface DecodedTokenPayload {
        roles: string;
        sub: string;
        iat: number;
        exp: number;
      }

      const decodedToken = jwtDecode(token) as DecodedTokenPayload;

      // Access the roles property from the decoded token
      const roles = decodedToken.roles;

      // You can also access other properties like sub, iat, exp, etc.
      const sub = decodedToken.sub;
      const iat = decodedToken.iat;
      const exp = decodedToken.exp;

      // Log or return the roles value
      console.log('Roles:', roles);
  
      return roles;
    } catch (error) {
      console.error('Error decoding token:', error);
      return null;
    }
  }
}
