import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../Class/admin';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
admin=new Admin();
  constructor(private api:RegistrationserviceService,private router:Router) { }

  ngOnInit(): void {
  }
  loginAdmin()
  {
this.api.loginadminFromRemote(this.admin).subscribe({next:(res)=>{
  alert("welcome admin");
  this.router.navigate(['/adminreview']);

},
error:()=>
{
  alert("Invalid Credentials");
}
})
  }

}
