import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';  // Import Router
import { HttpClient } from '@angular/common/http';

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"],
})
export class ProfileComponent {

  user = {
    name: "",
    email: "",
    roles: "",
  };

  // Inject Router in the constructor
  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      let candidateName = params['name'] || "";
      console.log(candidateName);
      this.getUser(candidateName);
    });    
  }

  getUser(name: string) {
    const params = { name: name };
  
    this.http.get("http://localhost:8080/auth/getUser", { params: params }).subscribe(
      (response) => {
        this.user = response as { name: string; email: string; roles: string; };
        console.log("User retrieved successfully", response);
      },
      (error) => {
        console.error("Error retrieving user", error);
      }
    );
  }

  logout() {
    console.log('User logged out');
    this.router.navigate(['/login']);
  }
}
