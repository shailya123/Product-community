import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Review } from '../Class/review';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RegistrationserviceService } from '../services/registrationservice.service';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  data: any;
  id: any;
  public reviewList: any = [];

  constructor(private route: ActivatedRoute, private api: RegistrationserviceService, private dialog: MatDialog, private router: Router) { }

  ngOnInit(): void {
    this.id = this.api.getId();
    console.log(this.id);
    this.api.getReviewOnProductFromRemote(this.id).subscribe({
      next: (res) => {
        console.log(res);
        this.reviewList = res;
      }
    })
  }
  openDialog() {
    this.dialog.open(DialogComponent, {
      width: '40%'
    });
  }
  logout() {
    if (confirm("Are you sure you want to logout?") == true)
      this.router.navigate(['/homepage']);
  }
}


