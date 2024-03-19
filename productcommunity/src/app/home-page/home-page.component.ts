import { Component, OnInit } from '@angular/core';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  length1: any;
  length2: any;
  length3: any;

  constructor(private api: RegistrationserviceService) { }

  ngOnInit(): void {
    this.api.getAllProductFromRemote().subscribe((res) => {
      this.length1 = res.length;
    })
    this.api.getAllUserFromRemote().subscribe((data) => {
      this.length2 = data.length;
    })
    this.api.getAllReviewFromRemote().subscribe((res) => {
      this.length3 = res.length;
    })
  }
}
