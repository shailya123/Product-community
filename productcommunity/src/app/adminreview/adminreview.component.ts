import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-adminreview',
  templateUrl: './adminreview.component.html',
  styleUrls: ['./adminreview.component.css']
})
export class AdminreviewComponent implements OnInit {
public reviewList:any;
flag!:any;
  constructor(private api:RegistrationserviceService,private router:Router) { }

  ngOnInit(): void {
    this.api.getAllReviewFromRemote().subscribe((res) => {
     this.reviewList=res;
    })
  }
  logout() {
    if (confirm("Are you sure you want to logout?") == true)
      this.router.navigate(['/homepage']);
  }
  approve(data:any)
  {
    this.flag=1;
 this.api.updateReviewStatusOnRemote(data.serialNo).subscribe({next:(res)=>{
  alert("You approved the review");
  location.reload();
 },
error:()=>{
  alert("Error in approving the review");
  console.log(data.serialNo);
}})
  }
  reject(data:any)
  {
    this.flag=1;
 this.api.rejectReviewStatusOnRemote(data.serialNo).subscribe({next:(res)=>{
  alert("You rejected the review");
  location.reload();
 },
error:()=>{
  alert("Error in rejecting the review");
  console.log(data.serialNo);
}})
  }
}
