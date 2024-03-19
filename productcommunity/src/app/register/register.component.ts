import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../Class/user';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user = new User;
  constructor(private registerApi: RegistrationserviceService, private route: Router) { }

  ngOnInit(): void {
  }
  registerUser() {
    this.registerApi.registerUserFromRemote(this.user).subscribe({
      next: (res) => {
        alert("Registered successfully");
        console.log(this.user);
        this.route.navigate(['/loginuser']);
      },
      error: () => {
        alert("Something went wrong,try again");
      }
    })
  }
}
