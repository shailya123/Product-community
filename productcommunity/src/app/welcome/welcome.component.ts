import { JsonPipe } from '@angular/common';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../Class/product';
import { RegistrationserviceService } from '../services/registrationservice.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  searchText = this.fb.group({
    text: ['']
  })
  filterList = {
    brand: ['Nike', 'Adidas', 'Puma'],
    code: ['ADC14536258MP', 'ADC23627167MM', 'ADC23627167LB', 'ADC13242545LY', 'ADC76537883SB', 'NICJ0921092SG', 'NICJ0921092MB', 'NIDJ1829010MB', 'NICB7952103MP', 'PU847760SB', 'PU847760MB', 'PU847760LB', 'PU847828SW', 'PU847828XW', 'PU581371MP'],
    name: ['Adidas Men Purple Slim Fit Aeroready', 'Adidas Solid Freelift Tennis T-shirt', 'Adidas Designed2Move T', 'Adidas Printed Win 2.0 Tee', "Nike Men's T-Shirt", 'Nike Sportswear', "PUMA Graphic Men's T-Shirt", 'Nu-tility Relaxed T-shirt']
  }
  brand!: any;
  id!: any;
  name!: any;
  firstname!: any
  product = new Product();
  public productList: any;
  data: any;
  copyData: any;
  text!: any;
  searchData: any;
  filterData: any;
  array: any;
  length2: any;
  length1: any;
  length3: any;
  flag!: any;
  flag1: any;
  reviewId: any;
  product_id!: any;
  averageOfReview!: any;
  totalReview: any;
  isShowDiv = true;
  constructor(private route: Router, private activeRoute: ActivatedRoute, private api: RegistrationserviceService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.firstname = this.api.getName();
    this.product_id = this.api.getId();
    this.api.getAllProductFromRemote().subscribe(res => {
      this.productList = res;
      this.length2 = this.productList.length;
      this.length1 = this.productList.length;
      this.copyData = this.productList
      this.flag1 = 1;
    }
    )

  }
  logout() {
    if (confirm("Are you sure you want to logout?") == true)
      this.route.navigate(['/homepage']);
  }
  searchContent() {
    this.text = this.searchText.value.text;
    this.api.getSearchProductFromRemote(this.text).subscribe({
      next: (res) => {

        if (this.text == null || this.text == '') {
          this.productList = this.copyData;
          this.filterData = this.productList;
          this.length1 = this.copyData;
          this.flag1 = 1;
        }
        else
          this.productList = res;
        this.filterData = this.productList;
        this.length1 = this.productList.length;
        this.flag1 = 1;
      },
      error: () => {
        console.log("Error");
      }
    })
  }
  filterChange(appliedfilters: any) {
    this.productList = this.copyData;
    this.brand = (appliedfilters.appliedFilterValues.brand);
    this.id = (appliedfilters.appliedFilterValues.code);
    this.name = (appliedfilters.appliedFilterValues.name);
    this.flag = 1;
    this.length3 = this.length2;
    if (this.brand) {
      this.productList = this.productList.filter((item: { brand: any; }) => item.brand === this.brand);
      this.length3 = this.productList;
    }
    if (this.id) {
      this.productList = this.productList.filter((item: { id: any; }) => item.id === this.id)
      this.length3 = this.productList;
    }
    if (this.name) {
      this.productList = this.productList.filter((item: { name: any; }) => item.name === this.name);
      this.length3 = this.productList;
    }
  }
  goToReviewComponent(item: any) {
    this.route.navigate(['/productsearch']);
    this.api.setId(item.id);

  }
}



