import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, MaxLengthValidator } from '@angular/forms';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
  reviewForm!: FormGroup
  id!: any;
  constructor(private formBuilder: FormBuilder, private api: RegistrationserviceService) { }

  ngOnInit(): void {
    this.id = this.api.getId();
    this.reviewForm = this.formBuilder.group({
      id: [this.id, Validators.required],
      heading: ['', Validators.required],
      rating: ['', Validators.required],
      review: ['', Validators.required],
      status:['Sent For approval',Validators.required]
    })
  }

  addReview() {
    this.api.PostReviewToRemote(this.reviewForm.value).subscribe({
      next: (res) => {
        console.log(res);
        alert("Review added successfully")
      },
      error: () => {
        alert("Error in adding the review");
      }
    })
    console.log(this.reviewForm.value);
  }


}
