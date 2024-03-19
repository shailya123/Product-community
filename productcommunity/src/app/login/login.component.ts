import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../Class/user';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User;
  constructor(private loginApi: RegistrationserviceService, private formBuilder: FormBuilder, private route: Router) { }

  ngOnInit(): void {
  }
  loginUser() {
    this.loginApi.loginUserFromRemote(this.user).subscribe({
      next: (res) => {
        let data = res;
        alert("Welcome " + data.firstName);
        let name = data.firstName;
        this.route.navigate(['/welcome']);
        this.loginApi.setName(name);
      },
      error: () => {
        alert("Bad Credentials,try again");
      }
    })
  }
}
